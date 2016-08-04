/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB1Remote;

import entities.Credits;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;
import util.CurrentTimeId;

/**
 *
 * @author thibault
 */
@Stateless
@DeclareRoles({"superviseur", "employe"})
public class EJB1 implements EJB1Remote {

    @Resource(mappedName = "jms/topic")
    private Topic topic;

    @Inject
    @JMSConnectionFactory("jms/topicFactory")
    private JMSContext context;

    @Resource
    private SessionContext sessionContext;

    @Override
    public boolean demandeCredit(String loginEmploye, Credits credit) {
        String message = "";

        if (credit.getMontant().doubleValue() < 250000) {
            double tauxMensuel = (Math.pow((1 + credit.getTaux().doubleValue() / 100), (1.0 / 12)) - 1) * 100;
            double chargeCreditSansTaux = (credit.getMontant().doubleValue() / credit.getDuree().intValue());
            double chargeCredit = chargeCreditSansTaux + (chargeCreditSansTaux * (credit.getTaux().doubleValue() / 100));

            if ((chargeCredit + credit.getChargeCredit().doubleValue()) <= ((credit.getSalaire().doubleValue() / 100) * 40)) {
                //message = credit.getId() + "#" + credit.getMontant() + "#" + credit.getTaux() + "#" + credit.getDuree() + "#" + credit.getSalaire() + "#" + (credit.getChargeCredit().doubleValue() + chargeCredit) + "#" + credit.getRefClient().getId() + "#true";
                message = credit.getId() + "#" + "true";
                try {
                    TextMessage tm = context.createTextMessage(message);
                    tm.setBooleanProperty(loginEmploye, true);
                    sendJMSMessageToTopic(tm);
                } catch (JMSException ex) {
                    Logger.getLogger(EJB1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*try {
            TextMessage tm = context.createTextMessage(message);
            tm.setBooleanProperty("toMDB", true);
            sendJMSMessageToTopic(tm);
        } catch (JMSException ex) {
            Logger.getLogger(EJB1.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        return false;
    }

    @Override
    @RolesAllowed("employe")
    public String getLoginEmploye() {
        Principal callerPrincipal = sessionContext.getCallerPrincipal();
        return callerPrincipal.getName();
    }

    private void sendJMSMessageToTopic(TextMessage messageData) {
        context.createProducer().send(topic, messageData);
    }
}
