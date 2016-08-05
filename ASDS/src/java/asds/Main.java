/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asds;

import EJB1Remote.EJB1Remote;
import EJB2Remote.EJB2Remote;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author kevinschorkops
 */
public class Main {

    @Resource(mappedName = "jms/topic")
    private static Topic topic;

    @Resource(mappedName = "jms/topicFactory")
    private static ConnectionFactory topicFactory;
    
    @EJB
    private static EJB1Remote eJB1;
    @EJB
    private static EJB2Remote eJB2;
    
    private static Connection connection = null;
    private static Session session = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            connection = topicFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
        } catch(JMSException e) {
            e.printStackTrace();
        }
        
        String loginSuperviseur = eJB1.getLoginSuperviseur();
        
        SuperviseurGUI superviseurGUI = new SuperviseurGUI(loginSuperviseur, eJB1, eJB2, topic, connection, session);
        superviseurGUI.setVisible(true); 
    }
    
}
