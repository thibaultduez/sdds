/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import entities.Logs;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jboss.logging.Logger;

/**
 *
 * @author thibault
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/topic"),
    //@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "toMDB1 = true")
})
public class MDB1 implements MessageListener {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JLDSPU");
    EntityManager em = emf.createEntityManager();

    public MDB1() {
    }

    @Override
    public void onMessage(Message message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        
        try {
            TextMessage tm = (TextMessage) message;

            em.getTransaction().begin();

            Logs log = new Logs();
            log.setInfos(sdf.format(calendar.getTime()) + " : " + tm.getText());
            em.persist(log);

            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(MDB1.class.getName()).log(Logger.Level.ERROR, null, e);
            em.getTransaction().rollback();
        }
    }

}
