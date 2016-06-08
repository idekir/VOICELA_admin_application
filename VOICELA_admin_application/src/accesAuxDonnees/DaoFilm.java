package accesAuxDonnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String requete = "INSERT INTO REALISE (numVip, numVisa) VALUES (?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.setInt(2, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void ajouterActeur(int numVisa, int numVip) throws SQLException {
        String requete = "INSERT INTO CASTING (numVip, numVisa) VALUES (?, ?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.setInt(2, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void realisateurPossibleFilm(int numVisa, List<Vip> leConteneurRealisationAjout) throws SQLException {
        String requete = "SELECT VIP.numVip, VIP.nomVip, VIP.PrenomVip, VIP.codeRole FROM VIP WHERE VIP.numVip NOT IN (SELECT REALISE.numVip FROM REALISE WHERE REALISE.numVisa = ?) AND (VIP.codeRole = 2 OR VIP.codeRole = 3)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            int codeRole = rset.getInt(4);
            Vip temp = new Vip(numVip, nomVip, prenomVip, codeRole);
            leConteneurRealisationAjout.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void acteurPossibleFilm(int numVisa, List<Vip> leConteneurRealisationAjout) throws SQLException {
        String requete = "SELECT VIP.numVip, VIP.nomVip, VIP.PrenomVip, VIP.codeRole FROM VIP WHERE VIP.numVip NOT IN (SELECT CASTING.numVip FROM CASTING WHERE CASTING.numVisa = ?) AND (VIP.codeRole = 1 OR VIP.codeRole = 3)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            int numVip = rset.getInt(1);
            String nomVip = rset.getString(2);
            String prenomVip = rset.getString(3);
            int codeRole = rset.getInt(4);
            Vip temp = new Vip(numVip, nomVip, prenomVip, codeRole);
            leConteneurRealisationAjout.add(temp);
        }
        rset.close();
        pstmt.close();
    }

    public void supprimerActeur(int numVisa, int numVip) throws SQLException {
        String requete = "DELETE FROM CASTING WHERE numVip = ? AND numVisa = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.setInt(2, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerRealisateur(int numVisa, int numVip) throws SQLException {
        String requete = "DELETE FROM REALISE WHERE numVip = ? AND numVisa = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVip);
        pstmt.setInt(2, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public int getNumAffiche(int numVisa) throws SQLException {
        String requete = "SELECT numeroSequentielAffiche FROM AFFICHE WHERE numVisa = ? ";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        ResultSet rset = pstmt.executeQuery();
        int result = 0;
        while (rset.next()) {
            result = rset.getInt(1);
        }
        rset.close();
        pstmt.close();
        return result;
    }

    public void ajouterAffiche(int numVisa) throws SQLException {
        String requete = "INSERT INTO AFFICHE (numVisa) VALUES (?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public int getLastNumSeqAffiche() throws SQLException {
        String requete = "SELECT LAST_INSERT_ID(numeroSequentielAffiche) FROM AFFICHE";
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

    public void supprimerAffiche(int numVisa) throws SQLException {
        String requete = "DELETE FROM AFFICHE WHERE numVisa = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void supprimerFilm(int numVisa) throws SQLException {
        String requete = "DELETE FROM FILM WHERE FILM.numVisa = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVisa);
        pstmt.executeUpdate();
        pstmt.close();
    }

}
