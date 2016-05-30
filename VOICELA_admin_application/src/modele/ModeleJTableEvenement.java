package modele;

import accesAuxDonnees.DaoEvenement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Evenement;
import metier.Vip;

public class ModeleJTableEvenement extends AbstractTableModel {
    // les conteneur de données
    private List<Evenement> leConteneurEvenement;
    private ModeleJTableVip leModeleVip;
    // le titre des champs des conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoEvenement leDaoEvenement;

    public ModeleJTableEvenement(DaoEvenement leDaoEvenement, ModeleJTableVip leModeleVip) {
        
        this.leConteneurEvenement = new ArrayList<Evenement>();
        this.titre = new String[]{"Date Mariage","Num Vip", "Nom VIP", "Prenom VIP", "Civilite", "Lieu Mariage", "Num VIP Conjoint", "Nom Conjoint", "Prenom Conjoint", "Civilite Conjoint", "Date Divorce"};
        // l'objet DAO utilisé
        this.leDaoEvenement = leDaoEvenement;
        this.leModeleVip = leModeleVip;
    }

    @Override
    public int getRowCount() {
        return leConteneurEvenement.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Evenement evenement = leConteneurEvenement.get(row);
        int numVip = evenement.getNumVip();
        int numVipConjoint = evenement.getNumVipConjoint();
        Vip vip = leModeleVip.getVipByNum(numVip);
        Vip vipConjoint = leModeleVip.getVipByNum(numVipConjoint);
        
        if (column == 0) {
            return evenement.getDateMariage();
        } else if (column == 1) {
            return evenement.getNumVip();
        }else if (column == 2) {
            return vip.getNomVip();
        } else if (column == 3) {
            return vip.getPrenomVip();
        } else if (column == 4) {
            return vip.getCivilite();
        } else if (column == 5) {
            return evenement.getLieuMariage();
        } else if (column == 6) {
            return evenement.getNumVipConjoint();
        }else if (column == 7) {
            return vipConjoint.getNomVip();
        }else if (column == 8) {
            return vipConjoint.getPrenomVip();
        }else if (column == 9) {
            return vipConjoint.getCivilite();
        }else{
            return evenement.getDateDivorce();
        }
    }
    
    public Evenement getEvenement(int ligne){
        Evenement evenement = leConteneurEvenement.get(ligne);
        return evenement;
    }
    
    public void insererEvenement(Evenement evenement) throws SQLException {
        leDaoEvenement.ajouterEvenement(evenement);
        leConteneurEvenement.add(evenement);
        this.fireTableDataChanged();
    }
    
    public void chargerLesEvenement() throws SQLException {
        leConteneurEvenement.clear();
        leDaoEvenement.lireLesEvenement(leConteneurEvenement);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }
    
    public void cleanVip() {
        leConteneurEvenement.clear();
    }

    public void addDivorce(Evenement divorce) throws SQLException {
        leDaoEvenement.ajouterDivorce(divorce);
        leConteneurEvenement.set(0, divorce);
        this.fireTableDataChanged();
    }

    public void chargerLesEvenement(String text) throws SQLException {
        leConteneurEvenement.clear();
        leDaoEvenement.lireLesEvenement(leConteneurEvenement, text);
        fireTableDataChanged();
    }
}
