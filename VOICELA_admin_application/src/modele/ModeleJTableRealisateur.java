package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Vip;

public class ModeleJTableRealisateur extends AbstractTableModel {

    private List<Vip> leConteneurRealisateur;
    private DaoFilm leDaoFilm;
    private String[] titre;

    public ModeleJTableRealisateur(DaoFilm leDaoFilm) throws SQLException {
        this.leConteneurRealisateur = new ArrayList<>();
        this.leDaoFilm = leDaoFilm;
        this.titre = new String[]{"Numero VIP", "Nom VIP", "Prénom VIP","Role"};
    }

    @Override
    public int getRowCount() {
        return leConteneurRealisateur.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vip vip = leConteneurRealisateur.get(row);

        if (column == 0) {
            return vip.getNumVip();
        } else if (column == 1) {
            return vip.getNomVip();
        } else if (column ==2 ){
            return vip.getPrenomVip();
        }else{
            return vip.getCodeRole();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerRealisateur(int numVisa) throws SQLException {
        leConteneurRealisateur.clear();
        leDaoFilm.lireRealisateurFilm(numVisa, leConteneurRealisateur);
        fireTableDataChanged();
    }

    public Vip getVip(int ligne) {
        Vip vip = leConteneurRealisateur.get(ligne);
        return vip;
    }
}
