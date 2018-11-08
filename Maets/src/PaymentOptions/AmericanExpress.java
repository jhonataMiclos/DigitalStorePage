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
public class AmericanExpress implements PaymentOption{
    private String cardNumber;
    private boolean valid = false;
    AmericanExpress(String input) {
        cardNumber= input;
    }

    @Override
    public void accept(PaymentOptionVisitor paymentOptionVisitor) {
        paymentOptionVisitor.visit(this);
    }

    @Override
    public void setValidity(boolean valid) {
        this.valid=valid;
    }
    
    public String getCardNumber(){
        return cardNumber;
    }
    
    @Override
    public boolean getValidity() {
        return valid;
    }
    
}
