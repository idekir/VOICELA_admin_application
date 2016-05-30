package modele;

import accesAuxDonnees.DaoVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Vip;

public class ModeleJTableAddMariage extends AbstractTableModel {

    // les conteneur de données
    private List<Vip> leConteneurAddMariage;
    // le titre des champs des conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoVip leDaoVip;

    public ModeleJTableAddMariage(DaoVip leDaoVip) {

        this.leConteneurAddMariage = new ArrayList<Vip>();
        this.titre = new String[]{"Numéro", "Nom", "Prenom", "Civilite", "Date de Naissance", "Lieu de Naissance", "Role", "Statut", "Pays"};
        // l'objet DAO utilisé
        this.leDaoVip = leDaoVip;
    }

    @Override
    public int getRowCount() {
        return leConteneurAddMariage.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    public Vip getVip(int ligne) {
        Vip vip = leConteneurAddMariage.get(ligne);
        return vip;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vip vip = leConteneurAddMariage.get(row);
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
            int codeRole = vip.getCodeRole();
            switch (codeRole) {
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

    public void chargerLesVipAddMariage() throws SQLException {
        leDaoVip.lireLesVipCodeStatut(leConteneurAddMariage);
        fireTableDataChanged();  // notification de modification des données à la vue
    }

    public void chargerLesVipAddMariage(String nom) throws SQLException {
        leDaoVip.lireLesVipCodeStatut(leConteneurAddMariage, nom);
        fireTableDataChanged();  // notification de modification des données à la vue
    }

    public void cleanVip() {
        leConteneurAddMariage.clear();
    }
}
