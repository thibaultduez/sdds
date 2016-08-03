/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeds;

import EJB1Remote.EJB1Remote;
import javax.ejb.EJB;

/**
 *
 * @author kevinschorkops
 */
public class Main {
    
    @EJB
    private static EJB1Remote eJB1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        eJB1.loginEmploye();
        
        EmployeGUI employeGUI = new EmployeGUI(eJB1);
        employeGUI.setVisible(true); 
    }
}
