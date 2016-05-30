package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Film;
import metier.Genre;

public class ModeleJTableFilm extends AbstractTableModel {

    private List<Film> leConteneurFilm;
    private List<Genre> leConteneurGenre;
    private String[] titre;
    private DaoFilm leDaoFilm;
    

    public ModeleJTableFilm(DaoFilm leDaoFilm) throws SQLException {
        this.leDaoFilm = leDaoFilm;
        this.leConteneurFilm = new ArrayList<>();
        this.leConteneurGenre = new ArrayList<>();
        leDaoFilm.chargerGenre(leConteneurGenre);
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
            return leConteneurFilm.getNomGenre(film.getNumGenre());
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
    
    public String getNomGenre(int numGenre){
        leConteneurGenre.contains(numGenre);
        return 0;
    }

}