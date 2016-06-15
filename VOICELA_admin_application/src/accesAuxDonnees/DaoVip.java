package accesAuxDonnees;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextPane;
import metier.Photo;
import metier.Vip;
import org.apache.commons.net.ftp.FTPSClient;

public class DaoVip {

    private final Connection connexion;

    public DaoVip(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void lireLesVip(List<Vip> lesVip) throws SQLException {
        String requete = "select * from VIP";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            String civilite = rset.getString(4);
            Date dateNaissance = rset.getDate(5);
            String lieuNaissance = rset.getString(6);
            int codeRole = rset.getInt(7);
            int codeStatut = rset.getInt(8);
            String nomPays = rset.getString(9);
            Vip temp = new Vip(numVip, nomVip, prenomVip, civilite, dateNaissance, lieuNaissance, codeRole, codeStatut, nomPays);
            lesVip.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void lireLesVip(List<Vip> lesVip, String nom) throws SQLException {
        nom = "%" + nom + "%";
        String requete = "SELECT * FROM VIP WHERE nomVip LIKE ? OR prenomVip LIKE ? OR lieuNaissance LIKE ? OR nomPays LIKE ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, nom);
        pstmt.setString(2, nom);
        pstmt.setString(3, nom);
        pstmt.setString(4, nom);

        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            String civilite = rset.getString(4);
            Date dateNaissance = rset.getDate(5);
            String lieuNaissance = rset.getString(6);
            int codeRole = rset.getInt(7);
            int codeStatut = rset.getInt(8);
            String nomPays = rset.getString(9);
            Vip temp = new Vip(numVip, nomVip, prenomVip, civilite, dateNaissance, lieuNaissance, codeRole, codeStatut, nomPays);
            lesVip.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterVip(Vip leVip) throws SQLException {
        String requete = "INSERT INTO VIP (nomVip, prenomVip, civilite, dateNaissance, lieuNaissance, codeRole, codeStatut, nomPays, numVip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);

        pstmt.setString(1, leVip.getNomVip());
        pstmt.setString(2, leVip.getPrenomVip());
        pstmt.setString(3, leVip.getCivilite());
        pstmt.setDate(4, (Date) leVip.getDateNaissance());
        pstmt.setString(5, leVip.getLieuNaissance());
        pstmt.setInt(6, leVip.getCodeRole());
        pstmt.setInt(7, leVip.getCodeStatut());
        pstmt.setString(8, leVip.getNomPays());
        pstmt.setInt(9, leVip.getNumVip());

        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerVip(int numVip) throws SQLException {
        String requete = "DELETE FROM VIP WHERE numVip = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void lireLesVipCodeStatut(List<Vip> leConteneurAddMariage) throws SQLException {
        String requete = "SELECT * FROM VIP WHERE codeStatut = 0 OR codeStatut = 2";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            String civilite = rset.getString(4);
            Date dateNaissance = rset.getDate(5);
            String lieuNaissance = rset.getString(6);
            int codeRole = rset.getInt(7);
            int codeStatut = rset.getInt(8);
            String nomPays = rset.getString(9);
            Vip temp = new Vip(numVip, nomVip, prenomVip, civilite, dateNaissance, lieuNaissance, codeRole, codeStatut, nomPays);
            leConteneurAddMariage.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void lireLesVipCodeStatut(List<Vip> leConteneurAddMariage, String nom) throws SQLException {

        nom = "%" + nom + "%";
        String requete = "SELECT * FROM VIP WHERE nomVip LIKE ? AND ( codeStatut = 0 OR codeStatut = 2 )";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, nom);

        //System.out.println(pstmt.toString());
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            String civilite = rset.getString(4);
            Date dateNaissance = rset.getDate(5);
            String lieuNaissance = rset.getString(6);
            int codeRole = rset.getInt(7);
            int codeStatut = rset.getInt(8);
            String nomPays = rset.getString(9);
            Vip temp = new Vip(numVip, nomVip, prenomVip, civilite, dateNaissance, lieuNaissance, codeRole, codeStatut, nomPays);
            leConteneurAddMariage.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterPhotoVip(Vip vip, Date datePhoto, String lieuPhoto) throws SQLException {
        String requete = "INSERT INTO PHOTO (datePhoto, lieuPhoto, numVip) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setDate(1, datePhoto);
        pstmt.setString(2, lieuPhoto);
        pstmt.setInt(3, vip.getNumVip());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public int getLastNumSeq() throws SQLException {
        String requete = "SELECT LAST_INSERT_ID(numeroSequentiel) FROM PHOTO";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        int lastNumSeq = -1;

        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            lastNumSeq = rset.getInt(1);
        }
        rset.close();
        pstmt.close();
        return lastNumSeq;
    }

    public boolean checkPays(String nomPays) throws SQLException {
        String requete = "SELECT * FROM PAYS WHERE nomPays = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete,ResultSet.TYPE_SCROLL_INSENSITIVE);
        pstmt.setString(1, nomPays);

        int nbRset = 0;
        ResultSet rset = pstmt.executeQuery();
        if(rset != null){
            rset.last();
            nbRset = rset.getRow();
        }
        rset.close();
        pstmt.close();
        if(nbRset >=1){
            return true;
        }
        return false;
        
    }

    public void addPays(String nomPays) throws SQLException {
        System.out.println("test addPays");
        String requete = "INSERT INTO PAYS (nomPays) VALUES (?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, nomPays);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void lirePhotoVip(int numVip, List<Photo> leConteneurPhoto) throws SQLException {
        String requete = "SELECT numeroSequentiel, datePhoto, lieuPhoto FROM PHOTO WHERE numVip = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numeroSequentiel = rset.getInt(1);
            Date datePhoto = rset.getDate(2);
            String lieuPhoto = rset.getString(3);
            Photo temp = new Photo(numeroSequentiel, numVip, datePhoto, lieuPhoto);
            leConteneurPhoto.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void supprimerPhoto(Vip vip, int fileName) throws SQLException {
        String requete = "DELETE FROM PHOTO WHERE numVip = ? AND numeroSequentiel = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, vip.getNumVip());
        pstmt.setInt(2, fileName);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void setPhotoPrincipale(Vip vip, Photo photo) throws SQLException {
        String requete = "UPDATE VIP SET photoD = ? WHERE numVip = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);

        pstmt.setInt(1, photo.getNumeroSequentiel());
        pstmt.setInt(2, vip.getNumVip());

        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerPhotoVip(Vip vip, FTPSClient ftp) throws SQLException, IOException {
        String requete = "SELECT numeroSequentiel FROM PHOTO WHERE numVip = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, vip.getNumVip());
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numeroSequentiel = rset.getInt(1);
            ftp.deleteFile("/public_html/VOICELA/assets/images/VIP/" + numeroSequentiel + ".jpeg");
        }
        rset.close();
        pstmt.close();
    }

    public void chargerCommentaire(int numVip, JTextPane jTextPane1) throws SQLException {
        String requete = "SELECT texte FROM TEXTVIP WHERE numVip = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            String commentaire = rset.getString(1);
            jTextPane1.setText(commentaire);
        }
        rset.close();
        pstmt.close();
    }

    public void modifierCommentaire(int numVip, String text) throws SQLException {
        String requete = "UPDATE TEXTVIP SET texte = ? WHERE numVip = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);

        pstmt.setString(1, text);
        pstmt.setInt(2, numVip);

        pstmt.executeUpdate();
        pstmt.close();
    }

    public boolean commentExist(int numVip) throws SQLException {
        String requete = "SELECT COUNT(*) FROM TEXTVIP WHERE numVip = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        ResultSet rset = pstmt.executeQuery();
        int resultat = 0;
        while (rset.next()) {
            resultat = rset.getInt(1);
        }
        rset.close();
        pstmt.close();
        if (resultat > 0) {
            return true;
        }
        return false;
    }

    public void addComment(int numVip) throws SQLException {
        String requete = "INSERT INTO TEXTVIP(numVip) VALUES (?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.executeUpdate();
        pstmt.close();
    }

}
