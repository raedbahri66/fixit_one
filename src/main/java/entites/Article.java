/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Article {

  
    private int id ;
    private String nom_article;
    private String descriptionarticle;
    private String  date_article;
    private String categorie;
    private String sources;
      public Article() {
    }

    public Article(int id, String nom_article, String descriptionarticle, String date_article, String categorie, String sources) {
        this.id = id;
        this.nom_article = nom_article;
        this.descriptionarticle = descriptionarticle;
        this.date_article = date_article;
        this.categorie = categorie;
        this.sources = sources;
    }
 
    public void setDate_article(String date_article) {
        this.date_article = date_article;
    }

    public Article(String nom_article, String descriptionarticle, String date_article, String categorie, String sources) {
        this.nom_article = nom_article;
        this.descriptionarticle = descriptionarticle;
        this.date_article = date_article;
        this.categorie = categorie;
        this.sources = sources;
    }
    /*
    public Article(String nom_article, String date_article, String categorie, String sources) {
        this.nom_article = nom_article;
        this.date_article = date_article;
        this.categorie = categorie;
        this.sources = sources;
    }*/

 

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    
    
    public String getDate_article() {
        return date_article;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getSources() {
        return sources;
    }
         

    public Article(int id) {
        this.id= id;
    }

  

    public String getNom_article() {
        return nom_article;
    }

    public String getDescriptionarticle() {
        return descriptionarticle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public void setDescriptionarticle(String descriptionarticle) {
        this.descriptionarticle = descriptionarticle;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

  
    
    
/*
    @Override
    public String toString() {
        return "Article{" + "nom_article=" + nom_article + ", descriptionarticle=" + descriptionarticle + ", date_article=" + date_article + ", categorie=" + categorie + ", sources=" + sources + '}';
    }*/
    
    @Override
 public String toString() {
        return "Article{" + "nom_article=" + nom_article + ", date_article=" + date_article + ", categorie=" + categorie + ", sources=" + sources + '}';
    }
        
}
