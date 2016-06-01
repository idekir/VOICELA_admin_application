package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Vip;

public class ModeleJTableActeur extends AbstractTableModel {

    private List<Vip> leConteneurActeur;
    private ModeleJTableVip leModeleVip;
    private DaoFilm leDaoFilm;
    private final String[] titre;

    public ModeleJTableActeur(DaoFilm leDaoFilm, ModeleJTableVip leModeleVip) throws SQLException {
        this.leConteneurActeur = new ArrayList<>();
        this.leModeleVip = leModeleVip;
        this.leDaoFilm = leDaoFilm;
        this.titre = new String[]{"Numero VIP", "Nom VIP", "Prénom VIP"};
    }

    @Override
    public int getRowCount() {
        return leConteneurActeur.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vip vip = leConteneurActeur.get(row);

        if (column == 0) {
            return vip.getNumVip();
        } else if (column == 1) {
            return vip.getNomVip();
        } else {
            return vip.getPrenomVip();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerActeur(int numVisa) throws SQLException {
        leConteneurActeur.clear();
        leDaoFilm.lireActeurFilm(numVisa, leConteneurActeur);
        fireTableDataChanged();
    }
}
