/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.Posteur;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface iPosteur {
    public String login(int cin1,String password1);
    public String BannirRaison(int cin1,String password1);
    public void modifierProfil(Posteur p, InputStream fis, File file );
    public List<Posteur> afficherPosteurbynNom(String choix,String nom) throws SQLException;
    public List<Posteur> afficherPosteurbyEtat(String nom) throws SQLException;
    public String Emailget(int cin1) throws SQLException;
    public String Passwordget(int cin1) throws SQLException;
    public void creerPosteurByFb(Posteur p);
    public void BannirPosteur(Posteur p);
    public void creerPosteur(Posteur p);
    public void creerPosteur(Posteur p,FileInputStream fis,File file);
    public void modifierPosteur(Posteur p);
    public void supprimerPosteur(Posteur p);
    public List<Posteur> afficherPosteur();

}
