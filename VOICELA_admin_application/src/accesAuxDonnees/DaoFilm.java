package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import metier.Film;
import metier.Genre;
import metier.Vip;

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
    
    public void lireLesFilm(List<Film> leConteneurFilm, String text) throws SQLException {
        text = "%" + text + "%";
        String requete = "SELECT * FROM FILM WHERE titreFilm LIKE ? OR numVisa LIKE ? OR anneeFilm LIKE ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, text);
        pstmt.setString(2, text);
        pstmt.setString(3, text);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {       // traitement du résulat
            int numVisa = rset.getInt(1);
            String titreFilm = rset.getString(2);
            int anneeFilm = rset.getInt(3);
            int numGenre = rset.getInt(4);
            Film temp = new Film(numVisa, titreFilm, anneeFilm, numGenre);
            leConteneurFilm.add(temp);
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

    public void lireGenre(List<Genre> leConteneurGenre) throws SQLException {
        String requete = "SELECT * from GENRE";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Genre genre = new Genre();
            genre.setNumGenre(rset.getInt(2));
            genre.setNomGenre(rset.getString(1));
            leConteneurGenre.add(genre);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterGenre(String newGenre) throws SQLException {
        String requete = "INSERT INTO GENRE (libelleGenre) VALUES (?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, newGenre);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerGenre(Genre genre) throws SQLException {
        String requete = "DELETE FROM GENRE WHERE numGenre = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, genre.getNumGenre());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void chargerGenre(List<Genre> leConteneurGenre) throws SQLException {
        String requete = "SELECT * from GENRE";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Genre genre = new Genre();
            genre.setNumGenre(rset.getInt(2));
            genre.setNomGenre(rset.getString(1));
            leConteneurGenre.add(genre);
        }
        rset.close();
        pstmt.close();
    }

    public void lireActeurFilm(int numVisa, List<Vip> lesActeurs) throws SQLException {
        String requete = "SELECT numVip, nomVip, PrenomVip, codeRole FROM VIP WHERE VIP.numVip IN (SELECT CASTING.numVip FROM CASTING WHERE CASTING.numVisa = ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            int codeRole = rset.getInt(4);
            Vip temp = new Vip(numVip, nomVip, prenomVip, codeRole);
            lesActeurs.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void lireRealisateurFilm(int numVisa, List<Vip> lesRealisateurs) throws SQLException {
        String requete = "SELECT numVip, nomVip, PrenomVip, codeRole FROM VIP WHERE VIP.numVip IN (SELECT REALISE.numVip FROM REALISE WHERE REALISE.numVisa = ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            int codeRole = rset.getInt(4);
            Vip temp = new Vip(numVip, nomVip, prenomVip, codeRole);
            lesRealisateurs.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void ajouterRealisateur(int numVisa, int numVip) throws SQLException {
        String requete = "INSERT INTO REALISE (numVisa, numVip) VALUES (?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        pstmt.setInt(2, numVip);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void ajouterActeur(int numVisa, int numVip) throws SQLException {
        String requete = "INSERT INTO CASTING (numVisa, numVip) VALUES (?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        pstmt.setInt(2, numVip);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void selectionnerRealisateurPossible(int numVisa) throws SQLException {
        
    }

    public void selectionnerActeurPossible(int numVisa) {

    }

}
