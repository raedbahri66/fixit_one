/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Objects;

/**
 *
 * @author iheb
 */
public class Echange {
  
  


      private String id ;
      private String propositionofferte;
    private String propositionsouhaitée;
    private String description_echange;
    private String  date;
    private int id_posteurfg;
    private String nom_posteur;
    private String prenom_posteur;
     private int id_jobeurfg;
    

    public Echange(String propositionofferte, String propositionsouhaitée, String description_echange, String date, int id_posteurfg, String nom_posteur,int id_jobeurfg) {
        this.propositionofferte = propositionofferte;
        this.propositionsouhaitée = propositionsouhaitée;
        this.description_echange = description_echange;
        this.date = date;
        this.id_posteurfg = id_posteurfg;
        this.nom_posteur = nom_posteur;
        this.id_jobeurfg=id_jobeurfg;
       
       
    }

    public String getPrenom_posteur() {
        return prenom_posteur;
    }

    public void setPrenom_posteur(String prenom_posteur) {
        this.prenom_posteur = prenom_posteur;
    }

    public int getId_posteurfg() {
        return id_posteurfg;
    }

    public void setId_posteurfg(int id_posteurfg) {
        this.id_posteurfg = id_posteurfg;
    }

    public String getNom_posteur() {
        return nom_posteur;
    }

    public void setNom_posteur(String nom_posteur) {
        this.nom_posteur = nom_posteur;
    }

    public int getId_jobeurfg() {
        return id_jobeurfg;
    }

    public void setId_jobeurfg(int id_jobeurfg) {
        this.id_jobeurfg = id_jobeurfg;
    }

    public Echange(String id, String propositionofferte, String propositionsouhaitée, String description_echange, String date, int id_posteurfg, String nom_posteur, int id_jobeurfg) {
        this.id = id;
        this.propositionofferte = propositionofferte;
        this.propositionsouhaitée = propositionsouhaitée;
        this.description_echange = description_echange;
        this.date = date;
        this.id_posteurfg = id_posteurfg;
        this.nom_posteur = nom_posteur;
        this.id_jobeurfg = id_jobeurfg;
    }

    public Echange(String id, String propositionofferte, String propositionsouhaitée, String description_echange, String date, int id_posteurfg,String nom_posteur ) {
       
        this.propositionofferte = propositionofferte;
        this.propositionsouhaitée = propositionsouhaitée;
        this.description_echange = description_echange;
        this.date = date;
        this.id_posteurfg = 0;
        this.nom_posteur=nom_posteur;
    }
    
 public Echange(){}
    public Echange(String id, String propositionofferte, String propositionsouhaitée, String description_echange, String date) {
        this.id = id;
        this.propositionofferte = propositionofferte;
        this.propositionsouhaitée = propositionsouhaitée;
        this.description_echange = description_echange;
        this.date = date;
    }

    public Echange(String propositionofferte, String propositionsouhaitée, String description_echange, String date) {
        this.propositionofferte = propositionofferte;
        this.propositionsouhaitée = propositionsouhaitée;
        this.description_echange = description_echange;
        this.date = date;
    }
  
 
    
    

    public String getId() {
        return id;
    }

    public String getPropositionofferte() {
        return propositionofferte;
    }

    public String getPropositionsouhaitée() {
        return propositionsouhaitée;
    }

    public String getDescription_echange() {
        return description_echange;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPropositionofferte(String propositionofferte) {
        this.propositionofferte = propositionofferte;
    }

    public void setPropositionsouhaitée(String propositionsouhaitée) {
        this.propositionsouhaitée = propositionsouhaitée;
    }

    public void setDescription_echange(String description_echange) {
        this.description_echange = description_echange;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Echange other = (Echange) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.propositionofferte, other.propositionofferte)) {
            return false;
        }
        if (!Objects.equals(this.propositionsouhaitée, other.propositionsouhaitée)) {
            return false;
        }
        if (!Objects.equals(this.description_echange, other.description_echange)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
  
   
    
    
}
