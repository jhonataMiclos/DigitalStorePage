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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Dev Mode
 */
@RunWith(Suite.class)


@Suite.SuiteClasses({Controller.ConnectionReplyContextTest.class,Controller.PublisherUIHandlerTest.class, Controller.ConnectionReplyInterceptorTest.class, Controller.LoggingDispatcherTest.class, Controller.PublisherUIHandlerTest.class, Controller.LoggingInterceptorTest.class, Controller.SignUpHandlerTest.class, Controller.UIHandlerTest.class, Controller.LoginHandlerTest.class})


public class ControllerSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
