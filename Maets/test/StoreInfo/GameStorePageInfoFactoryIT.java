/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo;

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jakec
 */
public class GameStorePageInfoFactoryIT {
    
    public GameStorePageInfoFactoryIT() {
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
     * Test of create method, of class GameStorePageInfoFactory.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        int pubID = 1;
        int prodID = 2;
        String name = "Name";
        int age = 12;
        String desc = "This is my description";
        int runtime = 12;
        String genre = "Action";
        double price = 22.22;
        JSONObject gameJSON = new JSONObject();
        gameJSON.put("productID", prodID);
        gameJSON.put("name", name);
        gameJSON.put("price", price);
        gameJSON.put("ageRating", age);
        gameJSON.put("description", desc);
        gameJSON.put("minimumSpecs", "Min specs");
        gameJSON.put("genre", genre);
        gameJSON.put("publisherID", pubID);
        StoreListing result = GameStorePageInfoFactory.create(gameJSON);
        assertEquals(prodID, result.getProductID());
        assertEquals(name, result.getName());
    }

    /**
     * Test of getGameInfo method, of class GameStorePageInfoFactory.
     */
    @Test
    public void testGetGameInfo() throws Exception {
        System.out.println("getGameInfo");
        int pubID = 1;
        int prodID = 2;
        String name = "Name";
        int age = 12;
        String desc = "This is my description";
        int runtime = 12;
        String genre = "Action";
        double price = 22.22;
        JSONObject gameJSON = new JSONObject();
        gameJSON.put("productID", prodID);
        gameJSON.put("name", name);
        gameJSON.put("price", price);
        gameJSON.put("ageRating", age);
        gameJSON.put("description", desc);
        gameJSON.put("minimumSpecs", "Min specs");
        gameJSON.put("genre", genre);
        gameJSON.put("publisherID", pubID);
        StoreListing result = GameStorePageInfoFactory.getGameInfo(gameJSON);
        assertEquals(prodID, result.getProductID());
        assertEquals(name, result.getName());
    }
    
}
