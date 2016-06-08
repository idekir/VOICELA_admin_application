/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Photo;
import metier.Vip;

/**
 *
 * @author Drédré
 */
public class ModeleJTablePhoto extends AbstractTableModel{
    
    private List<Photo> leConteneurPhoto;
    private String[] titre;
    private DaoVip leDaoVip;

    public ModeleJTablePhoto(DaoVip leDaoVip) {

        this.leConteneurPhoto = new ArrayList<>();
        this.titre = new String[]{"Numéro photo", "Date photo", "Lieu photo"};
        this.leDaoVip = leDaoVip;
    }

    @Override
    public int getRowCount() {
        return leConteneurPhoto.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Photo photo = leConteneurPhoto.get(row);
        if (column == 0) {
            return photo.getNumeroSequentiel();
        } else if (column == 1) {
            return photo.getDatePhoto();
        } else {
            return photo.getLieuPhoto();
        } 
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerPhotoVip(int numVip) throws SQLException {
        leConteneurPhoto.clear();
        leDaoVip.lirePhotoVip(numVip, leConteneurPhoto);
        fireTableDataChanged();
    }

    public Photo getPhoto(int ligne) {
        Photo photo = leConteneurPhoto.get(ligne);
        return photo;
    }
    
}
