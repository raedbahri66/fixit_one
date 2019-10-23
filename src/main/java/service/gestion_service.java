/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entites.Service;
import iService.IService;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import utils.ConnexionBD;

/**
 *
 * @author asus
 */
public class gestion_service  implements IService{
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    public gestion_service() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void creerService(Service S) {
        String req1 = "insert into service (nom_service,description_service) values (?,?)";
        try {
           
            PreparedStatement ste = c.prepareStatement(req1);
            
            ste.setString(1, S.getNom_service());
            ste.setString(2, S.getDescription_service());
            
            

            ste.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(gestion_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierService(Service S) {
         
   try { 
          
      String req5 ="UPDATE service SET nom_service=?,description_service=? WHERE id= ?";
                        
                        
                
            PreparedStatement ste = c.prepareStatement(req5);
            
            ste.setString(1, S.getNom_service());
            ste.setString(2, S.getDescription_service());
            ste.setString(3, S.getId());
            
              ste.executeUpdate();
            System.out.println("" + S.getNom_service()+ " successfully modified!");
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + S.getNom_service()+ " error modification!!");
        }; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerService(Service S) {
             try {
            String req1="delete from service where"
                    + " id=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setString(1,S.getId());
            ps.executeUpdate();
            System.out.println("Delete Complete");

        } catch (SQLException ex) {
            Logger.getLogger(gestion_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Service> afficherService() {
        
               List<Service> service = new ArrayList<>();
                
            
     
      try {String req="select * from service ";
          PreparedStatement ste = c.prepareStatement(req);
          ResultSet res= ste.executeQuery(req);
          while (res.next()) { 
               Service a = new Service() ;
               
                a.setNom_service(res.getString("nom_service"));
                a.setDescription_service(res.getString("description_service"));
                a.setId(res.getString("id"));
                
              service.add(a);
          }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } return service;    
     // TODO
    }    
    
       public List<Service> Remplirliste_vide() {
        
               List<Service> service_vide = new ArrayList<>();
               Service a = new Service() ;
               service_vide.add(a);
return service_vide;    
    
}
  }
        
    
    

