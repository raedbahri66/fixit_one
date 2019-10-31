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
     public static final String ACCOUNT_SID = "AC007bab1393210939e1c0fa8c54e139ed";
  public static final String AUTH_TOKEN = "8e7f42c2086ff2372bb349b2ad8f5c07";

    public static void sendSms(){
  // Find your Account Sid and Token at twilio.com/user/account
 


    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+21621867186"),
        new PhoneNumber("+14847121334"), 
        "Vérifier Votre Application Fix-It ! Vous avez une Offre de Travail").create();

    System.out.println(message.getSid());
  }

    
    
}
