/*



 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Posteur;
import iService.iPosteur;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.image.Image;
import javax.swing.JOptionPane;
import utils.ConnexionBD;

/**
 *
 * @author lenovo
 */
public class PosteurService implements iPosteur{
    public static Image A1;

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
    public void creerPosteur(Posteur p,FileInputStream fis,File file) {
            String req1 = "insert into posteur (cin, nom, prenom, email, sexe, password, date_naissance, tel, role, etat, image_p) values (?,?,?,?,?,?,?,?,?,?,?)";
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
            ste.setBinaryStream(11, (InputStream)fis, (int)file.length());
            

            ste.executeUpdate();
            System.out.println("Ajout Complete");
            JOptionPane.showMessageDialog(null, "Account Created Successfull");

        } catch (SQLException ex) {
            Logger.getLogger(PosteurService.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cin is already used by another ones");
        }
    }
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
            JOptionPane.showMessageDialog(null, "Account Created Successfull");

        } catch (SQLException ex) {
            Logger.getLogger(PosteurService.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cin is already used by another ones");
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

    public void BannirPosteur(Posteur p) {
try {
            String update = "UPDATE posteur SET  cin = ?, etat = ?, role= ? WHERE cin = ? ";
            PreparedStatement st2 = c.prepareStatement(update);
            st2.setInt(1, p.getCin());
            st2.setString(2, "banned");
            st2.setString(3, p.getRole());
            st2.setInt(4, p.getCin());
            st2.executeUpdate();
            System.out.println("" + p.getCin() + " successfully Bannned!");
            JOptionPane.showMessageDialog(null, "Acc successfully Bannned");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + p.getCin() + " error bannir!!");
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
    public Posteur getPosteurInfobyCin(int cin1) throws FileNotFoundException, SQLException, IOException
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
                      
                      System.out.println(res.getBytes("image_p"));
                      if(res.getBytes("image_p") != null)
                      {
                          InputStream is = res.getBinaryStream("image_p");
                      OutputStream os = new FileOutputStream( new File("img.jpg"));
                      byte[] content = new byte[2048];
                      int size = 0;
                     while((size = is.read(content)) != -1){
                          os.write(content, 0, size);
                      }
                     Image image1=new Image("file:img.jpg");
               A1=image1;
               System.out.println(A1);
                      
                        }
                      
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
              if(res.getString("etat").equals("banned")) role="banned";
              }   
          ResultSet res1=  ste.executeQuery(req2);
          if (res1.next()) { 
              role= "Jobeur_interface";
              if(res.getString("etat").equals("banned")) role="banned";
              }
       ResultSet res2=  ste.executeQuery(req3);
          if (res2.next()) { 
              role= "Admin_interface";
              }
         
              
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        System.out.println(role);
       return role; 
    }

    
    public String BannirRaison(int cin1,String password1)
    {
        String req1="select * from Posteur where cin="+cin1 +" and password="+password1;   
        String req2="select * from Jobeur where cin="+cin1 +" and password="+password1;        
        String raison = "fault";
        try {
          ResultSet res=  ste.executeQuery(req1);
          if (res.next()) { 
              if(res.getString("etat").equals("banned")) raison=res.getString("role");
              }   
          ResultSet res1=  ste.executeQuery(req2);
          if (res1.next()) { 
              if(res1.getString("etat").equals("banned")) raison=res.getString("role");
              }     
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
       return raison; 
    }
    
    @Override
    public void modifierProfil(Posteur p, InputStream fis, File file ) {
        try {
            String update = "UPDATE posteur SET  cin = ? , nom = ? , prenom = ? , email = ?, date_naissance = ? , tel = ?, image_p= ? WHERE cin = ? ";
            PreparedStatement st2 = c.prepareStatement(update);
            st2.setInt(1, p.getCin());
            st2.setString(2, p.getNom());
            st2.setString(3, p.getPrenom());
            st2.setString(4, p.getEmail());
            st2.setDate(5, p.getDate_naissance());
            st2.setInt(6, p.getTel());
            st2.setInt(8, p.getCin());
            st2.setBinaryStream(7, (InputStream)fis, (int)file.length());

            st2.executeUpdate();
            System.out.println("" + p.getCin() + " successfully modified!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + p.getCin() + " error modification!!");
        }
    
    }
    public List<Posteur> afficherPosteurbynNom(String choix,String nom) throws SQLException {
        List<Posteur> posteurs = new ArrayList<>();
      Posteur p = null ;
      String nom1="";
      nom1="'"+nom+"%'";
     System.out.println(nom1);

      String req1="select * from Posteur where "+choix+" LIKE "+nom1;
      System.out.println(req1);
      ResultSet res=  ste.executeQuery(req1);
          //ResultSet res=  ste.executeQuery(req2);
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
              System.out.println(posteurs);
        
          }
     return posteurs;
    }
    public List<Posteur> afficherPosteurbyEtat(String nom) throws SQLException {
        List<Posteur> posteurs = new ArrayList<>();
      Posteur p = null ;
      String nom1="";
      nom1="'"+nom+"%'";
      String req1="select * from Posteur where etat LIKE "+nom1;
      System.out.println(req1);
      ResultSet res=  ste.executeQuery(req1);
          //ResultSet res=  ste.executeQuery(req2);
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
     return posteurs;
    }
            
    
    
    
}
