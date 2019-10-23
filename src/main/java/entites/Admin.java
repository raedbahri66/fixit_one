/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Admin extends Personne{
         private String role;

    public Admin() {
    }

    public Admin(String role, int id, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        super(id, cin, nom, prenom, email, sexe, password, date_naissance, tel, etat);
        this.role = role;
    }

    public Admin(String role, int cin, String nom, String prenom, String email, String sexe, String password, Date date_naissance, int tel, String etat) {
        super(cin, nom, prenom, email, sexe, password, date_naissance, tel, etat);
        this.role = role;
    }

    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
         
    

}
