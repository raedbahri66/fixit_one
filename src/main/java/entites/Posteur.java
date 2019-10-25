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
public class Posteur extends Personne{
         private String role;

    public Posteur() {
    }

    public Posteur(int id) {
        super(id);
    }

    public Posteur(int cin, String nom, String prenom, String email, Date date_naissance, int tel) {
        super(cin, nom, prenom, email, date_naissance, tel);
    }

    public Posteur( int id, int cin, String nom, String prenom, String email, String password, String sexe, Date date_naissance, int tel, String etat, String role) {
        super(id, cin, nom, prenom, email,  sexe, password, date_naissance, tel, etat);
        this.role = role;
    }

    public Posteur( int cin, String nom, String prenom, String email, String  sexe, String password, Date date_naissance, int tel, String etat , String role ) {
        super(cin, nom, prenom, email, sexe, password, date_naissance, tel, etat);
        this.role = role;
    }

    public Posteur(int id, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel) {
        super(id, cin, nom, prenom, email, sexe, password, date_naissance, tel);
    }

    public Posteur(int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel) {
        super(cin, nom, prenom, email, sexe, password, date_naissance, tel);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
