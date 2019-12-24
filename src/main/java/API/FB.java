/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import GUI.AcceuilController;
/*import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.scope.FacebookPermissions;
import com.restfb.scope.ScopeBuilder;
import com.restfb.types.User;*/
import entites.Posteur;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import service.ControleSaisie;
import service.JobeurService;
import service.PosteurService;


/**
 *
 * @author lenovo
 */

public class FB {
    public static Posteur pFb;
    public static  boolean alreadysignfb=false;
    public static void login() {
        boolean etat=true;
        
        
    String domain = "https://github.com/raedbahri66/fixit_one";
    String appId = "933241677062124";
    String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=email";
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

   /* WebDriver driver = new ChromeDriver();
    driver.get(authUrl);
    String accessToken;
    String accessToken2="";
    Posteur P= new Posteur();
    while(etat){

        if(!driver.getCurrentUrl().contains("facebook.com")){
            String url = driver.getCurrentUrl();
            System.err.println(url);
            accessToken = url.replaceAll(".*?access_token=(.+)&.*","$1");
            
            int indexOfLast = accessToken.lastIndexOf("&");
            if(indexOfLast >=0) 
                accessToken2 = accessToken.substring(0, indexOfLast);
            
            System.out.println(accessToken2);
            
          //  
            FacebookClient fbClient = new DefaultFacebookClient(accessToken2, Version.VERSION_4_0);
            User user = fbClient.fetchObject("me",User.class, Parameter.with("fields","first_name,last_name,email"));
            Long b= Long.parseLong(user.getId());
            System.out.println(user.getId());
            AcceuilController.cinlogin=b.intValue();
            System.out.println(b.intValue());
           // System.out.println("raed int"+toIntExact(b));
            P.setCin(b.intValue());
            P.setNom(user.getFirstName());
            P.setPrenom(user.getLastName());
            P.setEmail(user.getEmail());
    
            PosteurService P1= new PosteurService();
            ControleSaisie A1= new ControleSaisie();
            System.out.println(b.intValue());
            System.out.println(A1.isCintUsed(b.intValue()));
            int x= b.intValue();
            if(!A1.isCintUsed(x))
            {
                System.out.println(A1.isCintUsed(b.intValue()));
            P1.creerPosteurByFb(P);
            } else alreadysignfb=true;
            
            System.out.println(AcceuilController.cinlogin);
            if(!accessToken2.isEmpty()) {
                etat=false;
                driver.quit();
            }
            
        }
    }*/
    
}

}
