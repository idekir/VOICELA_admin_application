package ihm;

import accesAuxDonnees.DaoVip;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import metier.Photo;
import metier.Vip;
import modele.ModeleJTablePhoto;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;

public class FenetreSaisiePhoto extends javax.swing.JDialog {

    private final Vip vip;
    private String fileChoosed = null;
    private String filePath = null;
    private DaoVip leDaoVip;
    private ModeleJTablePhoto leModelePhoto;
    private FTPSClient ftp;
    private Photo photo;

    public FenetreSaisiePhoto(java.awt.Frame parent, Vip vip, DaoVip leDaoVip, FTPSClient ftp) {
        super(parent, true);
        this.vip = vip;
        this.leDaoVip = leDaoVip;
        leModelePhoto = new ModeleJTablePhoto(leDaoVip);
        this.ftp = ftp;

        initComponents();

        txNomVip.setText(vip.getNomVip());
        txPrenomVip.setText(vip.getPrenomVip());
        txNumVip.setText(Integer.toString(vip.getNumVip()));

        try {
            leModelePhoto.chargerPhotoVip(vip.getNumVip());

        } catch (Exception e) {
            Logger.getLogger(FenetreSaisieMariage.class.getName()).log(Level.SEVERE, null, e);
        }
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNomVip = new javax.swing.JTextField();
        txPrenomVip = new javax.swing.JTextField();
        txNumVip = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        txDatePhoto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txLieuPhoto = new javax.swing.JTextField();
        buttonUpload = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ajout d'une Photo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vip selectionné"));

        jLabel2.setText("Nom VIP :");

        jLabel3.setText("Prénom VIP :");

        jLabel4.setText("Numéro  VIP :");

        txNomVip.setEditable(false);

        txPrenomVip.setEditable(false);
        txPrenomVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrenomVipActionPerformed(evt);
            }
        });

        txNumVip.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNumVip))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(txNomVip))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(txPrenomVip)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNomVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txPrenomVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNumVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Charger une nouvelle Photo"));

        jButton1.setText("Selectionner photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);

        jLabel11.setText("Entrer Date Photo (dd/mm/yyyy) :");

        jLabel12.setText("Entrer Lieu Photo :");

        buttonUpload.setText("Upload");
        buttonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txDatePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(txLieuPhoto, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonUpload)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txDatePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txLieuPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(buttonUpload))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Photos du VIP"));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(leModelePhoto);
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("nbPhotoVip");

        jButton2.setText("Afficher / Modifier photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Date Photo :");

        jLabel7.setText("Lieu Photo :");

        jButton4.setText("Supprimer photo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Définir comme photo principale");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(147, 147, 147))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txPrenomVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrenomVipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrenomVipActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg", "jpeg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            fileChoosed = chooser.getSelectedFile().getName();
            filePath = chooser.getSelectedFile().getAbsolutePath();
        }
        jTextField4.setText(fileChoosed);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUploadActionPerformed
        // TODO add your handling code here:
        try {
            if (filePath == null) {
                throw new Exception("Aucune photo selectionée");
            }
            if (txDatePhoto.getText().isEmpty()) {
                throw new Exception("Champ date photo vide");
            }

            if (txLieuPhoto.getText().isEmpty()) {
                throw new Exception("Champ lieu photo vide");
            }
            String lieuPhoto = txLieuPhoto.getText();
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(txDatePhoto.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            //insertion bdd
            leDaoVip.ajouterPhotoVip(vip, sqlDate, lieuPhoto);
            int fileNum = leDaoVip.getLastNumSeq();
            String fileName = Integer.toString(fileNum);

            //ftp connexion
            FileInputStream fichier;
            fichier = new FileInputStream("src/connexionFTP.properties");
            Properties props = new Properties();
            props.load(fichier);

            ftp.connect("iutdoua-samba.univ-lyon1.fr", 990);
            if (!ftp.login(props.getProperty("username"), props.getProperty("password"))) {
                throw new Exception("Problème de login au serveur");
            }
            boolean testConnexion = ftp.sendNoOp();
            if (testConnexion == false) {
                throw new Exception("Echec de la connexion au serveur");
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();

            //ftp traitement
            InputStream input = new FileInputStream(new File(filePath));

            try {
                if (ftp.storeFile("/public_html/VOICELA/assets/images/VIP/" + fileName + ".jpeg", input)) {
                    String remoteFile = "/public_html/VOICELA/assets/images/VIP/" + photo.getNumeroSequentiel() + ".jpeg";
                    FileOutputStream outStream = new FileOutputStream("/temp.jpeg");

                    ftp.retrieveFile(remoteFile, outStream);
                    JOptionPane.showMessageDialog(null, "Photo VIP ajoutée avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    throw new Exception("storeFile a retourner false");
                }
            } catch (Exception e) {
                leDaoVip.supprimerPhoto(vip, fileNum);
                JOptionPane.showMessageDialog(null, "Problème à l'upload du fichier, Veuillez réessayer ! : " + e.getMessage(), "Avertissement", JOptionPane.INFORMATION_MESSAGE);
            }
            leModelePhoto.chargerPhotoVip(vip.getNumVip());
            ftp.disconnect();
            
        } catch (Exception e) {
            try {
                ftp.disconnect();
            } catch (IOException ex) {
                Logger.getLogger(FenetreSaisiePhoto.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(null, "Photo VIP ajoutée avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_buttonUploadActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if (jTable1.getSelectedRow() == -1) {
                throw new Exception("Aucune ligne photo selectionnée");
            }
            int ligne = jTable1.getSelectedRow();
            photo = leModelePhoto.getPhoto(ligne);

            jTextField1.setText(photo.getDatePhoto().toString());
            jTextField2.setText(photo.getLieuPhoto());
            
            //ftp connexion
            FileInputStream fichier;
            fichier = new FileInputStream("src/connexionFTP.properties");
            Properties props = new Properties();
            props.load(fichier);

            ftp.connect("iutdoua-samba.univ-lyon1.fr", 990);
            if (!ftp.login(props.getProperty("username"), props.getProperty("password"))) {
                throw new Exception("Problème de login au serveur");
            }
            boolean testConnexion = ftp.sendNoOp();
            if (testConnexion == false) {
                throw new Exception("Echec de la connexion au serveur");
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();

            //File laPhoto = new File();
            String remoteFile = "/public_html/VOICELA/assets/images/VIP/" + photo.getNumeroSequentiel() + ".jpeg";
            FileOutputStream outStream = new FileOutputStream("/temp.jpeg");

            ftp.retrieveFile(remoteFile, outStream);
            outStream.flush();
            outStream.close();

            ImageIcon image = new ImageIcon(new ImageIcon("/temp.jpeg").getImage().getScaledInstance(450, 367, Image.SCALE_DEFAULT));
            jLabel1.setIcon(image);
            ftp.disconnect();

        } catch (Exception e) {
            try {
                ftp.disconnect();
            } catch (IOException ex) {
                Logger.getLogger(FenetreSaisiePhoto.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            //ftp connexion
            FileInputStream fichier;
            fichier = new FileInputStream("src/connexionFTP.properties");
            Properties props = new Properties();
            props.load(fichier);

            ftp.connect("iutdoua-samba.univ-lyon1.fr", 990);
            if (!ftp.login(props.getProperty("username"), props.getProperty("password"))) {
                throw new Exception("Problème de login au serveur");
            }
            boolean testConnexion = ftp.sendNoOp();
            if (testConnexion == false) {
                throw new Exception("Echec de la connexion au serveur");
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();

            boolean resultat = ftp.deleteFile("/public_html/VOICELA/assets/images/VIP/" + photo.getNumeroSequentiel() + ".jpeg");
            if (resultat) {
                leDaoVip.supprimerPhoto(vip, photo.getNumeroSequentiel());
                System.out.println("Le Fichier a été supprimé");
            } else {
                System.out.println("Impossible de supprimer le fichier");
            }
            leModelePhoto.chargerPhotoVip(vip.getNumVip());
            jLabel1.setIcon(null);
            jTextField1.setText("");
            jTextField2.setText("");
            photo = null;
            ftp.disconnect();

        } catch (Exception e) {
            try {
                ftp.disconnect();
            } catch (IOException ex) {
                Logger.getLogger(FenetreSaisiePhoto.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            leDaoVip.setPhotoPrincipale(vip, photo);
        } catch (Exception e) {
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonUpload;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField txDatePhoto;
    private javax.swing.JTextField txLieuPhoto;
    private javax.swing.JTextField txNomVip;
    private javax.swing.JTextField txNumVip;
    private javax.swing.JTextField txPrenomVip;
    // End of variables declaration//GEN-END:variables

}
