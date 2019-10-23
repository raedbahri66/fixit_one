/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Article;
import entites.annonce;
import iService.Iannonce;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author DELL
 */
    
    public class gestionannonce implements Iannonce {
    
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public gestionannonce() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    

    public void ajouterannonce(annonce an) {
            String req1 = "insert into annonce_service (id,nom_annonce,adress,date,description_annonce,etat_annonce,tel,prix ) values (?,?,?,?,?,?,?,?)";
        try {
           
            PreparedStatement ste1 = c.prepareStatement(req1);
            ste1.setInt(1, an.getId());
            ste1.setString(2, an.getNom_annonce());
            ste1.setString(3, an.getAdress());
            ste1.setString(4, an.getDate());
            ste1.setString(5, an.getDescription_annonce());
            ste1.setString(6, an.getEtat_annonce());
            ste1.setInt(7, an.getTel());
            ste1.setInt(8, an.getPrix());
            
            
            ste1.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            Logger.getLogger(service.gestionannonce.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    
    
        public void supprimerannonce(annonce an) {
try {
            String req1="delete from annonce_service where"
                    + " nom_annonce=?";
       
      PreparedStatement ste2 = c.prepareStatement(req1);
            ste2.setString(1, an.getNom_annonce());
            ste2.executeUpdate();
            System.out.println("Delete Complete");

        } catch (SQLException ex) {
            Logger.getLogger(gestionannonce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
        public List<annonce> afficherannonce() {
        List<annonce> annonces = new ArrayList<>();
      annonce an = null ;
      String req2="select * from annonce_service";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              an = new annonce();
                      an.setId( res.getInt("id"));
                      an.setNom_annonce(res.getString("nom_annonce"));
                      an.setAdress(res.getString("adress"));
                      an.setDate( res.getString("date"));
                      an.setDescription_annonce(res.getString("Description_annonce"));
                      an.setEtat_annonce(res.getString("Etat_annonce"));
                      an.setTel( res.getInt("tel"));
                      an.setPrix( res.getInt("prix"));
                      
 annonces.add(an);   
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return annonces;
    }
  
        
        
    public void modifierannonce(annonce an) {
        String req;
   try { 
          req= "UPDATE  annonce_service SET id=?,nom_annonce= ?,adress= ?,date =? ,description_annonce=?,etat_annonce=?,tel=?,prix=? WHERE id= ?";
      
            PreparedStatement ste = c.prepareStatement(req);
            ste.setInt(1,an.getId());
            ste.setString(2,an.getNom_annonce());
            ste.setString(3,an.getAdress());
            ste.setString(4,an.getDate());
            ste.setString(5,an.getDescription_annonce());
            ste.setString(6,an.getEtat_annonce());
            ste.setInt(7,an.getTel());
            ste.setInt(8,an.getPrix());
            ste.setInt(9,an.getId());

              ste.executeUpdate();
            System.out.println("" + an.getId()+ " successfully modified!");
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + an.getId()+ " error modification!!");
        }; //To change body of generated methods, choose Tools | Templates.
    }

}
