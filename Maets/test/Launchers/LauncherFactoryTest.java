/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launchers;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
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
public class LauncherFactoryTest {
    
    public LauncherFactoryTest() {
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
     * Test of makeLauncher method, of class LauncherFactory.
     */
   @Test
    public void testMakeLauncher() {
        try {
            System.out.println("makeLauncher");
            JSONObject launcherInfo = new JSONObject();
            String fileLocation = "Test1";
            int id = 1;
            double revision = 2.2;
            launcherInfo.put("fileLocation", fileLocation);
            launcherInfo.put("productID", id);
            launcherInfo.put("revisionNumber", revision);
            LauncherFactory instance = new LauncherFactory();
            Launcher result = instance.makeLauncher(launcherInfo);
            assertEquals(fileLocation, result.getFileLocation());
            assertEquals(id, result.getProductID());
            assertEquals(revision, result.getRevisionNumber(), 0.0001);
        } catch (JSONException ex) {
            Logger.getLogger(LauncherFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
