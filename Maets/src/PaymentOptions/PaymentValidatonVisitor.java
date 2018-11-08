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
public class PaymentValidatonVisitor implements PaymentOptionVisitor{

    @Override
    public void visit(AmericanExpress americanExpress) {
        String cardNumber=americanExpress.getCardNumber();
        cardNumber.replaceAll("-","");
        cardNumber.replaceAll(" ","");
        
        americanExpress.setValidity(cardNumber.matches("^3[47][0-9]{13}$"));
    }

    @Override
    public void visit(Visa visa) {
        String cardNumber=visa.getCardNumber();
        cardNumber.replaceAll("-","");
        cardNumber.replaceAll(" ","");
        
        visa.setValidity(cardNumber.matches("^4[0-9]{12}(?:[0-9]{3})?$"));
    }

    @Override
    public void visit(PayPal payPal) {
        String email = payPal.getEmail();
        String password = payPal.getPassword();
      if(email.matches(".+\\@.+\\..+")){
          payPal.setValidity(password.matches(".*[a-z]"));
      }
    }

    @Override
    public void visit(MasterCard masterCard) {
        String cardNumber=masterCard.getCardNumber();
        cardNumber.replaceAll("-","");
        cardNumber.replaceAll(" ","");
        
        masterCard.setValidity(cardNumber.matches("^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$"));
    }
    
}
