/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentOptions;

import PaymentOptions.AmericanExpress;
import PaymentOptions.PayPal;
import PaymentOptions.MasterCard;
import PaymentOptions.Visa;
import PaymentOptions.PaymentFactory;
import common.TransactionCommand;
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
public class PaymentFactoryTest {
    
    public PaymentFactoryTest() {
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
     * Test of getMasterCard method, of class PaymentFactory.
     */
    @Test
    public void testGetMasterCard() {
        System.out.println("getMasterCard");
        String input ="5555555555554444";
        PaymentFactory instance = new PaymentFactory();
        MasterCard expResult = new MasterCard(input);
        MasterCard result = instance.getMasterCard(input);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.getCardNumber(), result.getCardNumber());
        assertEquals(expResult.getValidity(), result.getValidity());
    }

    /**
     * Test of getVisa method, of class PaymentFactory.
     */
    @Test
    public void testGetVisa() {
        System.out.println("getVisa");
        String input="4012888888881881";
        PaymentFactory instance = new PaymentFactory();
        Visa expResult = new Visa(input);
        Visa result = instance.getVisa(input);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.getCardNumber(), result.getCardNumber());
        assertEquals(expResult.getValidity(), result.getValidity());
    }

    /**
     * Test of getAmericanExpress method, of class PaymentFactory.
     */
    @Test
    public void testGetAmericanExpress() {
        System.out.println("getAmericanExpress");
        String input = "378282246310005";
        PaymentFactory instance = new PaymentFactory();
        AmericanExpress expResult = new AmericanExpress(input);
        AmericanExpress result = instance.getAmericanExpress(input);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.getCardNumber(), result.getCardNumber());
        assertEquals(expResult.getValidity(), result.getValidity());
    }

    /**
     * Test of getPayPal method, of class PaymentFactory.
     */
    @Test
    public void testGetPayPal() {
        System.out.println("getPayPal");
        String input = "aaa@bbb.com";
        String password = "acd";
        PaymentFactory instance = new PaymentFactory();
        PayPal expResult = new PayPal(input,password);
        PayPal result = instance.getPayPal(input, password);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getValidity(), result.getValidity());
    }
    
}
