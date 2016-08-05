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
    @RolesAllowed("employe")
    public boolean demandeCredit(String loginEmploye, Credits credit) {
        TextMessage tm = null;

        double tauxMensuel = (Math.pow((1 + credit.getTaux() / 100), (1.0 / 12)) - 1) * 100;
        double chargeCreditSansTaux = (credit.getMontant() / credit.getDuree());
        double chargeCredit = chargeCreditSansTaux + (chargeCreditSansTaux * (credit.getTaux() / 100));

        String message = "#" + credit.getId() + "#" + credit.getMontant() + "#" + credit.getTaux() + "#" + credit.getDuree() + "#" + credit.getSalaire() + "#" + (credit.getChargeCredit() + chargeCredit) + "#" + credit.getRefClient().getId();

        try {
            if (credit.getMontant() < 250000 && (chargeCredit + credit.getChargeCredit()) <= ((credit.getSalaire() / 100) * 40)) {
                tm = context.createTextMessage("auto_accorde" + message + "#true");
                tm.setBooleanProperty("toMDB1", true);
                tm.setBooleanProperty("toMDB2", true);
                tm.setBooleanProperty("toSuperviseur", true);
                tm.setBooleanProperty(loginEmploye, true);
            } else {
                tm = context.createTextMessage("demande" + message + "#false" + "#" + loginEmploye);
                tm.setBooleanProperty("toMDB1", true);
                tm.setBooleanProperty("toMDB2", true);
                tm.setBooleanProperty("toSuperviseur", true);
            }

            sendJMSMessageToTopic(tm);
        } catch (JMSException ex) {
            Logger.getLogger(EJB1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    @RolesAllowed("employe")
    public String getLoginEmploye() {
        Principal callerPrincipal = sessionContext.getCallerPrincipal();
        return callerPrincipal.getName();
    }

    @Override
    @RolesAllowed("superviseur")
    public String getLoginSuperviseur() {
        Principal callerPrincipal = sessionContext.getCallerPrincipal();
        return callerPrincipal.getName();
    }

    private void sendJMSMessageToTopic(TextMessage messageData) {
        context.createProducer().send(topic, messageData);
    }

    @Override
    @RolesAllowed("superviseur")
    public boolean reponseVerifCredit(String employe, Credits credit) {
        TextMessage tm = null;

        try {
            if (credit.isAccorde()) {
                tm = context.createTextMessage("valid#" + credit.getId() + "#true");
                tm.setBooleanProperty("toMDB1", true);
                tm.setBooleanProperty("toMDB2", true);
                tm.setBooleanProperty(employe, true);
            } else {
                tm = context.createTextMessage("valid#" + credit.getId() + "#false");
                tm.setBooleanProperty("toMDB1", true);
                tm.setBooleanProperty(employe, true);
            }

            sendJMSMessageToTopic(tm);
        } catch (JMSException ex) {
            Logger.getLogger(EJB1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
