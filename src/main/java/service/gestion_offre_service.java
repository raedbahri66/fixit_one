/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entites.Offre;
import entites.Service;
import iService.IOffre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.PosteurService;
import utils.ConnexionBD;
import entites.Offre;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author asus
 */
public class gestion_offre_service implements IOffre{
    public static int id_offre;
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    public gestion_offre_service() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void creerOffre(Offre O) {
        
       String req1 = "insert into offre_service (adress,date,heure,description_offre,tel,idposteur_fg,etat_offre,nomp_fg,prenomp_fg,nomservice_fg) values (?,?,?,?,?,?,?,?,?,?)";
        String req2="SELECT MAX(id) AS max_id FROM `offre_service`";
        PreparedStatement ste1;
        try {
            ste1 = c.prepareStatement(req2);
             //ste.setInt(1,id);
          ResultSet res1= ste1.executeQuery(req2);
          while (res1.next()) { 
          int id=res1.getInt("max_id");
          id_offre=id+1;
          }
        } catch (SQLException ex) {
            Logger.getLogger(gestion_offre_service.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       try {
        
            PreparedStatement ste = c.prepareStatement(req1);
            
            ste.setString(1, O.getAdresse());
            ste.setString(2, O.getDate_debut());
            ste.setString(3, O.getHeure());
            ste.setString(5, O.getDescription_offre());
            ste.setString(4, O.getTel());   
            ste.setInt(6,O.getIposteurfg());
            ste.setString(7, O.getEtatoffre());
            ste.setString(8,O.getNomposteur());
            ste.setString(9,O.getPrenomposteur());
            ste.setString(10,O.getNomservice());
            
            

            ste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(gestion_offre_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Offre> afficherOffre(int o) {
        
            List<Offre> offre = new ArrayList<>();    
     // Where idposteur_fg=2' 
      try {
          String req="select * from offre_service Where idposteur_fg="+o;
      
          PreparedStatement ste = c.prepareStatement(req);
          //ste.setInt(1,id);
          ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
               Offre a = new Offre();
               
                a.setAdresse(res.getString("adress"));
                a.setDate_debut(res.getString("date"));
                a.setHeure(res.getString("heure"));
                a.setDescription_offre(res.getString("description_offre"));
                a.setEtatoffre(res.getString("etat_offre"));
                a.setNomservice(res.getString("nomservice_fg"));
                
              offre.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return offre; 
    }
    
    public List<Offre> afficherOffre_Jobeur() {
        
            List<Offre> offre = new ArrayList<>();    
     // Where idposteur_fg=2' 
      try {
          String req="select * from offre_service ";
      
          PreparedStatement ste = c.prepareStatement(req);
          
          ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
               Offre a = new Offre();
               
                a.setAdresse(res.getString("adress"));
                a.setDate_debut(res.getString("date"));
                a.setHeure(res.getString("heure"));
                a.setDescription_offre(res.getString("description_offre"));
                a.setTel(res.getString("tel"));
                a.setNomposteur(res.getString("nomp_fg"));
                a.setPrenomposteur(res.getString("prenomp_fg"));
                
              offre.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return offre; 
    }
    
     public void insererNomjobeur(String nomj,String prenomj,Integer cin_jobeur) {
        String req1 = "UPDATE `offre_service` SET `nomj_fg`=?,`prenomj_fg`=?,`cinj`=? WHERE id="+id_offre;
        try {
            System.out.println(id_offre);
            PreparedStatement ste = c.prepareStatement(req1);
            ste.setString(1, nomj);
            ste.setString(2, prenomj);
            ste.setInt(3, cin_jobeur);
            
            
            
            
            ste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(gestion_offre_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
