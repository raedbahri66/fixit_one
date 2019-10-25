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
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface iPosteur {
public void creerPosteur(Posteur p,FileInputStream fis,File file);
        public void modifierPosteur(Posteur p);
    public void supprimerPosteur(Posteur p);
    public List<Posteur> afficherPosteur();
public void modifierProfil(Posteur p, InputStream fis, File file );

}
