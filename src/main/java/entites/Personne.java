/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class Personne {
    private int id;
    private int cin;
    private String nom;
    private String prenom;
    private String email;
    private String sexe;
    private String password;
    private Date date_naissance;
    private int tel;
    private String etat;

    public Personne() {
    }

    public Personne(int id, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.password = password;
        this.date_naissance = date_naissance;
        this.tel = tel;
        this.etat = etat;
    }

    public Personne(int cin, String nom, String prenom, String email, Date date_naissance, int tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naissance = date_naissance;
        this.tel = tel;
    }
    

    public Personne(int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.password = password;
        this.date_naissance = date_naissance;
        this.tel = tel;
        this.etat = etat;
    }

    public Personne(int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.password = password;
        this.date_naissance = date_naissance;
        this.tel = tel;
    }

    public Personne(int id, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.password = password;
        this.date_naissance = date_naissance;
        this.tel = tel;
    }
      public Personne(String nom, String prenom, String email, String sexe, int tel) {
        
       
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", sexe=" + sexe + ", password=" + password + ", date_naissance=" + date_naissance + ", tel=" + tel + ", etat=" + etat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.cin;
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
        final Personne other = (Personne) obj;
        if (this.cin != other.cin) {
            return false;
        }
        return true;
    }

   
    
    
    

}
