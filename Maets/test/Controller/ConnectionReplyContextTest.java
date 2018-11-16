/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
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
public class ConnectionReplyContextTest {
    
    public ConnectionReplyContextTest() {
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
     * Test of getStartTime method, of class ConnectionReplyContext.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Date expResult = new Date() ;
        ConnectionReplyContext instance = new ConnectionReplyContext(expResult,"asdwf");  
        Date result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class ConnectionReplyContext.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        ConnectionReplyContext instance = new ConnectionReplyContext(new Date(),"asdwf");  ;
        String expResult = "asdwf";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
