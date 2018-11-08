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
public class PayPal implements PaymentOption{
     private String email;
     private String password;
    private boolean valid = false;
    PayPal(String input, String password) {
        email=input;
        this.password=password;
    }

    @Override
    public void accept(PaymentOptionVisitor paymentOptionVisitor) {
        paymentOptionVisitor.visit(this);
    }

    @Override
    public void setValidity(boolean valid) {
        this.valid=valid;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    @Override
    public boolean getValidity() {
        return valid;
    } 
}
