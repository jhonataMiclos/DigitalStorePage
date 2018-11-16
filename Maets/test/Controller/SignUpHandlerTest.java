/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class SignUpHandlerTest {
    
    public SignUpHandlerTest() {
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
     * Test of validateUserName method, of class SignUpHandler.
     */
    @Test
    public void testValidateUserName() {
        System.out.println("validateUserName");
        String name = "adasd";
        SignUpHandler instance = new SignUpHandler();
        boolean expResult = true;
        boolean result = instance.validateUserName(name);
        assertEquals(expResult, result);
        
        name = "";
       
        expResult = false;
        result = instance.validateUserName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of validatePassword method, of class SignUpHandler.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password = "Abcd1234@";
        SignUpHandler instance = new SignUpHandler();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
        
        
        password = "@";
        expResult = false;
        result = instance.validatePassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
