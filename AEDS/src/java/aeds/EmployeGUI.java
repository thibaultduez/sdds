/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeds;

import EJB1Remote.EJB1Remote;
import EJB2Remote.EJB2Remote;
import entities.Clients;
import entities.Credits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import util.CurrentTimeId;

/**
 *
 * @author kevinschorkops
 */
public class EmployeGUI extends javax.swing.JFrame implements MessageListener {

    private String loginEmploye;
    private DefaultListModel attenteListModel;
    private DefaultListModel traiteListModel;

    private EJB1Remote eJB1;
    private EJB2Remote eJB2;

    private Topic topic;
    private Connection connection;
    private Session session;

    private MessageProducer producer;
    private MessageConsumer consumer;

    /**
     * Creates new form EmployeGUI
     */
    public EmployeGUI() {
        initComponents();
    }

    public EmployeGUI(String loginEmploye, EJB1Remote eJB1, EJB2Remote eJB2, Topic topic, Connection connection, Session session) {
        initComponents();

        attenteListModel = new DefaultListModel<>();
        traiteListModel = new DefaultListModel<>();
        attenteList.setModel(attenteListModel);
        traiteList.setModel(traiteListModel);

        this.loginEmploye = loginEmploye;

        this.eJB1 = eJB1;
        this.eJB2 = eJB2;

        this.topic = topic;
        this.connection = connection;
        this.session = session;

        try {
            consumer = session.createConsumer(topic, loginEmploye);
            consumer.setMessageListener(this);
            producer = session.createProducer(topic);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        demandeCreditButton = new javax.swing.JButton();
        montantLabel = new javax.swing.JLabel();
        montantTF = new javax.swing.JTextField();
        tauxTF = new javax.swing.JTextField();
        tauxLabel = new javax.swing.JLabel();
        dureeLabel = new javax.swing.JLabel();
        dureeTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        salaireTF = new javax.swing.JTextField();
        chargeLabel = new javax.swing.JLabel();
        chargeTF = new javax.swing.JTextField();
        salaireLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attenteList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        traiteList = new javax.swing.JList<>();
        attenteLabel = new javax.swing.JLabel();
        traiteLabel = new javax.swing.JLabel();
        idClientLabel = new javax.swing.JLabel();
        idClientTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        demandeCreditButton.setText("Demander Crédit");
        demandeCreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandeCreditButtonActionPerformed(evt);
            }
        });

        montantLabel.setText("Montant demandé :");

        tauxLabel.setText("Taux annuel :");

        dureeLabel.setText("Durée du crédit :");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Demande de crédit");

        chargeLabel.setText("Charge totale actuelle :");

        salaireLabel.setText("Salaire total :");

        jScrollPane1.setViewportView(attenteList);

        jScrollPane2.setViewportView(traiteList);

        attenteLabel.setText("Crédit(s) en attente :");

        traiteLabel.setText("Crédit(s) traité(s) :");

        idClientLabel.setText("ID Client :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idClientLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chargeTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tauxLabel)
                            .addComponent(montantLabel)
                            .addComponent(montantTF)
                            .addComponent(tauxTF)
                            .addComponent(dureeLabel)
                            .addComponent(dureeTF)
                            .addComponent(salaireTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(salaireLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chargeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idClientTF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attenteLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(traiteLabel)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(demandeCreditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(idClientLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attenteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(traiteLabel)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idClientTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(montantLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montantTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tauxLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tauxTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dureeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dureeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salaireLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salaireTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chargeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chargeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(demandeCreditButton)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void demandeCreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandeCreditButtonActionPerformed
        if (!idClientTF.getText().isEmpty() && !montantTF.getText().isEmpty() && !tauxTF.getText().isEmpty() && !dureeTF.getText().isEmpty() && !salaireTF.getText().isEmpty() && !chargeTF.getText().isEmpty()) {
            if (eJB2.clientExist(Long.parseLong(idClientTF.getText()))) {
                Credits credit = new Credits();
                credit.setId(CurrentTimeId.nextId());
                credit.setMontant(Double.parseDouble(montantTF.getText()));
                credit.setTaux(Double.parseDouble(tauxTF.getText()));
                credit.setDuree(Integer.parseInt(dureeTF.getText()));
                credit.setSalaire(Double.parseDouble(salaireTF.getText()));
                credit.setChargeCredit(Double.parseDouble(chargeTF.getText()));
                Clients client = new Clients();
                client.setId(BigDecimal.valueOf(Long.parseLong(idClientTF.getText())));
                credit.setRefClient(client);

                attenteListModel.addElement(credit);
                if(!eJB1.demandeCredit(loginEmploye, credit)) {
                    attenteListModel.removeElement(credit);
                }
                clearGUI();
            } else {
                JOptionPane.showMessageDialog(null, "Le client n'existe pas !", "Erreur idClient", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_demandeCreditButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attenteLabel;
    private javax.swing.JList<String> attenteList;
    private javax.swing.JLabel chargeLabel;
    private javax.swing.JTextField chargeTF;
    private javax.swing.JButton demandeCreditButton;
    private javax.swing.JLabel dureeLabel;
    private javax.swing.JTextField dureeTF;
    private javax.swing.JLabel idClientLabel;
    private javax.swing.JTextField idClientTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel montantLabel;
    private javax.swing.JTextField montantTF;
    private javax.swing.JLabel salaireLabel;
    private javax.swing.JTextField salaireTF;
    private javax.swing.JLabel tauxLabel;
    private javax.swing.JTextField tauxTF;
    private javax.swing.JLabel traiteLabel;
    private javax.swing.JList<String> traiteList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            String[] parts = tm.getText().split("#");
            
            Long idCredit;
            boolean accorde;

            if(parts[0].equals("auto_accorde")) {
                idCredit = Long.parseLong(parts[1]);
                accorde = Boolean.parseBoolean(parts[8]);
            } else {
                idCredit = Long.parseLong(parts[1]);
                accorde = Boolean.parseBoolean(parts[2]);
            }
            

            boolean flag = false;
            Credits credit = null;
            for (int i = 0; flag != true && i < attenteListModel.size(); i++) {
                credit = (Credits) attenteListModel.getElementAt(i);
                if (credit.getId().equals(idCredit)) {
                    attenteListModel.remove(i);
                    flag = true;
                }
            }

            if (accorde) {
                traiteListModel.addElement(credit + " ACCORDE");
            } else {
                traiteListModel.addElement(credit + " REFUSE");
            }
        } catch (JMSException ex) {
            Logger.getLogger(EmployeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearGUI() {
        idClientTF.setText("");
        montantTF.setText("");
        tauxTF.setText("");
        dureeTF.setText("");
        salaireTF.setText("");
        chargeTF.setText("");
    }
}
