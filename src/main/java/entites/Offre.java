/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;
import service.PosteurService;
/**
 *
 * @author asus
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
    
    private String Nomservice;

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

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

   

   


   
    public Offre()
            
    {
        super();
    }
    

     public Offre(String adresse, String Date_debut , String heure ,String tel,String description_offre,String etatoffre,String Specialite) {
        super();
       this.adresse = adresse;
       this.Date_debut = Date_debut;
       this.heure = heure;
       this.tel = tel;
       this.description_offre = description_offre;
       this.etatoffre=etatoffre;
       this.Specialite=Specialite;
       
        
    }

    public void setEtatoffre(String etatoffre) {
        this.etatoffre = etatoffre;
    }

  

    public String getEtatoffre() {
        return etatoffre;
    }

   

    public String getNomservice() {
        return Nomservice;
    }

    public void setNomservice(String Nomservice) {
        this.Nomservice = Nomservice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

   
    
    
     
     
     
    
    
}
