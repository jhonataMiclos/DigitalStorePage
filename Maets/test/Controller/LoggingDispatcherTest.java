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
public class LoggingDispatcherTest {
    
    public LoggingDispatcherTest() {
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
     * Test of registerLoggingInterceptor method, of class LoggingDispatcher.
     */
   
    /**
     * Test of getDispatcher method, of class LoggingDispatcher.
     */
    @Test
    public void testGetDispatcher() {
        System.out.println("getDispatcher");
        LoggingDispatcher expResult = LoggingDispatcher.getDispatcher();
        LoggingDispatcher result = LoggingDispatcher.getDispatcher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
