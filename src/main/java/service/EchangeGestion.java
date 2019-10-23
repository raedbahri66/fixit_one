/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Echange;
import iService.Iechange;
import java.sql.Connection;
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
 * @author iheb
 */
public class EchangeGestion implements Iechange{
    Connection c = ConnexionBD.getInstanceConnexionBD().getConnection();
        Statement ste;

    @Override
    public void ajouterEchange(Echange E) {
                String req1="INSERT INTO `echange` "
                    + "(`nom_echange`, `description_echange`,`date`) "
                    + "VALUES (?,?,?)";
            try{
                PreparedStatement ste = c.prepareStatement(req1);
            
            ste.setString(1,E.getNom_echange());
            ste.setString(2,E.getDescription_echange());
            ste.setString(3, E.getDate());
              ste.executeUpdate();
            System.out.println("Ajout de l'echange ");
                    // JOptionPane.showMessageDialog(null,"requete execute correctement"); 
            } catch (SQLException e) 
            {System.err.println(e);
  
        } 
       
    }

    @Override
    public void modifierEchange(Echange E) {
        String req= "update echange SET  nom_echange=?,description_echange=?,date=? Where id=?";
    
   try { 
          PreparedStatement ste = c.prepareStatement(req);
          
          
          ste.setString(1,E.getNom_echange());
            ste.setString(2,E.getDescription_echange());
            ste.setString(3,E.getDate());
             ste.setString(4,E.getId());
                    
             ste.executeUpdate();
           
          
    }catch(SQLException ex)
    {
    System.out.println(ex.getMessage());
    }
       
    }

    @Override
    public void supprimerEchange(Echange E) {
        try {
            String req1="delete from echange where"
                    + " id=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
         
          ps.setString(1, E.getId());
            ps.executeUpdate();
            System.out.println("Delete Complete");
         }catch(SQLException ex)
         {
           System.out.println(ex.getMessage());  
         }
    }
      public List<Echange> afficherEchange() {
          List<Echange> echanges= new ArrayList<>();
    //Echange e = null;
      
      
      try {
         String req2="select * from echange ";
         PreparedStatement pstm = c.prepareStatement(req2);
        
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Echange e = new Echange();
              e.setId(res.getString(1));
               e.setNom_echange(res.getString(2));
                     e.setDescription_echange(res.getString(3));
                         e.setDate(res.getString(10));
                          echanges.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10)));
             
          }
        
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return echanges;
   
   
    }
      }
    

