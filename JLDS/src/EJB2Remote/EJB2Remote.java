/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB2Remote;

import entities.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author thibault
 */
@Remote
public interface EJB2Remote {
    List<Comptes> getComptesClient();

    Clients verifLogin();

    void closeEntityManagers();

    boolean transfert(BigDecimal idCompteSource, BigDecimal idCompteDestination, Double montant);

    boolean clientExist(long idClient);
}
