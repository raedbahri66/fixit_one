/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Offre {
    private String adresse;
    private String Date_debut;
    private String heure;
    private String description_offre;
    private String tel;

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription_offre() {
        return description_offre;
    }

    public void setDescription_offre(String description_offre) {
        this.description_offre = description_offre;
    }

    public void setDate_debut(String Date_debut) {
        this.Date_debut = Date_debut;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }
    

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getHeure() {
        return heure;
    }

    

    public String getDate_debut() {
        return Date_debut;
    }

    public String getAdresse() {
        return adresse;
    }
     public Offre(String adresse, String Date_debut , String heure ,String description_offre,String tel) {
        super();
       this.adresse = adresse;
       this.description_offre = description_offre;
       this.Date_debut = Date_debut;
       this.heure = heure;
       this.tel = tel;
        
    }
    
    
}
