/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Asus
 */
public class Offre {
     private String id;
    private String adresse;
    private String Date_debut;
    private String heure;
    private String description_offre;
    private String tel;
    private String etatoffre;
    private String Specialite;

    public Offre(String adresse, String Date_debut, String heure, String description_offre, String tel, String etatoffre, String Specialite) {
        this.adresse = adresse;
        this.Date_debut = Date_debut;
        this.heure = heure;
        this.description_offre = description_offre;
        this.tel = tel;
        this.etatoffre = etatoffre;
        this.Specialite = Specialite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(String Date_debut) {
        this.Date_debut = Date_debut;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDescription_offre() {
        return description_offre;
    }

    public void setDescription_offre(String description_offre) {
        this.description_offre = description_offre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEtatoffre() {
        return etatoffre;
    }

    public void setEtatoffre(String etatoffre) {
        this.etatoffre = etatoffre;
    }

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

    public Offre() {
    }
    
}
