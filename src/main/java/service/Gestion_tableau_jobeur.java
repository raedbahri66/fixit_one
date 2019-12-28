/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Jobeur;
import entites.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.ConnexionBD;

/**
 *
 * @author asus
 */
public class Gestion_tableau_jobeur {
     Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    public Gestion_tableau_jobeur() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public List<Jobeur> afficherJobeur_Electricien() {
        
               List<Jobeur> jobeur = new ArrayList<>();
               String job ="Electriciter";
                
            
     
      try {
          String req="SELECT * FROM user WHERE specialite=?";
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,job);
          ResultSet res= ste.executeQuery();
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
                a.setCin(res.getInt("username"));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setDate_naissance(res.getDate("date_naissance"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("specialite"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;    
     // TODO
    }  
    public List<Jobeur> RechercheJobeur(String nomj){
       
            List<Jobeur> tablejb= new ArrayList<>();
     try{
            
        String req2="select * from jobeur Where nom LIKE '"+ nomj+"'";
         PreparedStatement pstm = c.prepareStatement(req2);
         //pstm.setString(1,nomj);
         //pstm.setString(2,prenomj);
          ResultSet res=  pstm.executeQuery();
            //pstm.setString(1,ech);
          while (res.next()) { 
              Jobeur j = new Jobeur();
                j.setCin(res.getInt("cin"));
                j.setNom(res.getString("nom"));
                j.setPrenom(res.getString("prenom"));
                j.setEmail(res.getString("email"));
                j.setSexe(res.getString("sexe"));
                j.setDate_naissance(res.getDate("date_naissance"));
                j.setTel(res.getInt("tel"));
                j.setJob(res.getString("job"));
                          tablejb.add(j);
                           //echanges.add(new Echange(res.getString(2),res.getString(3),res.getDate(10))); 
          }                
   
      }   catch (SQLException ex) {
          System.out.println(ex.getMessage());
     
    }
     return tablejb;
      }
    public List<Jobeur> afficherJobeur_Menage() {
        
                  List<Jobeur> jobeur = new ArrayList<>();
               String job ="Menage";
                
            
     
      try {
          String req="SELECT * FROM user WHERE specialite=?";
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,job);
          ResultSet res= ste.executeQuery();
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
                a.setCin(res.getInt("username"));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setDate_naissance(res.getDate("date_naissance"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("specialite"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;  
     // TODO
    }
    public List<Jobeur> afficherJobeur_Plomberie() {
        
                List<Jobeur> jobeur = new ArrayList<>();
               String job ="Plombier";
                
            
     
      try {
          String req="SELECT * FROM user WHERE specialite=?";
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,job);
          ResultSet res= ste.executeQuery();
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
                a.setCin(res.getInt("username"));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setDate_naissance(res.getDate("date_naissance"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("specialite"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;  
     // TODO
    }
    public List<Jobeur> afficherJobeur_Conciergerie() {
        
               List<Jobeur> jobeur = new ArrayList<>();
               String job ="Conciergerie";
                
            
     
      try {
          String req="SELECT * FROM user WHERE specialite=?";
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,job);
          ResultSet res= ste.executeQuery();
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
                a.setCin(res.getInt("username"));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setDate_naissance(res.getDate("date_naissance"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("specialite"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;  
    }
    public List<Jobeur> afficherJobeur_Renovation() {
        
               List<Jobeur> jobeur = new ArrayList<>();
               String job ="Renovation";
                
            
     
      try {
          String req="SELECT * FROM user WHERE specialite=?";
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,job);
          ResultSet res= ste.executeQuery();
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
                a.setCin(res.getInt("username"));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setDate_naissance(res.getDate("date_naissance"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("specialite"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;     
     // TODO
    }
    public List<Jobeur> afficherJobeur_Jardinage() {
        
              List<Jobeur> jobeur = new ArrayList<>();
               String job ="Jardinage";
                
            
     
      try {
          String req="SELECT * FROM user WHERE specialite=?";
          PreparedStatement ste = c.prepareStatement(req);
          ste.setString(1,job);
          ResultSet res= ste.executeQuery();
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
                a.setCin(res.getInt("username"));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setDate_naissance(res.getDate("date_naissance"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("specialite"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;    
     // TODO
    }
}
