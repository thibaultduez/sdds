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
@DeclareRoles({"superviseur", "employe"})
public class EJB1 implements EJB1Remote {

    @Override
    public boolean demandeCredit(double montant, double tauxAnnuel, int duree, double salaires, double chargeActuelle) {

        if (montant < 250000) {
            double tauxMensuel = (Math.pow((1 + tauxAnnuel / 100), (1.0 / 12)) - 1) * 100;
            double chargeCreditSansTaux = (montant / duree);
            double chargeCredit = chargeCreditSansTaux + (chargeCreditSansTaux * (tauxAnnuel / 100));
            if ((chargeCredit + chargeActuelle) <= ((salaires / 100) * 40)) {
                //enregistrer
            }
        }
        
        //envoyer sur le topic message à dest du superviseur
        
        
        return false;
    }

    public int Demande_Credit(int idemp, int idclient, int montant, double taux, int Salaire, int duree, double charge) {

        int C = montant;
        double d = duree;
        double i = taux;
        i = i / 100;
        i = i / 12;
        System.out.println(montant + "--" + d + "--" + taux);
        int value = (int) (((C * i) / (1 - (1 / Math.pow(1 + i, 12 * d)))) + 0.5);
        int chargetotal = (int) (charge + value);
        String credit = idemp + "#" + montant + "#" + taux + "#" + duree + "#" + Salaire + "#" + value + "#" + idclient;
        if (chargetotal < (Salaire / 100 * 40) && montant < 250000) {

        }
        return 1;
    }

    @Override
    @RolesAllowed("employe")
    public void loginEmploye() {
    }
}
