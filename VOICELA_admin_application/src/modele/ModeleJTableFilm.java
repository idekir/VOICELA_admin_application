package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import metier.Film;

public class ModeleJTableFilm extends AbstractTableModel {

    private List<Film> leConteneurFilm;
    private ModeleJTableGenreFilm leModeleGenre;
    private String[] titre;
    private DaoFilm leDaoFilm;

    public ModeleJTableFilm(DaoFilm leDaoFilm, ModeleJTableGenreFilm leModeleGenre) throws SQLException {
        this.leDaoFilm = leDaoFilm;
        this.leModeleGenre = leModeleGenre;
        this.leConteneurFilm = new ArrayList<>();
        this.titre = new String[]{"Numéro visa", "Titre du film", "Année", "Genre"};
    }

    @Override
    public int getRowCount() {
        return leConteneurFilm.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Film film = leConteneurFilm.get(row);

        if (column == 0) {
            return film.getNumVisa();
        } else if (column == 1) {
            return film.getTitreFilm();
        } else if (column == 2) {
            return film.getAnneeFilm();
        } else {
            return leModeleGenre.getNomGenre(film.getNumGenre());
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerLesFilm() throws SQLException {
        leConteneurFilm.clear();
        leDaoFilm.lireLesFilm(leConteneurFilm);
        fireTableDataChanged();
    }

    public void ajouterFilm(Film film) throws SQLException {
        leDaoFilm.ajouterFilm(film);
        leConteneurFilm.add(film);
        fireTableDataChanged();
    }

    public void chargerLesFilm(String text) throws SQLException {
        leConteneurFilm.clear();
        leDaoFilm.lireLesFilm(leConteneurFilm, text);
        fireTableDataChanged();
    }

    public int getNbFilm() {
        return leConteneurFilm.size();
    }

    public Film getFilm(int ligne) {
        return leConteneurFilm.get(ligne);
    }

    public void ajouterRealisateur(int numVisa, int numVip) throws SQLException {
        leDaoFilm.ajouterRealisateur(numVisa,numVip);
    }

    public void ajouterActeur(int numVisa, int numVip) throws SQLException {
        leDaoFilm.ajouterActeur(numVisa,numVip);
    }

    public void supprimerRealisateur(int numVip, int numVisa) throws SQLException {
        leDaoFilm.supprimerRealisateur(numVisa,numVip);
    }

    public void supprimerActeur(int numVip, int numVisa) throws SQLException {
        leDaoFilm.supprimerActeur(numVisa,numVip);
    }

    public int getNumAffiche(int numVisa) throws SQLException {
        return leDaoFilm.getNumAffiche(numVisa);
    }

    public void ajouterAfficheFilm(int numVisa) throws SQLException {
        leDaoFilm.ajouterAffiche(numVisa);
    }

    public int getLastNumSeqAffiche() throws SQLException {
        return leDaoFilm.getLastNumSeqAffiche();
    }

    public void supprimerAffiche(int numVisa) throws SQLException {
        leDaoFilm.supprimerAffiche(numVisa);
    }

    public void supprimerFilm(int numVisa) throws SQLException {
        leDaoFilm.supprimerFilm(numVisa);
    }

    public void chargerCommentaire(int numVisa, JTextPane jTextPane1) throws SQLException {
        leDaoFilm.chargerCommentaire(numVisa, jTextPane1);
    }

    public void modifierCommentaire(int numVisa, String text) throws SQLException {
        if(leDaoFilm.commentExist(numVisa)){
           leDaoFilm.modifierCommentaire(numVisa, text); 
        }else{
            leDaoFilm.addComment(numVisa);
            leDaoFilm.modifierCommentaire(numVisa, text);
        }
        
    }
}
