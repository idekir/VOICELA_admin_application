package modele;

import accesAuxDonnees.DaoVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Vip;

public class ModeleJTableVip extends AbstractTableModel {

    // les conteneur de données
    private List<Vip> leConteneur;
    // le titre des champs des conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoVip leDaoVip;

    public ModeleJTableVip(DaoVip leDaoVip) {

        this.leConteneur = new ArrayList<>();
        this.titre = new String[]{"Numéro", "Nom", "Prenom", "Civilite", "Date de Naissance", "Lieu de Naissance", "Role", "Statut", "Pays"};
        // l'objet DAO utilisé
        this.leDaoVip = leDaoVip;
    }

    @Override
    public int getRowCount() {
        return leConteneur.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    public Vip getVip(int ligne) {
        Vip vip = leConteneur.get(ligne);
        return vip;
    }

    public Vip getVipByNum(int numVip) {
        int tailleConteneur = leConteneur.size();
        for (int i = 0; i < tailleConteneur; i++) {
            if (leConteneur.get(i).getNumVip() == numVip) {
                return leConteneur.get(i);
            }
        }
        return null;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vip vip = leConteneur.get(row);
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
        leConteneur.add(vip);
        this.fireTableDataChanged();
    }

    public void supprimerVip(int ligne) throws SQLException {
        int numVip = (int) getValueAt(ligne, 0);
        leDaoVip.supprimerVip(numVip);
        leConteneur.remove(ligne);
        this.fireTableDataChanged();
    }

    public void chargerLesVip() throws SQLException {
        leDaoVip.lireLesVip(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
     public void chargerLesVip(String nom) throws SQLException {
        leDaoVip.lireLesVip(leConteneur,nom);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    

    public void cleanVip() {
        leConteneur.clear();
    }

    public int getNbVip() {
        return leConteneur.size();
    }
}