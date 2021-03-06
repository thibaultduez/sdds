/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB2Remote;

import EJB1Remote.EJB1;
import entities.*;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thibault
 */
@Stateless
@DeclareRoles("client")
public class EJB2 implements EJB2Remote {

    @Resource(mappedName = "jms/topic")
    private Topic topic;

    @Inject
    @JMSConnectionFactory("jms/topicFactory")
    private JMSContext context;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JLDSPU");
    EntityManager em = emf.createEntityManager();

    @Resource
    private SessionContext sessionContext;

    @Override
    @RolesAllowed("client")
    public List<Comptes> getComptesClient() {
        Principal callerPrincipal = sessionContext.getCallerPrincipal();
        String login = callerPrincipal.getName();
        Clients cli = (Clients) em.createNamedQuery("Clients.findByLogin").setParameter("login", login).getSingleResult();
        return cli.getComptesList();
        //return (List<Comptes>) em.createNamedQuery("Comptes.findByRefClient").setParameter("ref_client", clientId).getSingleResult();
    }

    @Override
    @RolesAllowed("client")
    public Clients verifLogin() {
        Principal callerPrincipal = sessionContext.getCallerPrincipal();
        String login = callerPrincipal.getName();
        try {
            return (Clients) em.createNamedQuery("Clients.findByLogin").setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void closeEntityManagers() {
        em.close();
        emf.close();
    }

    @Override
    @RolesAllowed("client")
    public boolean transfert(BigDecimal idCompteSource, BigDecimal idCompteDestination, Double montant) {
        //bloquer
        try {
            Comptes compteSource = em.find(Comptes.class, idCompteSource);
            Comptes compteDestination = em.find(Comptes.class, idCompteDestination);

            if (compteSource.getSolde().compareTo(montant) >= 0) {
                em.getTransaction().begin();
                compteSource.setSolde(compteSource.getSolde() - montant);
                compteDestination.setSolde(compteDestination.getSolde() + montant);

                TextMessage tm = context.createTextMessage("transaction#" + montant + "#" + compteSource.getId() + "#" + compteDestination.getId());
                tm.setBooleanProperty("toMDB1", true);
                tm.setBooleanProperty("toSuperviseur", true);

                sendJMSMessageToTopic(tm);
            } else {
                return false;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        //debloquer
        return true;
    }

    @Override
    public boolean clientExist(long idClient) {
        try {
            Clients client = em.find(Clients.class, BigDecimal.valueOf(idClient));
            return client != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void sendJMSMessageToTopic(TextMessage messageData) {
        context.createProducer().send(topic, messageData);
    }
}
