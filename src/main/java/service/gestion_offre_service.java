/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entites.Offre;
import entites.Service;

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
public class gestion_offre_service{
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
        
       String req1 = "INSERT INTO `offre_service` (`adress`, `date`, `heure`, `description_offre`, `etat_offre`, `tel`, `Specialite`,`idposteur_fg`) VALUES (?,?,?,?,?,?,?,?)";
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
            ste.setString(4, O.getDescription_offre());
            ste.setString(6, O.getEtatoffre());
            ste.setString(5, O.getTel()); 
            ste.setString(7, O.getSpecialite());
            ste.setInt(8, O.getIdposteur());
            
            

            ste.executeUpdate();
            System.out.println("Ajout de l'offre ");
        } catch (SQLException ex) {
          System.err.println(ex);
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
               Offre a = new Offre(req, req, req, req, req, req, req);
               
                a.setAdresse(res.getString("adress"));
                a.setDate_debut(res.getString("date"));
                a.setHeure(res.getString("heure"));
                a.setDescription_offre(res.getString("description_offre"));
                a.setEtatoffre(res.getString("etat_offre"));
                a.setSpecialite(res.getString("Specialite"));
                
                
              offre.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return offre; 
    }
    
    public List<Offre> afficherOffre_Jobeur(int cin_jobeur) {
        
            List<Offre> offre = new ArrayList<>();    
     // Where idposteur_fg=2' 
      try {
          String req="select * from offre_service INNER JOIN jobeur ON offre_service.cinj = jobeur.cin Where cinj="+cin_jobeur;
      
          PreparedStatement ste = c.prepareStatement(req);
          
          ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
               Offre a = new Offre();
               
                a.setAdresse(res.getString("adress"));
                a.setDate_debut(res.getString("date"));
                a.setHeure(res.getString("heure"));
                a.setDescription_offre(res.getString("description_offre"));
                a.setTel(res.getString("tel"));
               
                a.setId(res.getString("id"));
                
              offre.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return offre; 
    }
    
     public void insererNomjobeur(Integer idj2) {
        String req1 = "INSERT INTO `offre_service` (`idjobeur_fg`) VALUES (?) WHERE id="+id_offre;
        try {
            System.out.println(id_offre);
            PreparedStatement ste = c.prepareStatement(req1);
            ste.setInt(1, idj2);
           
            
            
            
            
            ste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(gestion_offre_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void Accepter_Offre_service(String Id) throws SQLException{
     String mot ="Accepter";
     String req1 = "UPDATE `offre_service` SET `etat_offre`=? WHERE id="+Id;
         try {
           PreparedStatement ste = c.prepareStatement(req1);
            ste.setString(1,mot);
             ste.executeUpdate();
     
     } catch(SQLException ex) {
            Logger.getLogger(gestion_offre_service.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
       public void Refuser_Offre_service(String Id) throws SQLException{
     String mot ="Refuser";
     String req1 = "UPDATE `offre_service` SET `etat_offre`=? WHERE id="+Id;
     try {
           PreparedStatement ste = c.prepareStatement(req1);
            ste.setString(1,mot);
             ste.executeUpdate();
     
     } catch(SQLException ex) {
            Logger.getLogger(gestion_offre_service.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
    
    
}
