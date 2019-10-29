/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author asus
 */
public class SMS {
     public static final String ACCOUNT_SID = "AC6cca02057db1f4ee7117152d65f8d92f";
  public static final String AUTH_TOKEN = "dbde7d1b5a14629d14d7fcaa72d9f3ec";

    public static void sendSms(){
  // Find your Account Sid and Token at twilio.com/user/account
 


    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+21623755144"),
        new PhoneNumber("+14157499365"), 
        "Il y'a Une annonce son contenu est modéfier verifier là").create();

    System.out.println(message.getSid());
  }

    
    
}
