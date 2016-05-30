package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Film;

public class ModeleJTableFilm extends AbstractTableModel {

    private List<Film> leConteneurFilm;
    private String[] titre;
    private DaoFilm leDaoFilm;

    public ModeleJTableFilm(DaoFilm leDaoFilm) {
        
        this.leConteneurFilm = new ArrayList<>();
        this.leDaoFilm = leDaoFilm;
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
            return film.getNumGenre();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerLesFilm() throws SQLException {
        leConteneurFilm.clear();
        leDaoFilm.lireLesFilm(leConteneurFilm);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
    public void ajouterFilm(Film film) throws SQLException {
        leDaoFilm.ajouterFilm(film);
        leConteneurFilm.add(film);
        fireTableDataChanged();
    }

}