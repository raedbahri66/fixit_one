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
    public Echange()
     {}

    public Echange(String id, String nom_echange, String description_echange, String date) {
        this.id = id;
        this.nom_echange = nom_echange;
        this.description_echange = description_echange;
        this.date = date;
    }
     public Echange(String id, String nom_echange, String description_echange) {
        this.id = id;
        this.nom_echange = nom_echange;
        this.description_echange = description_echange;
     
    }
     public Echange( String nom_echange, String description_echange) {
        
        this.nom_echange = nom_echange;
        this.description_echange = description_echange;
     
    }
  
  


      private String id ;
    private String nom_echange;
    private String description_echange;
    private String  date;
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom_echange, other.nom_echange)) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom_echange() {
        return nom_echange;
    }

    public void setNom_echange(String nom_echange) {
        this.nom_echange = nom_echange;
    }

    public String getDescription_echange() {
        return description_echange;
    }

    public void setDescription_echange(String description_echange) {
        this.description_echange = description_echange;
    }

    public  String getDate() {
        return date;
    }

    public void setDate( String date) {
        this.date = date;
    }
    
    
    
}
