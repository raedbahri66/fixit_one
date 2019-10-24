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
    
    public List<Jobeur> afficherJobeur() {
        
               List<Jobeur> jobeur = new ArrayList<>();
                
            
     
      try {String req="select * from jobeur ";
          PreparedStatement ste = c.prepareStatement(req);
          ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
               Jobeur a = new Jobeur() ;
               
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setEmail(res.getString("email"));
                a.setSexe(res.getString("sexe"));
                a.setTel(res.getInt("tel"));
                a.setJob(res.getString("job"));
                
                
              jobeur.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return jobeur;    
     // TODO
    }    
    
}
