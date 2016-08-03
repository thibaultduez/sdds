/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB1Remote;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;

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

    @Override
    public boolean demandeCredit(double montant, double tauxAnnuel, int duree, double salaires, double chargeActuelle) {

        try {
            TextMessage tm = context.createTextMessage("BITE POILS couilles");
            tm.setBooleanProperty("toEmploye", true);
            sendJMSMessageToTopic(tm);
        } catch (JMSException ex) {
            Logger.getLogger(EJB1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*if (montant < 250000) {
            double tauxMensuel = (Math.pow((1 + tauxAnnuel / 100), (1.0 / 12)) - 1) * 100;
            double chargeCreditSansTaux = (montant / duree);
            double chargeCredit = chargeCreditSansTaux + (chargeCreditSansTaux * (tauxAnnuel / 100));
            if ((chargeCredit + chargeActuelle) <= ((salaires / 100) * 40)) {
                //enregistrer
            }
        }*/
        
        //envoyer sur le topic message à dest du superviseur
        
        
        return false;
    }

    @Override
    @RolesAllowed("employe")
    public void loginEmploye() {
    }

    private void sendJMSMessageToTopic(TextMessage messageData) {
        context.createProducer().send(topic, messageData);
    }
}
