/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Posteur;
import iService.iPosteur;
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
 * @author lenovo
 */
public class PosteurService implements iPosteur{
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public PosteurService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void creerPosteur(Posteur p) {
            String req1 = "insert into posteur (cin, nom, prenom, email, sexe, password, date_naissance, tel, role, etat) values (?,?,?,?,?,?,?,?,?,?)";
        try {
           
            PreparedStatement ste = c.prepareStatement(req1);
            ste.setInt(1, p.getCin());
            ste.setString(2, p.getNom());
            ste.setString(3, p.getPrenom());
            ste.setString(4, p.getEmail());
            ste.setString(5, p.getSexe());
            ste.setString(6, p.getPassword());
            ste.setDate(7, (Date) p.getDate_naissance());
            ste.setInt(8, p.getTel());
            ste.setString(9, "Posteur");
            ste.setString(10, "non_valide");
            

            ste.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            Logger.getLogger(PosteurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierPosteur(Posteur p) {
try {
            String update = "UPDATE posteur SET  cin = ? , nom = ? , prenom = ? , email = ? ,sexe = ? ,"
                    + "password = ? , date_naissance = ? , tel = ? WHERE cin = ? ";
            PreparedStatement st2 = c.prepareStatement(update);
            st2.setInt(1, p.getCin());
            st2.setString(2, p.getNom());
            st2.setString(3, p.getPrenom());
            st2.setString(4, p.getEmail());
            st2.setString(5, p.getSexe());
            st2.setString(6, p.getPassword());
            st2.setDate(7, p.getDate_naissance());
            st2.setInt(8, p.getTel());
            st2.setInt(9, p.getCin());


            st2.executeUpdate();
            System.out.println("" + p.getCin() + " successfully modified!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + p.getCin() + " error modification!!");
        }
    }


    @Override
    public void supprimerPosteur(Posteur p) {
try {
            String req1="delete from Posteur where"
                    + " cin=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, p.getCin());
            ps.executeUpdate();
            System.out.println("Delete Complete");

        } catch (SQLException ex) {
            Logger.getLogger(PosteurService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Posteur> afficherPosteur() {
        List<Posteur> posteurs = new ArrayList<>();
      Posteur p = null ;
      String req2="select * from Posteur";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              p = new Posteur();
                      p.setId( res.getInt("id"));
                      p.setCin(res.getInt("cin") );
                      p.setNom(res.getString("nom"));
                      p.setPrenom(res.getString("prenom"));
                      p.setEmail(res.getString("email"));
                      p.setSexe(res.getString("sexe"));

                      p.setPassword(res.getString("password"));
                      p.setDate_naissance(res.getDate("date_naissance"));
                      p.setTel(res.getInt("tel"));
                      p.setRole(res.getString("role"));
                      p.setEtat(res.getString("etat"));
 posteurs.add(p);
             
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return posteurs;
    }
    public Posteur getPosteurInfobyCin(int cin1)
    {
        Posteur p = new Posteur();
      String req2="select * from Posteur where cin="+cin1;   
      try {
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
                      p.setId( res.getInt("id"));
                      p.setCin(res.getInt("cin") );
                      p.setNom(res.getString("nom"));
                      p.setPrenom(res.getString("prenom"));
                      p.setEmail(res.getString("email"));
                      p.setSexe(res.getString("sexe"));
                      p.setPassword(res.getString("password"));
                      p.setDate_naissance(res.getDate("date_naissance"));
                      p.setTel(res.getInt("tel"));
                      p.setRole(res.getString("role"));
                      p.setEtat(res.getString("etat")); 
          }    
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        return p; 
    }
    
    public String login(int cin1,String password1)
    {
        String req1="select * from Posteur where cin="+cin1 +" and password="+password1;   
        String req2="select * from Jobeur where cin="+cin1 +" and password="+password1;
        String req3="select * from admin where cin="+cin1 +" and password="+password1;   
        
        String role = "fault";
        System.out.println(req1);
        try {
          ResultSet res=  ste.executeQuery(req1);
          if (res.next()) { 
              role= "Posteur_interface";
              }   
          ResultSet res1=  ste.executeQuery(req2);
          if (res1.next()) { 
              role= "Jobeur_interface";
              }
       ResultSet res2=  ste.executeQuery(req3);
          if (res2.next()) { 
              role= "Admin_interface";
              }
         
              
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
       return role; 
    }

    @Override
    public void modifierProfil(Posteur p) {
        try {
            String update = "UPDATE posteur SET  cin = ? , nom = ? , prenom = ? , email = ?, date_naissance = ? , tel = ? WHERE cin = ? ";
            PreparedStatement st2 = c.prepareStatement(update);
            st2.setInt(1, p.getCin());
            st2.setString(2, p.getNom());
            st2.setString(3, p.getPrenom());
            st2.setString(4, p.getEmail());
            st2.setDate(5, p.getDate_naissance());
            st2.setInt(6, p.getTel());
            st2.setInt(7, p.getCin());


            st2.executeUpdate();
            System.out.println("" + p.getCin() + " successfully modified!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + p.getCin() + " error modification!!");
        }
    
    }
            
    
    
    
}
