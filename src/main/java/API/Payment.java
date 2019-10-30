/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael
 */
public class Payment {
     public boolean Paymment(int montant,String numCarte,int expm,int expy,String cvc) 
     {
         
         try {
             Stripe.apiKey="sk_test_oVuHuDAcqZWXYhYCVpyaFt4s00qbcibbMK";
             int montants=montant*100;  
             Map <String,Object> tokenParameter  = new HashMap <String,Object>();
             Map <String,Object> cardParameter  = new HashMap <String,Object>();
             Map <String,Object> chargeParam  = new HashMap <String,Object>();
             cardParameter.put("number", numCarte);
             cardParameter.put("exp_month", expm);
             cardParameter.put("exp_year", expy);
             cardParameter.put("cvc",cvc);
             tokenParameter.put("card",cardParameter);
             Token token=Token.create(tokenParameter);
             if (token.getId()!=null)
             {
                 chargeParam.put("amount", montants);
             chargeParam.put("currency","usd");
             chargeParam.put("source",token.getId());
             Charge charge= Charge.create(chargeParam);
            
             }
         } 
         catch (StripeException ex) {
             Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        
         return false;
         }
            
            
         return true; 

           
     }
}
            
     
     
    

