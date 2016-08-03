/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.jboss.logging.Logger;

/**
 *
 * @author thibault
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "toMDB1 = true")
})
public class MDB1 implements MessageListener {
    
    public MDB1() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("message : " + tm.getText());
        } catch(JMSException e) {
            Logger.getLogger(MDB1.class.getName()).log(Logger.Level.ERROR, null, e);
        }
    }
    
}
