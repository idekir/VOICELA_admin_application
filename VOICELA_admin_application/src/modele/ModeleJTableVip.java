package modele;

import accesAuxDonnees.DaoVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Vip;

public class ModeleJTableVip extends AbstractTableModel {

    private List<Vip> leConteneurVip;
    private String[] titre;
    private DaoVip leDaoVip;

    public ModeleJTableVip(DaoVip leDaoVip) {

        this.leConteneurVip = new ArrayList<>();
        this.titre = new String[]{"Numéro", "Nom", "Prenom", "Civilite", "Date de Naissance", "Lieu de Naissance", "Role", "Statut", "Pays"};
        this.leDaoVip = leDaoVip;
    }

    @Override
    public int getRowCount() {
        return leConteneurVip.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    public Vip getVip(int ligne) {
        Vip vip = leConteneurVip.get(ligne);
        return vip;
    }

    public Vip getVipByNum(int numVip) {
        int tailleConteneur = leConteneurVip.size();
        for (int i = 0; i < tailleConteneur; i++) {
            if (leConteneurVip.get(i).getNumVip() == numVip) {
                return leConteneurVip.get(i);
            }
        }
        return null;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vip vip = leConteneurVip.get(row);
        if (column == 0) {
            return vip.getNumVip();
        } else if (column == 1) {
            return vip.getNomVip();
        } else if (column == 2) {
            return vip.getPrenomVip();
        } else if (column == 3) {
            return vip.getCivilite();
        } else if (column == 4) {
            return vip.getDateNaissance();
        } else if (column == 5) {
            return vip.getLieuNaissance();
        } else if (column == 6) {
            switch (vip.getCodeRole()) {
                case 1:
                    return "Acteur";
                case 2:
                    return "Réalisateur";
                default:
                    return "Acteur/Réalisateur";
            }
        } else if (column == 7) {
            switch (vip.getCodeStatut()) {
                case 0:
                    return "Célibataire";
                case 1:
                    return "En couple";
                default:
                    return "Divorcé";
            }
        } else {
            return vip.getNomPays();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererVip(Vip vip) throws SQLException {
        leDaoVip.ajouterVip(vip);
        leConteneurVip.add(vip);
        this.fireTableDataChanged();
    }

    public void supprimerVip(int ligne) throws SQLException {
        int numVip = (int) getValueAt(ligne, 0);
        leDaoVip.supprimerVip(numVip);
        leConteneurVip.remove(ligne);
        this.fireTableDataChanged();
    }

    public void chargerLesVip() throws SQLException {
        leConteneurVip.clear();
        leDaoVip.lireLesVip(leConteneurVip);
        fireTableDataChanged();  // notification de modification des données à la vue
    }

    public void chargerLesVip(String nom) throws SQLException {
        leConteneurVip.clear();
        leDaoVip.lireLesVip(leConteneurVip, nom);
        fireTableDataChanged();  // notification de modification des données à la vue
    }

    public int getNbVip() {
        return leConteneurVip.size();
    }
}
