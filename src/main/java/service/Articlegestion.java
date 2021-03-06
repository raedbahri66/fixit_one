/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Article;
import iService.IArticle;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;
import static service.PosteurService.A1;
import utils.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class Articlegestion implements IArticle{
 Connection c = ConnexionBD.getInstanceConnexionBD().getConnection();
    Statement ste;
    public static Image imgS;
    
    public Articlegestion() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
     @Override
    public void ajouterArticle(Article A, FileInputStream fis, File file) {
         String req1="INSERT INTO article "
                    + "(nom_article, description_article,`date_article`,`categorie`,`source`,`image_art`) "
                    + "VALUES (?,?,?,?,?,?)";
            try{ PreparedStatement ste = c.prepareStatement(req1);
            ste.setString(1,A.getNom_article());
            ste.setString(2,A.getDescriptionarticle());
             ste.setDate(3, (Date) A.getDate_article());
            ste.setString(4,A.getCategorie());
            ste.setString(5,A.getSources());
            ste.setBinaryStream(6, (InputStream)fis, (int)file.length());
            ste.executeUpdate();
            System.out.println("Ajout article Complete");
            JOptionPane.showMessageDialog(null," artcile ajouté "); 

        } catch (SQLException e) {System.err.println(e);
    JOptionPane.showMessageDialog(null,"veuillez changer le num id parce que est déja attribue pour un autre étudient ");
        }    }
         
 
 
   @Override
    public void ajouterArticle(Article A,String fis3) {
 
            String req1="INSERT INTO article "
                    + "(nom_article, description_article,date_article,`categorie`,`source`,`image_art`) "
                    + "VALUES (?,?,?,?,?,?)";
            try{ PreparedStatement ste = c.prepareStatement(req1);
            ste.setString(1,A.getNom_article());
            ste.setString(2,A.getDescriptionarticle());
             ste.setDate(3, (Date) A.getDate_article());
            ste.setString(4,A.getCategorie());
            ste.setString(5,A.getSources());
             ste.setString(6,fis3);
              ste.executeUpdate();
            System.out.println("Ajout article Complete");
                     JOptionPane.showMessageDialog(null," artcile ajouté "); 

        } catch (SQLException e) {System.err.println(e);
    JOptionPane.showMessageDialog(null,"veuillez changer le num id parce que est déja attribue pour un autre étudient ");
        }    }
    

    @Override
    public void modifierArticle(Article A) {
        String req;
   try { 
          req= "UPDATE  article SET id= ?,nom_article= ?,description_article="
                  + " ?,categorie =? ,date_article=?,source=? WHERE id= ?";
              
            PreparedStatement ste = c.prepareStatement(req);
            ste.setInt(1,A.getId());
            ste.setString(2,A.getNom_article());
            ste.setString(3,A.getDescriptionarticle());
            ste.setDate(5,A.getDate_article());
            ste.setString(4,A.getCategorie());
            ste.setString(6,A.getSources());
            ste.setInt(7,A.getId());
            ste.executeUpdate();
            System.out.println("" + A.getNom_article()+ " successfully modified!");
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("" + A.getNom_article()+ " error modification!!");
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerArticle(Article A) {
       try {
            String req1="delete from article where"
                    + " id=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1,A.getId());
            ps.executeUpdate();
            System.out.println("Delete Complete");

        } catch (SQLException ex) {
            Logger.getLogger(Articlegestion.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> afficherArticle() {
           List<Article> articles = new ArrayList<>();
           Article a = null ; 
        String req="select * from article";
        ResultSet res = null;
     try {
         res = ste.executeQuery(req);
     } catch (SQLException ex) {
         Logger.getLogger(Articlegestion.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         while (res.next()) {
             a= new Article();
             a.setId(res.getInt(1));
             a.setNom_article(res.getString(2));
             a.setDescriptionarticle(res.getString(3));
             a.setDate_article(res.getDate("date_article"));
             a.setCategorie(res.getString("categorie"));
             a.setSources(res.getString("source"));
             articles.add(a);
         }
     } catch (SQLException ex) {
         Logger.getLogger(Articlegestion.class.getName()).log(Level.SEVERE, null, ex);
     } 
     return articles;  
    }

      public Image get_image (int id) throws SQLException, FileNotFoundException, IOException{
        String req="select * from article where id="+id;
          ResultSet res=  ste.executeQuery(req);
          while (res.next()) { 
          if(res.getString("image_art") != null)
         {
//                      InputStream is = res.getBinaryStream("image_art");
//                      OutputStream os = new FileOutputStream( new File("imgage_article.jpg"));
//                      byte[] content = new byte[2048];
//                      int size = 0;
//                      while((size = is.read(content)) != -1){
//                          os.write(content, 0, size);
//                      }
                    String url2="http://localhost/fixitweb1/web/upload/"+res.getString("image_art");
                     Image image1=new Image(url2);
                    imgS=image1;   
                      System.out.println(imgS);
                      }else imgS=null;
    
          } return imgS;
      }
      public String get_image1 (int id) throws SQLException, FileNotFoundException, IOException{
        String req="select * from article where id="+id;
         String url2=null;
          ResultSet res=  ste.executeQuery(req);
          while (res.next()) { 
          if(res.getString("image_art") != null)
         {
//                      InputStream is = res.getBinaryStream("image_art");
//                      OutputStream os = new FileOutputStream( new File("imgage_article.jpg"));
//                      byte[] content = new byte[2048];
//                      int size = 0;
//                      while((size = is.read(content)) != -1){
//                          os.write(content, 0, size);
//                      }
                    url2="http://localhost/fixitweb1/web/upload/"+res.getString("image_art");
                     Image image1=new Image(url2);
                    imgS=image1;   
                      System.out.println(imgS);
                      }else imgS=null;
    
          } return url2;
      }
}