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
public class ConnectionReplyInterceptorTest {
    
    public ConnectionReplyInterceptorTest() {
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
     * Test of preRemoteReply method, of class ConnectionReplyInterceptor.
     */
    @Test
    public void testPreRemoteReply() {
        System.out.println("preRemoteReply");
        ConnectionReplyContext context = null;
        ConnectionReplyInterceptor instance = new ConnectionReplyInterceptorImpl();
        instance.preRemoteReply(context);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of postRemoteReply method, of class ConnectionReplyInterceptor.
     */
    @Test
    public void testPostRemoteReply() {
        System.out.println("postRemoteReply");
        ConnectionReplyContext context = null;
        ConnectionReplyInterceptor instance = new ConnectionReplyInterceptorImpl();
        instance.postRemoteReply(context);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    public class ConnectionReplyInterceptorImpl implements ConnectionReplyInterceptor {

        public void preRemoteReply(ConnectionReplyContext context) {
        }

        public void postRemoteReply(ConnectionReplyContext context) {
        }
    }
    
}
