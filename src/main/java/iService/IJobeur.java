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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IJobeur {
    public void creerJobeur(Jobeur p,FileInputStream fis,File file);
    public void creerJobeurByFb(Jobeur p);
    public void creerJobeur(Jobeur p, FileInputStream fis, File file, FileInputStream fis1, File file1);
    public Jobeur getJobeurInfobyCin(int cin1) throws FileNotFoundException, SQLException, IOException;
    public List<Jobeur> afficherJobeurbyEtat(String nom) throws SQLException;
    public List<Jobeur> afficherJobeurbyAddress(String address);
    public List<Jobeur> afficherJobeurbynNom(String choix,String nom)throws SQLException;
    public void BannirJobeur(Jobeur p);
    public void modifierProfil(Jobeur p, InputStream fis, File file,InputStream pdf, File pdff);
    public void putVote(Jobeur j);
    public List<Jobeur> top5() throws SQLException;
    public void modifierJobeur(Jobeur p);
    public void supprimerJobeur(Jobeur p);
    public List<Jobeur> afficherJobeur();
    public void modifierProfil(Jobeur p, InputStream fis, File file );
    public void ajouterVote(Jobeur p,int cin_jobeur);
    public void UpdateVote(Jobeur p,int cin_jobeur);
    public void supprimerVote(Jobeur p );
    public void AccepterJobeur(Jobeur p);
    public void RefuserJobeur(Jobeur p);

}
