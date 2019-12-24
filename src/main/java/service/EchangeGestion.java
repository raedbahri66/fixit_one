/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Echange;
import entites.Produit;
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
import javax.swing.JOptionPane;
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
                String req1="INSERT INTO echange "
                    + "(`propositionofferte`,`propositionsouhaitee` ,`description_echange`,`date`,`idposteurfg`) "
                    + "VALUES (?,?,?,?,?)";
            try{
                PreparedStatement ste = c.prepareStatement(req1);
            
            ste.setString(1,E.getPropositionofferte());
            ste.setString(2,E.getPropositionsouhaitée());
            ste.setString(3,E.getDescription_echange());
         
            ste.setString(4, E.getDate());
             ste.setInt(5, E.getId_posteurfg());
                //System.out.println(E.getId_posteurfg());
           
       
              ste.executeUpdate();
            System.out.println("Ajout de l'echange ");
                    JOptionPane.showMessageDialog(null,"Ajout de l'echange"); 
            } catch (SQLException e) 
            {System.err.println(e);
  
        } 
       
    }

    @Override
    public void modifierEchange(Echange E) {
        String req= "update echange SET propositionofferte=?,propositionsouhaitee=?,description_echange=?,date=? Where id=?";
    
   try { 
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,E.getPropositionofferte());
          ste.setString(2,E.getPropositionsouhaitée());
            ste.setString(3,E.getDescription_echange());
            ste.setString(4,E.getDate());
             ste.setString(5,E.getId());
                    
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
         String req2="select * from echange INNER JOIN user on echange.idposteurfg=user.id ";//
         PreparedStatement pstm = c.prepareStatement(req2);
        
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Echange e = new Echange();
              e.setId(res.getString(1));
               e.setPropositionofferte(res.getString(3));
              e.setPropositionsouhaitée(res.getString(4));
                     e.setDescription_echange(res.getString(5));
                    e.setId_jobeurfg(res.getInt(22));
                     
                         e.setDate(res.getString(6));
                        e.setNom_posteur(res.getString(20));
                       
                       
                          echanges.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10)));
             
          }
        
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return echanges;
   
   
    }
        public List<Echange> Rechercheprpo(String ech){
       
            List<Echange> tableechange= new ArrayList<>();
     try{
            
        String req2="select * from echange INNER JOIN user on echange.idposteurfg=user.id Where propositionsouhaitee LIKE'"+ech+"'";// INNER JOIN posteur on echange.idposteurfg=posteur.id
         PreparedStatement pstm = c.prepareStatement(req2);
      // pstm.setString(1,ech);
          ResultSet res=  pstm.executeQuery();
            //pstm.setString(1,ech);
          while (res.next()) { 
              Echange e = new Echange();
             e.setId(res.getString(1));
               e.setPropositionofferte(res.getString(3));
              e.setPropositionsouhaitée(res.getString(4));
                     e.setDescription_echange(res.getString(5));
                    // e.setId_jobeurfg(res.getInt(5));
                     
                         e.setDate(res.getString(6));
                          e.setId_jobeurfg(res.getInt(22));
                            e.setNom_posteur(res.getString(20));
                          tableechange.add(e);
                         
          }                
   
      }   catch (SQLException ex) {
          System.out.println(ex.getMessage());
     
    }
     return tableechange;
      }
         public List<Echange> affichermesEchange(int id) {
          List<Echange> echanges= new ArrayList<>();
    //Echange e = null;
      
      
      try {
         String req2="select * from echange  where idposteurfg=? ";
         PreparedStatement pstm = c.prepareStatement(req2);
          pstm.setInt(1,id);
        
          ResultSet res=  pstm.executeQuery();
          while (res.next()) { 
              Echange e = new Echange();
              e.setId(res.getString(1));
             e.setPropositionofferte(res.getString(3));
              e.setPropositionsouhaitée(res.getString(4));
                     e.setDescription_echange(res.getString(5));
                    // e.setId_jobeurfg(res.getInt(5));
                     
                         e.setDate(res.getString(6));
                         // e.setId_jobeurfg(res.getInt(22));
                           // e.setNom_posteur(res.getString(20));
                       
                       
                          echanges.add(e);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10)));
             
          }
        
    }catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return echanges;
   
   
    }
}


    

