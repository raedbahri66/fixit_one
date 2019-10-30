/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import utils.ConnexionBD;

/**
 *
 * @author lenovo
 */
public class ControleSaisie {
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public ControleSaisie() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean emailisValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public boolean cinisValid(String cin)
    {
        int taille = cin.length();
        if( taille==8 && isInt(cin))
        {
            return true;
        }
        else return false;
        
    }
    public boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }
    public boolean isCintUsed(int cin1)
    {
            String cin11 = null;
        String req1="select * from Posteur where cin="+cin1 ;   
        String req2="select * from Jobeur where cin="+cin1;
        boolean etat= false;
        
        try {
          ResultSet res=  ste.executeQuery(req1);
          if (res.next()) { 
              cin11=res.getString("cin");
          }   
          ResultSet res1=  ste.executeQuery(req2);
          if (res1.next()) { 
              cin11=res1.getString("cin");
              }
              
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        System.out.println("Read cin:"+cin11+"  "+cin1);
        if(cin11.equals(cin1))
            etat= true;
                    else etat=false;
             return etat; 

  
    }
}
    

