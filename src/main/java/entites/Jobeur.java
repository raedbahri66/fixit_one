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
public class Jobeur extends Personne{
    private String job;
    private int idequipe_fg;
    private String nomequipe_fg;
     private String role;
     private String address;
     


    public Jobeur() {
    }

    public Jobeur(String job, String role, String address, int id, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel) {
        super(id, cin, nom, prenom, email, sexe, password, date_naissance, tel);
        this.job = job;
        this.role = role;
        this.address = address;
    }
    

    public Jobeur(String job, String role, String nom, String prenom, String email, String sexe, int tel,String address) {
        super(nom, prenom, email, sexe, tel);
        this.job = job;
        this.role = role;
        this.address = address;
    }

    public Jobeur(String job, String role, int id, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        super(id, cin, nom, prenom, email, sexe, password, date_naissance, tel, etat);
        this.job = job;
        this.role = role;
    }

    public Jobeur(String job, int idequipe_fg, String nomequipe_fg, String role, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        super(cin, nom, prenom, email, sexe, password, date_naissance, tel, etat);
        this.job = job;
        this.idequipe_fg = idequipe_fg;
        this.nomequipe_fg = nomequipe_fg;
        this.role = role;
    }

    public Jobeur(String job, String role, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        super(cin, nom, prenom, email, sexe, password, date_naissance, tel, etat);
        this.job = job;
        this.role = role;
    }
    public Jobeur(String job, String role, String nom, String prenom, String email, String sexe, int tel) {
        super(nom, prenom, email, sexe, tel);
        this.job = job;
        
    }

    

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIdequipe_fg() {
        return idequipe_fg;
    }

    public void setIdequipe_fg(int idequipe_fg) {
        this.idequipe_fg = idequipe_fg;
    }

    public String getNomequipe_fg() {
        return nomequipe_fg;
    }

    public void setNomequipe_fg(String nomequipe_fg) {
        this.nomequipe_fg = nomequipe_fg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
            
    
}
