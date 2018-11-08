/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentOptions;

/**
 *
 * @author Dev Mode
 */
public class PaymentFactory {

    public MasterCard getMasterCard(String input) {	
         return new MasterCard(input);
   }
   public Visa getVisa( String input) {	
  
         return new Visa(input);
   }
     public AmericanExpress getAmericanExpress( String input) {	
     
         return new AmericanExpress(input);

   }
    public PayPal getPayPal( String input, String password) {	
         return new PayPal(input,password);  
   }
}
