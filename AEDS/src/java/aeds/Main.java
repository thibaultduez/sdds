/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeds;

import EJB1Remote.EJB1Remote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
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
        
        eJB1.loginEmploye();
        
        EmployeGUI employeGUI = new EmployeGUI(eJB1, topic, connection, session);
        employeGUI.setVisible(true); 
    }

    private Message createJMSMessageForjmsTopic(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToTopic(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = topicFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);
            messageProducer.send(createJMSMessageForjmsTopic(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
