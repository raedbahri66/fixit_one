
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entites.Favoris;
import iService.IFavoris;
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
public class GestionFavoris implements IFavoris{
     Connection c = ConnexionBD.getInstanceConnexionBD().getConnection();
    Statement ste;
    
    public GestionFavoris() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

  
    @Override
    public void ajouterFavoris(Favoris A) {
        
    
      String req="INSERT INTO `favoris` "
                    + "(`idjobeur_fg`,`idposteur_fg`) "
                    + "VALUES (?,?)";
            try{ PreparedStatement ste = c.prepareStatement(req);
            ste.setInt(1,A.getCin_posteur());
            ste.setInt(2,A.getCin_jobeur());
            ste.executeUpdate();
            JOptionPane.showMessageDialog(null," jobuer ajouté à votre liste favoris "); 

        } catch (SQLException e) {System.err.println(e);
    JOptionPane.showMessageDialog(null,"error ");
        }}

    @Override
    public void supprimerFavoris(Favoris A) {
           try {
            String req1="delete from favoris where"
                    + " idjobeur_fg=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1,A.getCin_jobeur());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null," jobuer supprimé de votre liste favoris ");

        } catch (SQLException ex) {
            Logger.getLogger(Articlegestion.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }


    @Override
    public List<Favoris> afficherfavoris() {
         List<Favoris> favoriss = new ArrayList<>();
           Favoris F = null ; 
     
      try {
        String req="select * from favrois";
        ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
                F= new Favoris();
                F.setId(res.getInt(1));
                F.setCin_posteur(res.getInt(2));
                F.setCin_jobeur(res.getInt(3));
                F.setNomj(res.getString(4));
                F.setPrenomj(res.getString(5));
                F.setDatej(res.getString(6));
                F.setTelej(res.getString(7));
                F.setMailj(res.getString(8));
                F.setSpecalite(res.getString(9));
                favoriss.add(F);  
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }    
     return favoriss;
    }

    @Override
    public List<Favoris> afficherfavoris(int id_posteur1) {
           List<Favoris> favoriss = new ArrayList<>();
           Favoris F = null ; 
     
      try {
//        String req="select * from favoris INNER JOIN user where cin_posteur="+cin_posteur1;
         String req1="select * from user INNER JOIN favoris where idjobeur_fg=user.id and idposteur_fg="+id_posteur1;
        ResultSet res= ste.executeQuery(req1);
          while (res.next()) { 
                F= new Favoris();
                F.setId(res.getInt(1));
//                F.setCin_posteur(res.getInt(2));
//                F.setCin_jobeur(res.getInt(3));
                F.setNomj(res.getString(13));
                F.setPrenomj(res.getString(19));
                F.setDatej(res.getString(18));
                F.setTelej(res.getString(15));
                F.setMailj(res.getString(4));
                F.setSpecalite(res.getString(17));
                favoriss.add(F);  
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }    
     return favoriss;
        
    }
    
    public List<Favoris> recherchefavoris(int id_posteur1,String nom) {
           List<Favoris> favoriss = new ArrayList<>();
           Favoris F = null ; 
     
      try {
        String req1="select * from user INNER JOIN favoris where idjobeur_fg=user.id and idposteur_fg="+id_posteur1+" and nom like'"+nom+"'";
        ResultSet res= ste.executeQuery(req1);
          while (res.next()) { 
                F= new Favoris();
                F.setId(res.getInt(1));
//                F.setCin_posteur(res.getInt(2));
//                F.setCin_jobeur(res.getInt(3));
                F.setNomj(res.getString(13));
                F.setPrenomj(res.getString(19));
                F.setDatej(res.getString(18));
                F.setTelej(res.getString(15));
                F.setMailj(res.getString(4));
                F.setSpecalite(res.getString(17));
                favoriss.add(F);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }    
     return favoriss;
        
    }
}
