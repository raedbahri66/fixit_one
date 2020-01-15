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
    private Date  date_article;
    private String categorie;
    private String sources;
    private String iamge;

    public Article(String nom_article, String descriptionarticle, Date date_article, String categorie, String sources, String iamge) {
        this.nom_article = nom_article;
        this.descriptionarticle = descriptionarticle;
        this.date_article = date_article;
        this.categorie = categorie;
        this.sources = sources;
        this.iamge = iamge;
    }

    public String getIamge() {
        return iamge;
    }

    public void setIamge(String iamge) {
        this.iamge = iamge;
    }
      public Article() {
    }

    public Article(int id) {
        this.id = id;
    }

    public Article(String nom_article, String descriptionarticle, Date date_article, String categorie, String sources) {
        this.nom_article = nom_article;
        this.descriptionarticle = descriptionarticle;
        this.date_article = date_article;
        this.categorie = categorie;
        this.sources = sources;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getDescriptionarticle() {
        return descriptionarticle;
    }

    public void setDescriptionarticle(String descriptionarticle) {
        this.descriptionarticle = descriptionarticle;
    }

    public Date getDate_article() {
        return date_article;
    }

    public void setDate_article(Date date_article) {
        this.date_article = date_article;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public Article(int id, String nom_article, String descriptionarticle, Date date_article, String categorie, String sources) {
        this.id = id;
        this.nom_article = nom_article;
        this.descriptionarticle = descriptionarticle;
        this.date_article = date_article;
        this.categorie = categorie;
        this.sources = sources;
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
