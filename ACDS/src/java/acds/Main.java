/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acds;

import EJB1Remote.EJB1Remote;
import EJB2Remote.EJB2Remote;
import entities.Clients;
import entities.Comptes;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author thibault
 */
public class Main {

    @EJB
    private static EJB2Remote eJB2;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clients client = eJB2.verifLogin();
        if(client != null) {
            ClientGUI clientGUI = new ClientGUI(client, eJB2);
            clientGUI.setVisible(true);
        } else {
            eJB2.closeEntityManagers();
        }   
    }
    
}
