/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

import entites.Jobeur;
import entites.Posteur;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IJobeur {
    public void creerJobeur(Jobeur p,FileInputStream fis,File file);
    public void modifierJobeur(Jobeur p);
    public void supprimerJobeur(Jobeur p);
    public List<Jobeur> afficherJobeur();
    public void modifierProfil(Jobeur p, InputStream fis, File file );
    public void ajouterVote(Jobeur p,int cin_jobeur);
    public void UpdateVote(Jobeur p,int cin_jobeur);
    public void supprimerVote(Jobeur p );

}
