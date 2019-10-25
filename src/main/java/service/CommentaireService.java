/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Commentaire;
import iService.iCommentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class CommentaireService implements iCommentaire {
Connection c = ConnexionBD.getInstanceConnexionBD().getConnection();
    Statement ste;
    
    public CommentaireService () {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    @Override
    public void ajoutercCommentaire(Commentaire A) {
        
            String req1="INSERT INTO `commentaire` "
                    + "(`idjobeur_fg`,`idposteur_fg`,`nomp_fg`, `prenomp_fg`,`description_com`) "
                    + "VALUES (?,?,?,?,?)";
            try{ PreparedStatement ste = c.prepareStatement(req1);
            ste.setInt(1,A.getId_jobeur());
            ste.setInt(2,A.getId_posteur());
            ste.setString(3,A.getNomp());
            ste.setString(4,A.getPrenomp());
            ste.setString(5,A.getDescription());
            ste.executeUpdate();
            JOptionPane.showMessageDialog(null," commentair ajouté "); 

        } catch (SQLException e) {System.err.println(e);
    JOptionPane.showMessageDialog(null,"error ");
        }    
    }
        
  

    @Override
    public void modifierCommentaire(Commentaire A) {
    
    String req = "UPDATE  commentaire SET description_com= ? WHERE id= ?";
    
     try { PreparedStatement ste = c.prepareStatement(req);
            ste.setString(1,A.getDescription());
            ste.setInt(2,A.getId());
            System.out.println(" successfully modified!");
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("error modification!!");
        }
    }
    @Override
    public void supprimerCommentaire(Commentaire A) {
    try {
            String req1="delete from commentaire where"
                    + " id=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1,A.getId());
            ps.executeUpdate();
            System.out.println("Delete Complete");

        } catch (SQLException ex) {
            Logger.getLogger(Articlegestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public List<Commentaire> afficherCommentaire() {
    List<Commentaire> commentaires = new ArrayList<>();
           Commentaire a = null ; 
     
      try {
        String req="select * from commentaire";
        ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
                a= new Commentaire();
                a.setId(res.getInt("id"));
                a.setId_jobeur(res.getInt("idjobeur_fg"));
                a.setId_posteur(res.getInt("idposteur_fg"));
                a.setNomp(res.getString("nomp_fg"));
                a.setPrenomp(res.getString("prenomp_fg"));
                a.setDescription(res.getString("description_com"));
 commentaires.add(a);  
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }    
     return commentaires;
    
    }
    }

   

