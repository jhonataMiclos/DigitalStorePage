/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentOptions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dev Mode
 */
public class PaymentValidatonVisitorTest {
    
    public PaymentValidatonVisitorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of visit method, of class PaymentValidatonVisitor.
     */
    @Test
    public void testVisit_AmericanExpress() {      
        String input = "378282246310005";
        PaymentFactory paymentFactory=new PaymentFactory();
        PaymentValidatonVisitor visitor=new PaymentValidatonVisitor();
        AmericanExpress americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), true);
        input = "978282246310005";
        americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), false);
        input = "371449635398431";
        americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), true);
        
        input = "97828224631000534567";
        americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), false);
        
        input = "                           ";
        americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), false);
        
        input = "Money";
        americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), false);
        
        input = "3";
        americanExpress=paymentFactory.getAmericanExpress(input);
        americanExpress.accept(visitor);
        
        assertEquals(americanExpress.getValidity(), false);
        
    
    }

    /**
     * Test of visit method, of class PaymentValidatonVisitor.
     */
    @Test
    public void testVisit_Visa() {
        PaymentFactory paymentFactory=new PaymentFactory();
        PaymentValidatonVisitor visitor=new PaymentValidatonVisitor();
        String input="4012888888881881";
        System.out.println("visit");
        Visa visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
         
        assertEquals(visa.getValidity(), true);
         input="4111111111111111";
        visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
        assertEquals(visa.getValidity(), true);
        
        input="5012888888881881";
        visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
        assertEquals(visa.getValidity(), false);
        
                input="401288888888188100000000";
        visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
        assertEquals(visa.getValidity(), false);
        
                input="                      ";
        visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
        assertEquals(visa.getValidity(), false);
        
                input="Money";
        visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
        assertEquals(visa.getValidity(), false);
        
                input="4";
        visa = paymentFactory.getVisa(input);
        visa.accept(visitor);
        assertEquals(visa.getValidity(), false);
    

    }

    /**
     * Test of visit method, of class PaymentValidatonVisitor.
     */
    @Test
    public void testVisit_PayPal() {
        PaymentFactory paymentFactory=new PaymentFactory();
        PaymentValidatonVisitor visitor=new PaymentValidatonVisitor();
        System.out.println("visit");
        String input = "aaa@bbb.com";
        String password = "acd";
        PayPal payPal = paymentFactory.getPayPal(input,password);
        payPal.accept(visitor);
        
              
        assertEquals(payPal.getValidity(), true);
        input = "aaa@bbbcom";
        password = "acd";
        payPal = paymentFactory.getPayPal(input,password);
        payPal.accept(visitor);
        assertEquals(payPal.getValidity(), false);
        
         input = "aaa@bbb.com";
        password = " ";
        payPal = paymentFactory.getPayPal(input,password);
        payPal.accept(visitor);
        assertEquals(payPal.getValidity(), false);
        
         input = "aaabbbcom";
        password = "acd";
        payPal = paymentFactory.getPayPal(input,password);
        payPal.accept(visitor);
        assertEquals(payPal.getValidity(), false);
        
         input = "aaa";
        password = "acd";
        payPal = paymentFactory.getPayPal(input,password);
        payPal.accept(visitor);
        assertEquals(payPal.getValidity(), false);
        
         input = "   ";
        password = "   ";
        payPal = paymentFactory.getPayPal(input,password);
        payPal.accept(visitor);
        assertEquals(payPal.getValidity(), false);
    
    }

    /**
     * Test of visit method, of class PaymentValidatonVisitor.
     */
    @Test
    public void testVisit_MasterCard() {
        String input ="5555555555554444";
        PaymentFactory paymentFactory=new PaymentFactory();
        PaymentValidatonVisitor visitor=new PaymentValidatonVisitor();
        System.out.println("visit");
        MasterCard mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
                
        assertEquals(mastercard.getValidity(), true);
        
        input ="4555555555554444";
        mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
        assertEquals(mastercard.getValidity(), false);
        input ="5";
        mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
        assertEquals(mastercard.getValidity(), false);
        input ="5555-555555-554444 ";
        mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
        assertEquals(mastercard.getValidity(), true);
        input ="       mony ";
        mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
        assertEquals(mastercard.getValidity(), false);
        
        input ="            ";
        mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
        assertEquals(mastercard.getValidity(), false);
        
        input ="555555555555555555555555555555";
        mastercard =paymentFactory.getMasterCard(input);
        mastercard.accept(visitor);
        
        assertEquals(mastercard.getValidity(), false);
    
    }
    
}
