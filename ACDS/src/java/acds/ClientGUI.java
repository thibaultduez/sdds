/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acds;

import EJB2Remote.EJB2Remote;
import entities.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author thibault
 */
public class ClientGUI extends javax.swing.JFrame {

    private EJB2Remote eJB2;

    private Clients client;

    public ClientGUI() {
        initComponents();
    }

    public ClientGUI(Clients client, EJB2Remote eJB2) {
        initComponents();
        this.client = client;
        this.eJB2 = eJB2;

        initGUI();
    }

    private void initGUI() {
        mesComptesSourceCB.setModel(new DefaultComboBoxModel(client.getComptesList().toArray()));
        mesComptesDestinationCB.setModel(new DefaultComboBoxModel(client.getComptesList().toArray()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        compteSourceLabel = new javax.swing.JLabel();
        compteDestinationLabel = new javax.swing.JLabel();
        mesComptesSourceCB = new javax.swing.JComboBox<>();
        mesComptesDestinationCB = new javax.swing.JComboBox<>();
        mesComptesRB = new javax.swing.JRadioButton();
        autreCompteRB = new javax.swing.JRadioButton();
        autreCompteTF = new javax.swing.JTextField();
        montantTF = new javax.swing.JTextField();
        transfererButton = new javax.swing.JButton();
        montantLabel = new javax.swing.JLabel();
        mesComptesLabel = new javax.swing.JLabel();
        autreCompteLabel = new javax.swing.JLabel();
        quitterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        compteSourceLabel.setText("Compte Source");

        compteDestinationLabel.setText("Compte Destination");

        buttonGroup1.add(mesComptesRB);
        mesComptesRB.setSelected(true);
        mesComptesRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesComptesRBActionPerformed(evt);
            }
        });

        buttonGroup1.add(autreCompteRB);
        autreCompteRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autreCompteRBActionPerformed(evt);
            }
        });

        autreCompteTF.setEnabled(false);

        transfererButton.setText("Transferer");
        transfererButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfererButtonActionPerformed(evt);
            }
        });

        montantLabel.setText("Montant :");

        mesComptesLabel.setText("Mes Comptes");

        autreCompteLabel.setText("Autre Compte");

        quitterButton.setText("QUITTER");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(compteSourceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(compteDestinationLabel)
                        .addGap(111, 111, 111))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mesComptesSourceCB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(autreCompteLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mesComptesDestinationCB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autreCompteTF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(autreCompteRB)
                                    .addComponent(mesComptesRB))
                                .addGap(8, 8, 8))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(montantLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transfererButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(montantTF, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mesComptesLabel)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(quitterButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compteSourceLabel)
                    .addComponent(compteDestinationLabel))
                .addGap(9, 9, 9)
                .addComponent(mesComptesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mesComptesSourceCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mesComptesDestinationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mesComptesRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autreCompteLabel)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autreCompteRB)
                    .addComponent(autreCompteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montantTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montantLabel))
                .addGap(18, 18, 18)
                .addComponent(transfererButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(quitterButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesComptesRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesComptesRBActionPerformed
        mesComptesDestinationCB.setEnabled(true);
        autreCompteTF.setEnabled(false);
    }//GEN-LAST:event_mesComptesRBActionPerformed

    private void autreCompteRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autreCompteRBActionPerformed
        mesComptesDestinationCB.setEnabled(false);
        autreCompteTF.setEnabled(true);
    }//GEN-LAST:event_autreCompteRBActionPerformed

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        //eJB2.closeEntityManagers();
        this.dispose();
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void transfererButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfererButtonActionPerformed
        if (!montantTF.getText().isEmpty() || (autreCompteRB.isSelected() && !autreCompteTF.getText().isEmpty())) {
            BigDecimal compteSource = ((Comptes) mesComptesSourceCB.getSelectedItem()).getId();
            BigDecimal compteDestination;
            Double montant = Double.parseDouble(montantTF.getText());
            if (mesComptesRB.isSelected()) {
                compteDestination = ((Comptes) mesComptesDestinationCB.getSelectedItem()).getId();
            } else {
                compteDestination = BigDecimal.valueOf(Long.parseLong(autreCompteTF.getText()));
            }

            if(eJB2.transfert(compteSource, compteDestination, montant))
            {
                List<Comptes> comptes = eJB2.getComptesClient();
                mesComptesSourceCB.setModel(new DefaultComboBoxModel(comptes.toArray()));
                mesComptesDestinationCB.setModel(new DefaultComboBoxModel(comptes.toArray()));
                montantTF.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erreur lors du transfert, solde insuffisant ou compte inexistant", "Erreur transfert" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_transfererButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autreCompteLabel;
    private javax.swing.JRadioButton autreCompteRB;
    private javax.swing.JTextField autreCompteTF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel compteDestinationLabel;
    private javax.swing.JLabel compteSourceLabel;
    private javax.swing.JComboBox<String> mesComptesDestinationCB;
    private javax.swing.JLabel mesComptesLabel;
    private javax.swing.JRadioButton mesComptesRB;
    private javax.swing.JComboBox<String> mesComptesSourceCB;
    private javax.swing.JLabel montantLabel;
    private javax.swing.JTextField montantTF;
    private javax.swing.JButton quitterButton;
    private javax.swing.JButton transfererButton;
    // End of variables declaration//GEN-END:variables
}
