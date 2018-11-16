/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Timestamp;
import org.json.JSONArray;
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
public class UIHandlerTest {
    
    public UIHandlerTest() {
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
    @Test
    public void testDisplayLoginPanel() {
        System.out.println("displayLoginPanel");
        UIHandler instance = new UIHandler();
        instance.displayLoginPanel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductInfo() {
        System.out.println("getProductInfo");
        String productName = "";
        UIHandler instance = new UIHandler();
        String expResult = "";
        String result = instance.getProductInfo(productName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetAllGames() {
        System.out.println("getAllGames");
        UIHandler instance = new UIHandler();
        int[] expResult = null;
        int[] result = instance.getAllGames();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testAddToCart() {
        System.out.println("addToCart");
        String productName = "";
        UIHandler instance = new UIHandler();
        instance.addToCart(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPullDownCart() {
        System.out.println("pullDownCart");
        UIHandler instance = new UIHandler();
        instance.pullDownCart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    @Test
    public void testGetAllAvailableUserTypes() {
        System.out.println("getAllAvailableUserTypes");
        UIHandler instance = new UIHandler();
        String[] expResult = null;
        String[] result = instance.getAllAvailableUserTypes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetAllData() {
        System.out.println("getAllData");
        UIHandler instance = new UIHandler();
        String[] expResult = null;
        String[] result = instance.getAllData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testGetAllUserNames() {
        System.out.println("getAllUserNames");
        UIHandler instance = new UIHandler();
        String[] expResult = null;
        String[] result = instance.getAllUserNames();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetAllUserTypes() {
        System.out.println("getAllUserTypes");
        UIHandler instance = new UIHandler();
        int[] expResult = null;
        int[] result = instance.getAllUserTypes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String usernameText = "";
        UIHandler instance = new UIHandler();
        instance.setUsername(usernameText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        UIHandler instance = new UIHandler();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetCart() {
        System.out.println("getCart");
        UIHandler instance = new UIHandler();
        Object[][] expResult = null;
        Object[][] result = instance.getCart();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLibrary() {
        System.out.println("getLibrary");
        UIHandler instance = new UIHandler();
        String[] expResult = null;
        String[] result = instance.getLibrary();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testGetProductIDsByUsername() {
        System.out.println("getProductIDsByUsername");
        UIHandler instance = new UIHandler();
        int[] expResult = null;
        int[] result = instance.getProductIDsByUsername();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testLaunchProduct() {
        System.out.println("launchProduct");
        int productID = 0;
        UIHandler instance = new UIHandler();
        instance.launchProduct(productID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   */
    @Test
    public void testGetAvarages() {
        System.out.println("getAvarages");
        JSONArray array = new JSONArray();
        try{
            JSONObject userTypeJSON = new JSONObject();
            userTypeJSON.put("userName", "jhon");
            userTypeJSON.put("loginTime",Timestamp.valueOf("2018-11-15 15:26:36.0"));
            userTypeJSON.put("logoutTime",Timestamp.valueOf("2018-11-15 15:27:36.0"));
            array.put(userTypeJSON);

            JSONObject userTypeJSON2 = new JSONObject();
            userTypeJSON2.put("userName", "alice");
            userTypeJSON2.put("loginTime",Timestamp.valueOf("2018-11-15 15:26:36.0"));
            userTypeJSON2.put("logoutTime",Timestamp.valueOf("2018-11-15 15:27:36.0"));
            array.put(userTypeJSON2);
            
            JSONObject userTypeJSON3 = new JSONObject();
            userTypeJSON3.put("userName", "joe");
            userTypeJSON3.put("loginTime",Timestamp.valueOf("2018-11-15 15:26:36.0"));
            userTypeJSON3.put("logoutTime",Timestamp.valueOf("2018-11-15 15:27:36.0"));
            array.put(userTypeJSON3);
        }
        catch(Exception e){
            System.out.println("Error retrieving user login info: "+e.toString());
       }
        UIHandler instance = new UIHandler();
        String[] expResult = new String[3];
        expResult[2] = "jhon: 1.000000";
        expResult[1] = "alice: 1.000000";
        expResult[0] = "joe: 1.000000";
        String[] result = instance.getAvarages(array);
        assertArrayEquals(expResult, result);
      //  assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    
}
