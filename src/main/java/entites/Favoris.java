/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author ASUS
 */

public class Favoris {
       int id;
       int cin_posteur;
       int cin_jobeur;
       String nomj;
       String prenomj;
       String datej;
       String telej;
       String mailj;
       String specalite;
   

    public Favoris() {
    }

    public Favoris(int id) {
        this.id = id;
    }

 

    public Favoris(int cin_posteur,int cin_jobeur, String nomj, String prenomj, String datej, String telej, String mailj, String specalite) {
        this.cin_posteur = cin_posteur;
        this.cin_jobeur=cin_jobeur;
        this.nomj = nomj;
        this.prenomj = prenomj;
        this.datej = datej;
        this.telej = telej;
        this.mailj = mailj;
        this.specalite = specalite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin_posteur() {
        return cin_posteur;
    }

    public void setCin_posteur(int cin_posteur) {
        this.cin_posteur = cin_posteur;
    }

    public String getNomj() {
        return nomj;
    }

    public int getCin_jobeur() {
        return cin_jobeur;
    }

    public void setCin_jobeur(int cin_jobeur) {
        this.cin_jobeur = cin_jobeur;
    }

    public void setNomj(String nomj) {
        this.nomj = nomj;
    }

    public String getPrenomj() {
        return prenomj;
    }

    public void setPrenomj(String prenomj) {
        this.prenomj = prenomj;
    }

    public String getDatej() {
        return datej;
    }

    public void setDatej(String date) {
        this.datej = date;
    }

    public String getTelej() {
        return telej;
    }

    public void setTelej(String tele) {
        this.telej = telej;
    }

    public String getMailj() {
        return mailj;
    }

    public void setMailj(String mail) {
        this.mailj = mailj;
    }

    public String getSpecalite() {
        return specalite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Favoris other = (Favoris) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setSpecalite(String specalite) {
        this.specalite = specalite;
    }
    
}
