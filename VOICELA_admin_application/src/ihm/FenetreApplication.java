package ihm;

import accesAuxDonnees.DaoEvenement;
import accesAuxDonnees.DaoVip;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metier.Evenement;
import metier.Vip;
import modele.ModeleJTableVip;
import modele.ModeleJTableAddMariage;
import modele.ModeleJTableEvenement;

public class FenetreApplication extends javax.swing.JFrame {

    private ModeleJTableVip leModele;
    private ModeleJTableEvenement leModeleEvenement;
    private DaoVip leDaoVip;
    private DaoEvenement leDaoEvenement;

    public FenetreApplication(ModeleJTableVip leModele, DaoVip leDaoVip, DaoEvenement leDaoEvenement) {
        this.leModele = leModele;
        this.leDaoVip = leDaoVip;
        this.leDaoEvenement = leDaoEvenement;
        this.leModeleEvenement = new ModeleJTableEvenement(leDaoEvenement, leModele);
        // initialisation
        initComponents();
        // affichage
        try {
            leModele.chargerLesVip();
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
        laTable = new javax.swing.JTable();
        jButtonRefresh = new javax.swing.JButton();
        addVip = new javax.swing.JButton();
        deleteVip = new javax.swing.JButton();
        addMariage = new javax.swing.JButton();
        addDivorce = new javax.swing.JButton();
        addPhotoVip = new javax.swing.JButton();
        txRecherche = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Affichage des VIP");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        laTable.setModel(leModele);
        jScrollPane1.setViewportView(laTable);

        jButtonRefresh.setText("Réinitialiser depuis la BDD");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        addVip.setText("Ajouter VIP");
        addVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVipActionPerformed(evt);
            }
        });

        deleteVip.setText("Supprimer VIP");
        deleteVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVipActionPerformed(evt);
            }
        });

        addMariage.setText("Ajouter mariage");
        addMariage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMariageActionPerformed(evt);
            }
        });

        addDivorce.setText("Affichage mariages et Ajout divorce");
        addDivorce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDivorceActionPerformed(evt);
            }
        });

        addPhotoVip.setText("Gestion photo VIP");
        addPhotoVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhotoVipActionPerformed(evt);
            }
        });

        jLabel1.setText("Recherche par nom :");

        jLabel2.setText("Pour la ligne selectionnée :");

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gestion des films");

        jLabel3.setText("Fonctions supplémentaires :");

        jToggleButton1.setText("Gestion des réalisations");

        jToggleButton2.setText("Gestion des genres (films)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addPhotoVip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMariage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteVip))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addVip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addDivorce)))
                        .addGap(0, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRefresh, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPhotoVip)
                    .addComponent(addMariage)
                    .addComponent(deleteVip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addVip)
                    .addComponent(addDivorce))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vraiment sortir ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            
            this.dispose();
            
            
            
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        try {
            leModele.cleanVip();
            leModele.chargerLesVip();
        } catch (Exception ex) {
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void addVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVipActionPerformed
        // TODO add your handling code here:
        try {
            Vip vip = new Vip();
            FenetreSaisieVip laSaisie = new FenetreSaisieVip(this, vip);
            if (laSaisie.doModal() == true) {
                leModele.insererVip(vip);
                leModele.cleanVip();
                leModele.chargerLesVip();
            }
        } catch (Exception e) {
            System.out.println("Exception à l'insertion : " + e.getMessage());
        }
    }//GEN-LAST:event_addVipActionPerformed

    private void deleteVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVipActionPerformed
        // TODO add your handling code here:
        try {
            int ligne = laTable.getSelectedRow();
            Vip vip = leModele.getVip(ligne);
            int comfirm = JOptionPane.showConfirmDialog(this, "Comfirmer suppression de : " + vip.getPrenomVip() + " " + vip.getNomVip() + " ?", "Avertissement", JOptionPane.YES_NO_OPTION);
            if (comfirm == 0) {
                leModele.supprimerVip(ligne);
            }

        } catch (Exception e) {
            System.out.println("Exception à la suppression : " + e.getMessage());
        }
    }//GEN-LAST:event_deleteVipActionPerformed

    private void addPhotoVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhotoVipActionPerformed
        // TODO add your handling code here:
        try {
            if (laTable.getSelectedRow() == -1) {
                throw new Exception("Aucune ligne VIP selectionnée");
            }
            int ligne = laTable.getSelectedRow();
            Vip vip = leModele.getVip(ligne);

            FenetreSaisiePhoto laSaisiePhoto = new FenetreSaisiePhoto(this, vip, leDaoVip);
            
            if (laSaisiePhoto.doModal() == true) {
                JOptionPane.showMessageDialog(null, "Photo VIP changée avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new Exception("Erreur à l'insertion du mariage");
            }

        } catch (Exception e) {
            System.out.println("Exception à l'insertion : " + e.getMessage());
        }

    }//GEN-LAST:event_addPhotoVipActionPerformed

    private void addMariageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMariageActionPerformed
        // TODO add your handling code here:
        try {
            if (laTable.getSelectedRow() == -1) {
                throw new Exception("Aucune ligne VIP selectionnée");
            }

            int ligne = laTable.getSelectedRow();
            Vip vip = leModele.getVip(ligne);
            if (vip.getCodeStatut() == 1) {
                throw new Exception("VIP déjà marié");
            }

            Evenement evenement = new Evenement();

            FenetreSaisieMariage laSaisie = new FenetreSaisieMariage(this, vip, new ModeleJTableAddMariage(leDaoVip), evenement);
            if (laSaisie.doModal() == true) {
                leModeleEvenement.insererEvenement(evenement);
                JOptionPane.showMessageDialog(null, "Mariage ajouté avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
                leModele.cleanVip();
                leModele.chargerLesVip();
            } else {
                throw new Exception("Erreur à l'insertion du mariage");
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());

        }


    }//GEN-LAST:event_addMariageActionPerformed

    private void addDivorceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDivorceActionPerformed
        // TODO add your handling code here:

        FenetreEvenement laFenetre = new FenetreEvenement(this, new ModeleJTableEvenement(leDaoEvenement, leModele));
        if (laFenetre.doModal() == true) {

        }

    }//GEN-LAST:event_addDivorceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            leModele.cleanVip();
            leModele.chargerLesVip(txRecherche.getText());

        } catch (SQLException ex) {
            Logger.getLogger(FenetreSaisieMariage.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDivorce;
    private javax.swing.JButton addMariage;
    private javax.swing.JButton addPhotoVip;
    private javax.swing.JButton addVip;
    private javax.swing.JButton deleteVip;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTable laTable;
    private javax.swing.JTextField txRecherche;
    // End of variables declaration//GEN-END:variables
}
