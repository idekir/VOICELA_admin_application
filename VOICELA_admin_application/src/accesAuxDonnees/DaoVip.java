package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Vip;

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

    public void ajouterVip(Vip leVip) throws SQLException {
        String requete = "INSERT INTO VIP (`numVip`, `nomVip`, `prenomVip`, `civilite`, `dateNaissance`, `lieuNaissance`, `codeRole`, `codeStatut`, `nomPays`) VALUES (?, '?', '?', '?', '?', '?', ?, ?, '?')";
        PreparedStatement pstmt = connexion.prepareStatement(requete);

        pstmt.setInt(1, leVip.getNumVip());
        pstmt.setString(2, leVip.getNomVip());
        pstmt.setString(3, leVip.getPrenomVip());
        pstmt.setString(4, leVip.getCivilite());
        pstmt.setDate(5, (Date) leVip.getDateNaissance());
        pstmt.setString(6, leVip.getLieuNaissance());
        pstmt.setInt(7, leVip.getCodeRole());
        pstmt.setInt(8, leVip.getCodeStatut());
        pstmt.setString(9, leVip.getNomPays());
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
    
    
}
