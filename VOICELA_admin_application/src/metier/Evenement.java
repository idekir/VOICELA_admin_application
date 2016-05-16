/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;

/**
 *
 * @author Drédré
 */
public class Evenement {

    private int numVip;
    private Date dateMariage;
    private int numVipConjoint;
    private String lieuMariage;
    private Date dateDivorce;
    
    public Evenement(Date dateMariage, int numVipConjoint, String lieuMariage, Date dateDivorce, int numVip) {
        this.dateMariage = dateMariage;
        this.numVipConjoint = numVipConjoint;
        this.lieuMariage = lieuMariage;
        this.dateDivorce = dateDivorce;
        this.numVip = numVip;
    }

    public Evenement() {

    }

    public int getNumVip() {
        return numVip;
    }

    public Date getDateMariage() {
        return dateMariage;
    }

    public int getNumVipConjoint() {
        return numVipConjoint;
    }

    public String getLieuMariage() {
        return lieuMariage;
    }

    public Date getDateDivorce() {
        return dateDivorce;
    }

    public void setNumVip(int numVip) {
        this.numVip = numVip;
    }

    public void setDateMariage(Date dateMariage) {
        this.dateMariage = dateMariage;
    }

    public void setNumeroVipConjoint(int numeroVipConjoint) {
        this.numVipConjoint = numeroVipConjoint;
    }

    public void setLieuMariage(String lieuMariage) {
        this.lieuMariage = lieuMariage;
    }

    public void setDateDivorce(Date dateDivorce) {
        this.dateDivorce = dateDivorce;
    }
    
    

}
