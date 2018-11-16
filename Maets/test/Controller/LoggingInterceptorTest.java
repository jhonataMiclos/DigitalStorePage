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
public class LoggingInterceptorTest {
    
    public LoggingInterceptorTest() {
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
     * Test of getInterceptor method, of class LoggingInterceptor.
     */
    @Test
    public void testGetInterceptor() {
        System.out.println("getInterceptor");
        LoggingInterceptor expResult = LoggingInterceptor.getInterceptor();
        LoggingInterceptor result = LoggingInterceptor.getInterceptor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
