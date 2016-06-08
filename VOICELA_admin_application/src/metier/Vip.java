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
public class Vip {
    
    private int numVip;
    private String nomVip;
    private String prenomVip;
    private String civilite;
    private Date dateNaissance;
    private String lieuNaissance;
    private int codeRole;
    private int codeStatut;
    private String nomPays;

    public Vip(int numVip, String nomVip, String prenomVip, String civilite, Date dateNaissance, String lieuNaissance, int codeRole, int codeStatut, String nomPays) {
        this.numVip = numVip;
        this.nomVip = nomVip;
        this.prenomVip = prenomVip;
        this.civilite = civilite;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.codeRole = codeRole;
        this.codeStatut = codeStatut;
        this.nomPays = nomPays;
    }
    
    public Vip(String nomVip, String prenomVip, String civilite, Date dateNaissance, String lieuNaissance, int codeRole, int codeStatut, String nomPays) {this.nomVip = nomVip;
        this.prenomVip = prenomVip;
        this.civilite = civilite;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.codeRole = codeRole;
        this.codeStatut = codeStatut;
        this.nomPays = nomPays;
    }
    
    public Vip() {
    }

    public Vip(int numVip, String nomVip, String prenomVip, String civilite, int codeStatut, String nomPays) {
        this.nomVip = nomVip;
        this.prenomVip = prenomVip;
        this.civilite = civilite;
        this.codeStatut = codeStatut;
        this.nomPays = nomPays;
    }

    public Vip(int numVip, String nomVip, String prenomVip, int codeRole) {
        this.numVip = numVip;
        this.nomVip = nomVip;
        this.prenomVip = prenomVip;
        this.codeRole = codeRole;
    }

    public int getNumVip() {
        return numVip;
    }

    public String getNomVip() {
        return nomVip;
    }

    public String getPrenomVip() {
        return prenomVip;
    }

    public String getCivilite() {
        return civilite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public int getCodeRole() {
        return codeRole;
    }

    public int getCodeStatut() {
        return codeStatut;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNumVip(int numVip) {
        this.numVip = numVip;
    }

    public void setNomVip(String nomVip) {
        this.nomVip = nomVip;
    }

    public void setPrenomVip(String prenomVip) {
        this.prenomVip = prenomVip;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setCodeRole(int codeRole) {
        this.codeRole = codeRole;
    }

    public void setCodeStatut(int codeStatut) {
        this.codeStatut = codeStatut;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
    
    @Override
    public String toString() {
        return "Vip("+numVip+","+nomVip+","+prenomVip+","+civilite+","+dateNaissance+","+lieuNaissance+","+codeRole+","+codeStatut+","+nomPays;
    }

    public void setVip(Vip vip) {
        this.numVip = vip.numVip;
        this.nomVip = vip.nomVip;
        this.prenomVip = vip.prenomVip;
        this.civilite = vip.civilite;
        this.dateNaissance = vip.dateNaissance;
        this.lieuNaissance = vip.lieuNaissance;
        this.codeRole = vip.codeRole;
        this.codeStatut = vip.codeStatut;
        this.nomPays = vip.nomPays;
    }
    
}
