package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Genre;

public class ModeleJTableGenreFilm extends AbstractTableModel {

    private List<Genre> leConteneurGenre;
    private String[] titre;
    private DaoFilm leDaoFilm;

    public ModeleJTableGenreFilm(DaoFilm leDaoFilm) {

        this.leConteneurGenre = new ArrayList<>();
        this.leDaoFilm = leDaoFilm;
        this.titre = new String[]{"Numéro genre", "Libellé genre"};
        
    }

    @Override
    public int getRowCount() {
        return leConteneurGenre.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Genre genre = leConteneurGenre.get(row);
        if (column == 0) {
            return genre.getNumGenre();
        } else {
            return genre.getNomGenre();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerGenre() throws SQLException {
        leConteneurGenre.clear();
        leDaoFilm.lireGenre(leConteneurGenre);
        fireTableDataChanged();
    }

    public void ajouterGenre(String newGenre) throws SQLException {
        leDaoFilm.ajouterGenre(newGenre);
        chargerGenre();
    }

    public Genre getGenre(int ligne) {
        return leConteneurGenre.get(ligne);
    }

    public void supprimerGenre(int ligne) throws SQLException {
        Genre genre = leConteneurGenre.get(ligne);
        leDaoFilm.supprimerGenre(genre);
        chargerGenre();
    }
    
    public String getNomGenre(int numGenre) {
        leConteneurGenre.contains(numGenre);
        for (int i = 0; i < leConteneurGenre.size(); i++) {
            Genre temp = leConteneurGenre.get(i);
            if(temp.getNumGenre()==numGenre){
                return temp.getNomGenre();
            }
        }
        return "";
    }
}
