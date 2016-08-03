/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB1Remote;

import entities.Comptes;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author thibault
 */
@Remote
public interface EJB1Remote {

    boolean demandeCredit(double montant, double tauxAnnuel, int duree, double salaires, double chargeActuelle);

    void loginEmploye();
    
}
