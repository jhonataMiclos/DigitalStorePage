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
public interface PaymentOptionVisitor{
    void visit(AmericanExpress americanExpress);
    void visit(Visa visa);
    void visit(PayPal payPal);
    void visit(MasterCard masterCard);
}
