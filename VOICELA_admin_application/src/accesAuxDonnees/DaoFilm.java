package accesAuxDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import metier.Film;

public class DaoFilm {

    private final Connection connexion;

    public DaoFilm(Connection connexion) {
        this.connexion = connexion;
    }

    public void lireLesFilm(List<Film> lesFilm) throws SQLException {
        String requete = "select * from FILM";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {       // traitement du résulat
            int numVisa = rset.getInt(1);
            String titreFilm = rset.getString(2);
            int anneeFilm = rset.getInt(3);
            int numGenre = rset.getInt(4);
            Film temp = new Film(numVisa, titreFilm, anneeFilm, numGenre);
            lesFilm.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterFilm(Film film) throws SQLException {
        String requete = "INSERT INTO FILM (numVisa, titreFilm, anneeFilm, numGenre) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, film.getNumVisa());
        pstmt.setString(2, film.getTitreFilm());
        pstmt.setInt(3, film.getAnneeFilm());
        pstmt.setInt(4, film.getNumGenre());

        pstmt.executeUpdate();
        pstmt.close();
    }

    public void chargerGenre(JComboBox jbox1) throws SQLException {
        String requete = "select * from GENRE";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
            String nomGenre = rset.getString(1);
            jbox1.addItem(nomGenre);
        }
        rset.close();
        pstmt.close();
    }

    public int getNumGenre(String genre) throws SQLException {
        String requete = "select numGenre from GENRE WHERE libelleGenre = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, genre);
        
        ResultSet rset = pstmt.executeQuery();
        int numGenre = 0;
        while (rset.next()) {       // traitement du résulat
            numGenre = rset.getInt(1);
        }
        rset.close();
        pstmt.close();
        return numGenre;
    }

    public void lireGenre(List<String[]> leConteneurGenre) throws SQLException{
        String requete = "SELECT * from GENRE";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery();
        
        while (rset.next()) {
            String[] temp = new String[2];
            temp[0] = Integer.toString(rset.getInt(2));
            temp[1] = rset.getString(1);
            leConteneurGenre.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterGenre(String newGenre) throws SQLException{
        String requete = "INSERT INTO GENRE (libelleGenre) VALUES (?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, newGenre);

        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerGenre(String[] stringGenre) throws SQLException {
        String requete = "DELETE FROM GENRE WHERE numGenre = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, Integer.parseInt(stringGenre[0]));
        pstmt.executeUpdate();
        pstmt.close();
    }

}
