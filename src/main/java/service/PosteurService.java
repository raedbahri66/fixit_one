/*



 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Jobeur;
import entites.Posteur;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;
import iService.iPosteur;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;


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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.apache.commons.logging.Log;


import utils.ConnexionBD;

/**
 *
 * @author lenovo
 */
public class PosteurService implements iPosteur{
    public static Image A1;
        public static boolean pFb=false;

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
            String req1 = "insert into user (username, nom, prenom, email, sexe, password, date_naissance, tel, roles, etat, image_p) values (?,?,?,?,?,?,?,?,?,?,?)";
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
            ste.setString(9, "POSTEUR");
            ste.setString(10, "Active");
            ste.setBinaryStream(11, (InputStream)fis, (int)file.length());
            

            ste.executeUpdate();
            System.out.println("Ajout Complete");
            JOptionPane.showMessageDialog(null, "Account Created Successfull");

        } catch (SQLException ex) {
            Logger.getLogger(PosteurService.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cin is already used by another ones");
        }
    }
    @Override
    public void creerPosteur(Posteur p) {
            String req1 = "insert into user (username, nom, prenom, email, sexe, password, date_naissance, tel, roles, etat) values (?,?,?,?,?,?,?,?,?,?)";
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
            ste.setString(10, "Active");
            

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
            String update = "UPDATE user SET  username = ? , nom = ? , prenom = ? , email = ? ,sexe = ? ,"
                    + "password = ? , date_naissance = ? , tel = ? WHERE username = ? ";
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
    public void BannirPosteur(Posteur p) {
try {
            String update = "UPDATE user SET  username = ?, etat = ?, role= ? WHERE username = ? ";
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
            String req1="delete from user where"
                    + " username=?";
       
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
      String req2="select * from user where roles LIKE '%POSTEUR%'";
      try {
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              p = new Posteur();
                      p.setId( res.getInt("id"));
                      p.setCin(res.getInt("username") );
                      p.setNom(res.getString("nom"));
                      p.setPrenom(res.getString("prenom"));
                      p.setEmail(res.getString("email"));
                      p.setSexe(res.getString("sexe"));
                      p.setPassword(res.getString("password"));
                      p.setDate_naissance(res.getDate("date_naissance"));
                      p.setTel(res.getInt("tel"));
                      p.setRole(res.getString("roles"));
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
      String req2="select * from user where username="+cin1;   
      try {
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
                      p.setId( res.getInt("id"));
                      p.setCin(res.getInt("username") );
                      p.setNom(res.getString("nom"));
                      p.setPrenom(res.getString("prenom"));
                      p.setEmail(res.getString("email"));
                      p.setSexe(res.getString("sexe"));
                      p.setPassword(res.getString("password"));
                      p.setDate_naissance(res.getDate("date_naissance"));
                      p.setTel(res.getInt("tel"));
                      p.setRole(res.getString("roles"));
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
    
    
    private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  static InputStream is = null;
static JSONObject jObj = null;
static String json = "";
  public String getJSONFromUrl(String url) {
        String line1 = null;

    // Making HTTP request
    try {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
                String line = null;

        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
            line1=line;
            System.out.println("raed s "+line);
        }
        is.close();
        json = sb.toString();

    } catch (Exception e) {
    }

    // try parse the string to a JSON object
    try {
        jObj = new JSONObject(json);
    } catch (JSONException e) {
        System.out.println("error on parse data in jsonparser.java");
    }

    // return JSON String
    return line1;

}
    @Override
    public String login(int cin1,String password1)
    {
        
     
        String json = getJSONFromUrl("http://localhost/fixitweb1/web/app_dev.php/login" + cin1 + "/" + password1);
        System.out.println("fff  "+json);
        String req1="select * from user where username="+cin1 +" and password="+password1 +" and roles LIKE '%POSTEUR%'";
        String req2="select * from user where username="+cin1 +" and password="+password1+" and roles LIKE '%JOBEUR%'";
        String req3="select * from user where username="+cin1 +" and password="+password1+" and roles LIKE '%ADMIN%'";
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
                if(res1.getString("etat").equals("banned")) role="banned";
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

    
    @Override
    public String BannirRaison(int cin1,String password1)
    {
        String req1="select * from user where username="+cin1 +" and password="+password1;   
        String req2="select * from user where username="+cin1 +" and password="+password1;        
        String raison = "fault";
        try {
          ResultSet res=  ste.executeQuery(req1);
          if (res.next()) { 
              if(res.getString("etat").equals("banned")) raison=res.getString("role");
              }   
          ResultSet res1=  ste.executeQuery(req2);
          if (res1.next()) { 
              if(res1.getString("etat").equals("banned")) raison=res1.getString("role");
              }     
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
       return raison; 
    }
    
    @Override
    public void modifierProfil(Posteur p, InputStream fis, File file ) {
        try {
            String update = "UPDATE user SET  username = ? , nom = ? , prenom = ? , email = ?, date_naissance = ? , tel = ?, image_p= ? WHERE username = ? ";
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
    
    public void modifierProfil(Posteur p ) {
        try {
            String update = "UPDATE user SET  username = ? , nom = ? , prenom = ? , email = ?, date_naissance = ? , tel = ? WHERE username = ? ";
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
    
    @Override
    public List<Posteur> afficherPosteurbynNom(String choix,String nom) throws SQLException {
        List<Posteur> posteurs = new ArrayList<>();
      Posteur p = null ;
      String nom1="";
      nom1="'"+nom+"%'";
     System.out.println(nom1);

      String req1="select * from user where roles LIKE '%POSTEUR%' and "+choix+" LIKE "+nom1;
      System.out.println(req1);
      ResultSet res=  ste.executeQuery(req1);
          //ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              p = new Posteur();
                      p.setId( res.getInt("id"));
                      p.setCin(res.getInt("username") );
                      p.setNom(res.getString("nom"));
                      p.setPrenom(res.getString("prenom"));
                      p.setEmail(res.getString("email"));
                      p.setSexe(res.getString("sexe"));
                      p.setPassword(res.getString("password"));
                      p.setDate_naissance(res.getDate("date_naissance"));
                      p.setTel(res.getInt("tel"));
                      p.setRole(res.getString("roles"));
                      p.setEtat(res.getString("etat"));
 posteurs.add(p);
              System.out.println(posteurs);
        
          }
     return posteurs;
    }
    @Override
    public List<Posteur> afficherPosteurbyEtat(String nom) throws SQLException {
        List<Posteur> posteurs = new ArrayList<>();
      Posteur p = null ;
      String nom1="";
      nom1="'"+nom+"%'";
      String req1="select * from user where roles LIKE '%POSTEUR%' and etat LIKE "+nom1;
      System.out.println(req1);
      ResultSet res=  ste.executeQuery(req1);
          //ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              p = new Posteur();
                      p.setId( res.getInt("id"));
                      p.setCin(res.getInt("username") );
                      p.setNom(res.getString("nom"));
                      p.setPrenom(res.getString("prenom"));
                      p.setEmail(res.getString("email"));
                      p.setSexe(res.getString("sexe"));
                      p.setPassword(res.getString("password"));
                      p.setDate_naissance(res.getDate("date_naissance"));
                      p.setTel(res.getInt("tel"));
                      p.setRole(res.getString("roles"));
                      p.setEtat(res.getString("etat"));
 posteurs.add(p);
          }
     return posteurs;
    }
            
    @Override
    public String Emailget(int cin1) throws SQLException
    {
        String req1="select * from user where roles LIKE '%POSTEUR%' and username="+cin1;   
        String req2="select * from user where roles LIKE '%JOBEUR%' and username="+cin1 ;
         
        
        String email = "fault";
        System.out.println(req1);
        
          ResultSet res=  ste.executeQuery(req1);
          while (res.next()) { 
              email= res.getString("email");
              
            //  if(res.getString("etat").equals("banned")) role="banned";
              }   
          ResultSet res1=  ste.executeQuery(req2);
          while (res1.next()) { 
              email= res1.getString("email");
            //  if(res1.getString("etat").equals("banned")) role="banned";
              }
        System.out.println(email);
       return email; 
    }
    @Override
    public String Passwordget(int cin1) throws SQLException
    {
        String req1="select * from user where username="+cin1;   
        String req2="select * from user where username="+cin1 ;
         
        
        String password = "fault";
        System.out.println(req1);
        
          ResultSet res=  ste.executeQuery(req1);
          while (res.next()) { 
              password= res.getString("password");
              
            //  if(res.getString("etat").equals("banned")) role="banned";
              }   
          ResultSet res1=  ste.executeQuery(req2);
          while (res1.next()) { 
              password= res1.getString("password");
            //  if(res1.getString("etat").equals("banned")) role="banned";
              }
        System.out.println(password);
       return password; 
    }
    @Override
    public void creerPosteurByFb(Posteur p) {
         String req1 = "insert into user (username, nom, prenom, email) values (?,?,?,?)";
        try {
            PreparedStatement ste = c.prepareStatement(req1);
            ste.setInt(1, p.getCin());
            ste.setString(2, p.getNom());
            ste.setString(3, p.getPrenom());
            ste.setString(4, p.getEmail());
            ste.executeUpdate();
            System.out.println("Ajout Complete pp");
           pFb=true;
        } catch (SQLException ex) {
            Logger.getLogger(PosteurService.class.getName()).log(Level.SEVERE, null, ex);
          //  JOptionPane.showMessageDialog(null, "Cin is already used by another ones");
        }
    }
    
    
}
