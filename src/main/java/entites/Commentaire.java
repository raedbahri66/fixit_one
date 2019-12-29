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
public class Commentaire {
   private int id;
   private int id_jobeur;
   private int id_posteur;
   private String nomp;
   private String prenomp;
   private String description;

    public Commentaire() {
    }

    public Commentaire(int id_jobeur, int id_posteur, String nomp, String prenomp, String description) {
        this.id_jobeur = id_jobeur;
        this.id_posteur = id_posteur;
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.description = description;
    }

    public Commentaire(int id) {
        this.id = id;
    }

    public Commentaire(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Commentaire(String nomp, String prenomp, String description) {
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_jobeur() {
        return id_jobeur;
    }

    public void setId_jobeur(int id_jobeur) {
        this.id_jobeur = id_jobeur;
    }

    public int getId_posteur() {
        return id_posteur;
    }

    public void setId_posteur(int id_posteur) {
        this.id_posteur = id_posteur;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getPrenomp() {
        return prenomp;
    }

    public void setPrenomp(String prenomp) {
        this.prenomp = prenomp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "nomp=" + nomp + ", prenomp=" + prenomp + ", description=" + description + '}';
    }

    public Commentaire(int id_jobeur, int id_posteur, String description) {
        this.id_jobeur = id_jobeur;
        this.id_posteur = id_posteur;
        this.description = description;
    }
    
   
}