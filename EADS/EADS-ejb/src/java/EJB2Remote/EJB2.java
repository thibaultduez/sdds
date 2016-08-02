/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB2Remote;

import entities.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thibault
 */
@Stateless
public class EJB2 implements EJB2Remote {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JLDSPU");
    private EntityManager em = emf.createEntityManager();

    @Resource
    private SessionContext context;

    @Override
    @RolesAllowed("client")
    public List<Comptes> getComptesClient(BigDecimal clientId) {
        return (List<Comptes>) em.createNamedQuery("Comptes.findByRefClient").setParameter("ref_client", clientId).getSingleResult();
    }

    @Override
    @RolesAllowed("client")
    public Clients verifLogin() {
        Principal callerPrincipal = context.getCallerPrincipal();
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
        //emf.close();
    }

    @Override
    @RolesAllowed("client")
    public boolean transfert(BigDecimal idCompteSource, BigDecimal idCompteDestination, BigInteger montant) {
        //bloquer
        
        try {
            Comptes compteSource = em.find(Comptes.class, idCompteSource);
            Comptes compteDestination = em.find(Comptes.class, idCompteDestination);

            if (compteSource.getSolde().compareTo(montant) >= 0) {
                em.getTransaction().begin();
                compteSource.setSolde(compteSource.getSolde().subtract(montant));
                compteDestination.setSolde(compteDestination.getSolde().add(montant));
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
}
