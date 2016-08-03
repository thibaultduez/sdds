/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB1Remote;

import entities.Clients;
import entities.Comptes;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thibault
 */
@Stateless
//@DeclareRoles("superviseur")
public class EJB1 implements EJB1Remote {

    @Override
    public boolean demandeCredit(long montant, long taux, long duree, java.util.List salaires, long chargeActuelle) {
        return false;
    }
    /*
    @Override
    @RolesAllowed("employe")
    public List<Comptes> getComptesClient(BigDecimal clientId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JLDSPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try {
            Clients client = new Clients ();
            //client.setId(BigDecimal.TEN);
            client.setNom("test");
            client.setPrenom("bibi");
            client.setLogin("sssss");
            em.persist(client);
            em.getTransaction().commit();
            //Clients client2 = em.find(Clients.class, BigDecimal.valueOf(51));
            //System.out.println(client2.toString());
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return null;
    }*/

    @Override
    @RolesAllowed("employe")
    public void loginEmploye() {
    }
}
