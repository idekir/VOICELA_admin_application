package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeleJTableGenreFilm extends AbstractTableModel {

    private List<String[]> leConteneurGenre;
    private String[] titre;
    private DaoFilm leDaoFilm;

    public ModeleJTableGenreFilm(DaoFilm leDaoFilm) {

        this.leConteneurGenre = new ArrayList<>();
        this.titre = new String[]{"Numéro genre", "Libellé genre"};
        this.leDaoFilm = leDaoFilm;
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
        String[] genre = leConteneurGenre.get(row);
        if (column == 0) {
            return genre[0];
        } else {
            return genre[1];
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

    public String[] getStringGenre(int ligne) {
        return leConteneurGenre.get(ligne);
    }

    public void supprimerGenre(int ligne) throws SQLException {
        String[] stringGenre = leConteneurGenre.get(ligne);
        leDaoFilm.supprimerGenre(stringGenre);
        chargerGenre();
    }
}
