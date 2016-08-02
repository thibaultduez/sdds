/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeds;

import EJB1Remote.EJB1Remote;
import entities.Comptes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kevinschorkops
 */
public class EmployeGUI extends javax.swing.JFrame {

    private EJB1Remote eJB1;
    /**
     * Creates new form EmployeGUI
     */
    public EmployeGUI() {
        initComponents();
    }
    
    public EmployeGUI(EJB1Remote eJB1) {
        initComponents();
        this.eJB1 = eJB1;
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
        salairesTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        salairesList = new javax.swing.JList<>();
        addSalaireButton = new javax.swing.JButton();
        chargeLabel = new javax.swing.JLabel();
        chargeTF = new javax.swing.JTextField();
        salairesLabel = new javax.swing.JLabel();

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

        jScrollPane1.setViewportView(salairesList);

        addSalaireButton.setText("Ajouter salaire");
        addSalaireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSalaireButtonActionPerformed(evt);
            }
        });

        chargeLabel.setText("Charge actuelle :");

        salairesLabel.setText("Salaire(s) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chargeLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(chargeTF, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(tauxLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(montantLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(montantTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tauxTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dureeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dureeTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(salairesTF, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(salairesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(demandeCreditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addSalaireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(salairesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salairesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(addSalaireButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chargeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chargeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(demandeCreditButton)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void demandeCreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandeCreditButtonActionPerformed
        if (!montantTF.getText().isEmpty() || !tauxTF.getText().isEmpty() || !dureeTF.getText().isEmpty() || !chargeTF.getText().isEmpty()) {
           /* BigDecimal compteSource = ((Comptes) mesComptesSourceCB.getSelectedItem()).getId();
            BigDecimal compteDestination;
            BigInteger montant = BigInteger.valueOf(Long.parseLong(montantTF.getText()));

            List<long> salaires = salairesList.;
            //List<Comptes> comptes new ArrayList<Comptes>();
            if(eJB1.demandeCredit(Long.parseLong(montantTF.getText()), Long.parseLong(tauxTF.getText()), Long.parseLong(dureeTF.getText()), comptes, Long.parseLong(chargeTF.getText())))
            {
                List<Comptes> comptes = eJB1.getComptesClient();
                mesComptesSourceCB.setModel(new DefaultComboBoxModel(comptes.toArray()));
                mesComptesDestinationCB.setModel(new DefaultComboBoxModel(comptes.toArray()));
                montantTF.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erreur lors du transfert, solde insuffisant ou compte inexistant", "Erreur transfert" , JOptionPane.INFORMATION_MESSAGE);
            }*/
        }
    }//GEN-LAST:event_demandeCreditButtonActionPerformed

    private void addSalaireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSalaireButtonActionPerformed
        //ad in salairesList
    }//GEN-LAST:event_addSalaireButtonActionPerformed

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
    private javax.swing.JButton addSalaireButton;
    private javax.swing.JLabel chargeLabel;
    private javax.swing.JTextField chargeTF;
    private javax.swing.JButton demandeCreditButton;
    private javax.swing.JLabel dureeLabel;
    private javax.swing.JTextField dureeTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel montantLabel;
    private javax.swing.JTextField montantTF;
    private javax.swing.JLabel salairesLabel;
    private javax.swing.JList<String> salairesList;
    private javax.swing.JTextField salairesTF;
    private javax.swing.JLabel tauxLabel;
    private javax.swing.JTextField tauxTF;
    // End of variables declaration//GEN-END:variables
}
