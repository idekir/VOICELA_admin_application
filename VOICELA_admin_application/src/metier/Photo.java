/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;

public class Photo {
    
    private int numeroSequentiel;
    private int numVip;
    private Date datePhoto;
    private String lieuPhoto;

    public Photo(int numeroSequentiel, int numVip, Date datePhoto, String lieuPhoto) {
        this.numeroSequentiel = numeroSequentiel;
        this.numVip = numVip;
        this.datePhoto = datePhoto;
        this.lieuPhoto = lieuPhoto;
    }

    public Photo() {
    }

    public int getNumeroSequentiel() {
        return numeroSequentiel;
    }

    public int getNumVip() {
        return numVip;
    }

    public Date getDatePhoto() {
        return datePhoto;
    }

    public String getLieuPhoto() {
        return lieuPhoto;
    }

    public void setNumeroSequentiel(int numeroSequentiel) {
        this.numeroSequentiel = numeroSequentiel;
    }

    public void setNumVip(int numVip) {
        this.numVip = numVip;
    }

    public void setDatePhoto(Date datePhoto) {
        this.datePhoto = datePhoto;
    }

    public void setLieuPhoto(String lieuPhoto) {
        this.lieuPhoto = lieuPhoto;
    }
    
    
}


