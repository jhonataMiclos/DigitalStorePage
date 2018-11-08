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
public interface PaymentOption {
   public void accept(PaymentOptionVisitor paymentOptionVisitor);
   public void setValidity(boolean valid);
   public boolean getValidity();
}
