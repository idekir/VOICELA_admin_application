package ihm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import metier.Vip;

public class FenetreSaisieVip extends javax.swing.JDialog {

    private Vip vip;
    private boolean etatSortie;

    public FenetreSaisieVip(java.awt.Frame parent, Vip vip) {
        super(parent, true);  // mode modal       
        this.vip = vip;
        etatSortie = false;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txNom = new javax.swing.JTextField();
        txPrenom = new javax.swing.JTextField();
        lblPrenom = new javax.swing.JLabel();
        lblCivilite = new javax.swing.JLabel();
        btValid = new javax.swing.JButton();
        lblNom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDateNaiss = new javax.swing.JLabel();
        txDateNaiss = new javax.swing.JTextField();
        lblLieuNaiss = new javax.swing.JLabel();
        txLieuNaiss = new javax.swing.JTextField();
        lblRole = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        cbCivilite = new javax.swing.JComboBox<>();
        lblPays = new javax.swing.JLabel();
        txPays = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saisie d'un employé");

        lblPrenom.setText("Prénom VIP");

        lblCivilite.setText("Civilité");

        btValid.setText("Créer le VIP");
        btValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidActionPerformed(evt);
            }
        });

        lblNom.setText("Nom VIP");

        jLabel1.setText("Nouveau VIP");

        lblDateNaiss.setText("Date naissance (dd/mm/yyyy)");

        txDateNaiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDateNaissActionPerformed(evt);
            }
        });

        lblLieuNaiss.setText("Lieu Naissance");

        lblRole.setText("Role");

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acteur", "Réalisateur", "Acteur/Réalisateur" }));

        cbCivilite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homme", "Femme" }));
        cbCivilite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiviliteActionPerformed(evt);
            }
        });

        lblPays.setText("Pays");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(txNom, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCivilite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDateNaiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblLieuNaiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblRole)
                                    .addComponent(lblPays))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txDateNaiss)
                                    .addComponent(txLieuNaiss)
                                    .addComponent(cbRole, 0, 156, Short.MAX_VALUE)
                                    .addComponent(cbCivilite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txPays)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btValid)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txNom)
                    .addComponent(lblNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCivilite, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCivilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDateNaiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txDateNaiss))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLieuNaiss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txLieuNaiss))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPays)
                    .addComponent(txPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btValid)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidActionPerformed
        // TODO add your handling code here:
        try {
            //nom
            if (txNom.getText().isEmpty()) {
                throw new Exception("champ prenom vide");
            }
            vip.setNomVip(txNom.getText().toUpperCase());

            //prenom
            if (txPrenom.getText().isEmpty()) {
                throw new Exception("champ nom vide");
            }
            String prenom = txPrenom.getText();
            String restePrenom = prenom.substring(1);   //chaine sans la premiere lettre
            String premiereLettre = prenom.substring(0, 1); //recup la premiere lettre
            premiereLettre = premiereLettre.toUpperCase();         // mise en maj
            restePrenom = restePrenom.toLowerCase();
            System.out.println(premiereLettre);
            System.out.println(restePrenom);

            vip.setPrenomVip(premiereLettre + restePrenom);

            //civilite
            String civilite = cbCivilite.getSelectedItem().toString();
            if ("Homme".equals(civilite)) {
                vip.setCivilite("H");
            } else {
                vip.setCivilite("F");
            }
            //date naissance        
            if (txDateNaiss.getText().isEmpty()) {
                throw new Exception("champ date vide");
            }
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(txDateNaiss.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            vip.setDateNaissance(sqlDate);

            //lieu naissance
            if (txLieuNaiss.getText().isEmpty()) {
                throw new Exception("champ lieu naissance vide");
            }
            vip.setLieuNaissance(txLieuNaiss.getText());

            String role = cbRole.getSelectedItem().toString();
            if (null != role) {
                switch (role) {
                    case "Acteur":
                        vip.setCodeRole(1);
                        break;
                    case "Réalisateur":
                        vip.setCodeRole(2);
                        break;
                    default:
                        vip.setCodeRole(3);
                        break;
                }
            }

            if (txPays.getText().isEmpty()) {
                throw new Exception("champ pays vide");
            }
            vip.setNomPays(txPays.getText());

            etatSortie = true;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btValidActionPerformed

    private void cbCiviliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiviliteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbCiviliteActionPerformed

    private void txDateNaissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDateNaissActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDateNaissActionPerformed

    public boolean doModal() {
        setVisible(true);
        return etatSortie;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btValid;
    private javax.swing.JComboBox<String> cbCivilite;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCivilite;
    private javax.swing.JLabel lblDateNaiss;
    private javax.swing.JLabel lblLieuNaiss;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPays;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblRole;
    private javax.swing.JTextField txDateNaiss;
    private javax.swing.JTextField txLieuNaiss;
    private javax.swing.JTextField txNom;
    private javax.swing.JTextField txPays;
    private javax.swing.JTextField txPrenom;
    // End of variables declaration//GEN-END:variables
}