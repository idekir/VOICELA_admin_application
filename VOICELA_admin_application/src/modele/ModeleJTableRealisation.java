/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoFilm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Vip;

/**
 *
 * @author Drédré
 */
public class ModeleJTableRealisation extends AbstractTableModel {

    private List<Vip> leConteneurRealisationAjout;
    private ModeleJTableVip leModeleVip;
    private DaoFilm leDaoFilm;
    private String[] titre;

    public ModeleJTableRealisation(DaoFilm leDaoFilm) throws SQLException {
        this.leConteneurRealisationAjout = new ArrayList<>();
        this.leModeleVip = leModeleVip;
        this.leDaoFilm = leDaoFilm;
        this.titre = new String[]{"Numero VIP", "Nom VIP", "Prénom VIP","Role"};
    }

    @Override
    public int getRowCount() {
        return leConteneurRealisationAjout.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vip vip = leConteneurRealisationAjout.get(row);

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

    public void realisateurPossibleFilm(int numVisa) throws SQLException {
        leConteneurRealisationAjout.clear();
        leDaoFilm.realisateurPossibleFilm(numVisa, leConteneurRealisationAjout);
        fireTableDataChanged();
    }

    public void acteurPossibleFilm(int numVisa) throws SQLException {
        leConteneurRealisationAjout.clear();
        leDaoFilm.acteurPossibleFilm(numVisa, leConteneurRealisationAjout);
        fireTableDataChanged();
    }

    public Vip getVip(int ligne) {
        Vip vip = leConteneurRealisationAjout.get(ligne);
        System.out.println(vip.getNumVip());
        return vip;
    }

}
