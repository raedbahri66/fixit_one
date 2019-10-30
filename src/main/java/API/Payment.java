/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael
 */
public class Payment {
     public static void Paymment(int montant)
     {
         Stripe.apiKey="sk_test_oVuHuDAcqZWXYhYCVpyaFt4s00qbcibbMK";
         int montants=montant*100;
         try {
             
             Customer  a = Customer.retrieve("cus_G4qTXA2aiE6KLg");
             Map <String,Object> chargeParam  = new HashMap <String,Object>();
             chargeParam.put("amount", montants);
             chargeParam.put("currency","usd");
             chargeParam.put("customer",a.getId());
             Charge.create(chargeParam);
         } 
         catch (StripeException ex) {
             Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
