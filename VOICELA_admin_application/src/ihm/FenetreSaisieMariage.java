package ihm;

import accesAuxDonnees.DaoVip;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import metier.Evenement;
import metier.Vip;
import modele.ModeleJTableAddMariage;

public class FenetreSaisieMariage extends javax.swing.JDialog {

    private ModeleJTableAddMariage leModeleAddMariage;
    private boolean etatSortie;
    private Vip vip1;
    private Vip vip2;
    private Evenement evenement;

    public FenetreSaisieMariage(java.awt.Frame parent, Vip leVip, ModeleJTableAddMariage leModeleAddMariage, Evenement evenement) {
        super(parent, true);
        this.leModeleAddMariage = leModeleAddMariage;
        this.vip1 = leVip;
        this.evenement = evenement;
        etatSortie = false;
        initComponents();
        txNumVip.setText(Integer.toString(vip1.getNumVip()));
        txNomVip.setText(vip1.getNomVip());
        txPrenomVip.setText(vip1.getPrenomVip());
        int vip1CodeStatut = vip1.getCodeStatut();
        if (vip1CodeStatut == 0) {
            txStatutVip.setText("Célibataire");
        } else if (vip1CodeStatut == 1) {
            txStatutVip.setText("En couple");
        } else {
            txStatutVip.setText("Divorcé");
        }
        try {
            leModeleAddMariage.chargerLesVipAddMariage();
        } catch (Exception ex) {
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblNomVip = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPrenomVip = new javax.swing.JLabel();
        lblStatutVip = new javax.swing.JLabel();
        txNumVip = new javax.swing.JTextField();
        txNomVip = new javax.swing.JTextField();
        txPrenomVip = new javax.swing.JTextField();
        lblAjoutMariage = new javax.swing.JLabel();
        lblNumVip = new javax.swing.JLabel();
        txStatutVip = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txRechercheNom = new javax.swing.JTextField();
        buttonRecheche = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblDateMariage = new javax.swing.JLabel();
        txDateMariage = new javax.swing.JTextField();
        lblLieuMariage = new javax.swing.JLabel();
        txLieuMariage = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("VIP selectioné");

        lblNomVip.setText("Nom :");

        lblPrenomVip.setText("Prénom :");

        lblStatutVip.setText("Statut :");

        txNumVip.setEditable(false);
        txNumVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNumVipActionPerformed(evt);
            }
        });

        txNomVip.setEditable(false);
        txNomVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomVipActionPerformed(evt);
            }
        });

        txPrenomVip.setEditable(false);

        lblAjoutMariage.setText("Ajout d'un mariage");

        lblNumVip.setText("Numero VIP :");

        txStatutVip.setEditable(false);

        jLabel8.setText("Recherche du conjoint par son nom :");

        txRechercheNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRechercheNomActionPerformed(evt);
            }
        });

        buttonRecheche.setText("Rechercher");
        buttonRecheche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRechecheActionPerformed(evt);
            }
        });

        lblDateMariage.setText("Date du mariage (dd/mm/yyyy) :");

        lblLieuMariage.setText("Lieu mariage :");

        jToggleButton1.setText("Ajouter mariage");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Annuler");

        jTable3.setModel(leModeleAddMariage);
        jScrollPane3.setViewportView(jTable3);

        jLabel6.setText("Affiche des VIP célibataire ou divorcer :");

        jButton1.setText("Réinitialiser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblPrenomVip)
                            .addComponent(lblNumVip)
                            .addComponent(lblNomVip)
                            .addComponent(lblStatutVip))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txPrenomVip)
                                    .addComponent(txNomVip, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txNumVip, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txStatutVip))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(395, 395, 395)
                                        .addComponent(jToggleButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jToggleButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(151, 151, 151)
                                        .addComponent(txLieuMariage))))
                            .addComponent(txDateMariage, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAjoutMariage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLieuMariage)
                            .addComponent(lblDateMariage))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txRechercheNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRecheche)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNumVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumVip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomVip))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPrenomVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrenomVip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txStatutVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatutVip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAjoutMariage)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txRechercheNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRecheche)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDateMariage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateMariage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txLieuMariage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLieuMariage))
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int ligne = jTable3.getSelectedRow();
            if (ligne == -1) {
                throw new Exception("Aucune ligne selectionnée pour le VIP conjoint");
            }
            Vip vip2 = leModeleAddMariage.getVip(ligne);
            evenement.setNumVip(vip1.getNumVip());
            evenement.setNumeroVipConjoint(vip2.getNumVip());

            if (txDateMariage.getText().isEmpty()) {
                throw new Exception("champ date mariage vide");
            }
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(txDateMariage.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            evenement.setDateMariage(sqlDate);

            if (txLieuMariage.getText().isEmpty()) {
                throw new Exception("champ lieu mariage vide");
            }
            evenement.setLieuMariage(txLieuMariage.getText());
            evenement.setDateDivorce(null);

            etatSortie = true;
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur à l'ajout du mariage : " + e.getMessage(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txNumVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNumVipActionPerformed
        // TODO add your handling code here:
        txNumVip.setText(Integer.toString(vip1.getNumVip()));
    }//GEN-LAST:event_txNumVipActionPerformed

    private void txNomVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomVipActionPerformed
        // TODO add your handling code here:
        txNomVip.setText(vip1.getNomVip());
    }//GEN-LAST:event_txNomVipActionPerformed

    private void txRechercheNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRechercheNomActionPerformed
        // TODO add your handling code here:
        txRechercheNom.getText();
    }//GEN-LAST:event_txRechercheNomActionPerformed

    private void buttonRechecheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRechecheActionPerformed
        // TODO add your handling code here:
        try {
            leModeleAddMariage.cleanVip();
            leModeleAddMariage.chargerLesVipAddMariage(txRechercheNom.getText());
        } catch (SQLException ex) {
            Logger.getLogger(FenetreSaisieMariage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonRechecheActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            leModeleAddMariage.cleanVip();
            leModeleAddMariage.chargerLesVipAddMariage();
        } catch (SQLException ex) {
            Logger.getLogger(FenetreSaisieMariage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRecheche;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel lblAjoutMariage;
    private javax.swing.JLabel lblDateMariage;
    private javax.swing.JLabel lblLieuMariage;
    private javax.swing.JLabel lblNomVip;
    private javax.swing.JLabel lblNumVip;
    private javax.swing.JLabel lblPrenomVip;
    private javax.swing.JLabel lblStatutVip;
    private javax.swing.JTextField txDateMariage;
    private javax.swing.JTextField txLieuMariage;
    private javax.swing.JTextField txNomVip;
    private javax.swing.JTextField txNumVip;
    private javax.swing.JTextField txPrenomVip;
    private javax.swing.JTextField txRechercheNom;
    private javax.swing.JTextField txStatutVip;
    // End of variables declaration//GEN-END:variables

    boolean doModal() {
        setVisible(true);
        return etatSortie;
    }
}