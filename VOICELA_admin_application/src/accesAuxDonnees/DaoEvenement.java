package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Evenement;

public class DaoEvenement {

    private final Connection connexion;

    public DaoEvenement(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void lireLesEvenement(List<Evenement> lesEvenement) throws SQLException {
        String requete = "select * from EVENEMENT";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            Date dateMariage = rset.getDate(1);
            int numVipConjoint = rset.getInt(2);
            String lieuMariage = rset.getString(3);
            Date dateDivorce = rset.getDate(4);
            int numVip = rset.getInt(5);
            Evenement temp = new Evenement(dateMariage, numVipConjoint, lieuMariage, dateDivorce, numVip);
            lesEvenement.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterEvenement(Evenement evenement) throws SQLException {

        String requete = "INSERT INTO EVENEMENT (dateMariage, numVipConjoint, lieuMariage, dateDivorce, numVip) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);

        pstmt.setDate(1, (Date) evenement.getDateMariage());
        pstmt.setInt(2, evenement.getNumVipConjoint());
        pstmt.setString(3, evenement.getLieuMariage());
        pstmt.setDate(4, (Date) evenement.getDateDivorce());
        pstmt.setInt(5, evenement.getNumVip());

        pstmt.executeUpdate();
        pstmt.close();
    }

    public void ajouterDivorce(Evenement divorce) throws SQLException {
        String requete = "UPDATE EVENEMENT SET dateDivorce = ? WHERE dateMariage = ? AND numVip = ? AND numVipConjoint = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);

        pstmt.setDate(1, (Date) divorce.getDateDivorce());
        pstmt.setDate(2, (Date) divorce.getDateMariage());
        pstmt.setInt(3, divorce.getNumVip());
        pstmt.setInt(4, divorce.getNumVipConjoint());

        pstmt.executeUpdate();
        pstmt.close();
    }

    public void lireLesEvenement(List<Evenement> leConteneurEvenement, String text) throws SQLException {
        text = "%" + text + "%";
        String requete = "SELECT * FROM EVENEMENT WHERE numVip IN (SELECT numVip FROM VIP where prenomVip LIKE ? OR nomVip LIKE ?) OR numVipConjoint IN (SELECT numVip FROM VIP where prenomVip LIKE ? OR nomVip LIKE ?) OR lieuMariage LIKE ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, text);
        pstmt.setString(2, text);
        pstmt.setString(3, text);
        pstmt.setString(4, text);
        pstmt.setString(5, text);

        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Date dateMariage = rset.getDate(1);
            int numVipConjoint = rset.getInt(2);
            String lieuMariage = rset.getString(3);
            Date dateDivorce = rset.getDate(4);
            int numVip = rset.getInt(5);
            Evenement temp = new Evenement(dateMariage, numVipConjoint, lieuMariage, dateDivorce, numVip);
            leConteneurEvenement.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void supprimerEvenement(Evenement evenement) throws SQLException {
        String requete = "DELETE FROM EVENEMENT WHERE EVENEMENT.dateMariage = ? AND EVENEMENT.numVip = ? AND EVENEMENT.numVipConjoint = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setDate(1, (Date) evenement.getDateMariage());
        pstmt.setInt(2, evenement.getNumVip());
        pstmt.setInt(3, evenement.getNumVipConjoint());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerEvenementVip(int numVip) throws SQLException {
        String requete = "DELETE FROM EVENEMENT WHERE EVENEMENT.numVip = ? OR EVENEMENT.numVipConjoint = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.setInt(2, numVip);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
