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
public class LoginHandlerTest {
    
    public LoginHandlerTest() {
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
     * Test of validateLogin method, of class LoginHandler.
     */
    @Test
    public void testValidateLogin() {
        System.out.println("validateLogin");
        String userName = "dasdd";
        String password = "Abcd1234@";
        LoginHandler instance = new LoginHandler();
        int expResult = 0;
        int result = instance.validateLogin(userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Wrong regex");
        
        userName = "";
        password = "Abcd1234@";
        expResult = -1;
        instance = new LoginHandler();
        result = instance.validateLogin(userName, password);
        assertEquals(expResult, result);
       // fail("Wrong user name");
        
        userName = "sdasddddddddawd";
        password = "";
        expResult = -1;
        instance = new LoginHandler();
        result = instance.validateLogin(userName, password);
        assertEquals(expResult, result);
        //fail("Wrong password");
        
        userName = "asd@ ";
        password = "Abcd";
        expResult = -1;
        instance = new LoginHandler();
        result = instance.validateLogin(userName, password);
        assertEquals(expResult, result);
        //fail("Wrong username and password");
    }

    
}
