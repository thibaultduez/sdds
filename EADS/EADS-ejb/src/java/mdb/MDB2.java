/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import entities.*;
import java.math.BigDecimal;
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
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "toMDB2 = true")
})
public class MDB2 implements MessageListener {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JLDSPU");
    EntityManager em = emf.createEntityManager();

    public MDB2() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            String[] parts = tm.getText().split("#");

            if (parts[0].equals("auto_accorde") || parts[0].equals("demande")) {
                Credits credit = new Credits();
                credit.setId(Long.parseLong(parts[1]));
                credit.setMontant(Double.parseDouble(parts[2]));
                credit.setTaux(Double.parseDouble(parts[3]));
                credit.setDuree(Integer.parseInt(parts[4]));
                credit.setSalaire(Double.parseDouble(parts[5]));
                credit.setChargeCredit(Double.parseDouble(parts[6]));
                Clients client = new Clients();
                client.setId(BigDecimal.valueOf(Long.parseLong(parts[7])));
                credit.setRefClient(client);
                credit.setAccorde(Boolean.parseBoolean(parts[8]));

                saveCredit(credit);
            }
        } catch (JMSException e) {
            Logger.getLogger(MDB1.class.getName()).log(Logger.Level.ERROR, null, e);
        }
    }

    private void saveCredit(Credits credit) {
        try {
            em.getTransaction().begin();

            em.persist(credit);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(MDB2.class.getName()).log(Logger.Level.ERROR, null, e);
            em.getTransaction().rollback();
        }

    }

}
