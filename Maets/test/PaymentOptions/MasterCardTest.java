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
public class MasterCardTest {
    
    public MasterCardTest() {
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
     * Test of accept method, of class MasterCard.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        PaymentOptionVisitor paymentOptionVisitor = null;
        MasterCard instance = null;
        instance.accept(paymentOptionVisitor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValidity method, of class MasterCard.
     */
    @Test
    public void testSetValidity() {
        System.out.println("setValidity");
        boolean valid = false;
        MasterCard instance = null;
        instance.setValidity(valid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardNumber method, of class MasterCard.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        MasterCard instance = null;
        String expResult = "";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValidity method, of class MasterCard.
     */
    @Test
    public void testGetValidity() {
        System.out.println("getValidity");
        MasterCard instance = null;
        boolean expResult = false;
        boolean result = instance.getValidity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
