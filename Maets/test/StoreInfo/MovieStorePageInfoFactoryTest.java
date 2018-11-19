/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreInfo;

import storeinfo.StoreListing;
import storeinfo.MovieStorePageInfoFactory;
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
public class MovieStorePageInfoFactoryTest {
    
    public MovieStorePageInfoFactoryTest() {
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
     * Test of create method, of class MovieStorePageInfoFactory.
     */
 @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        JSONObject movieJSON = new JSONObject();
        int pubID = 1;
        int prodID = 2;
        String name = "Name";
        int age = 12;
        String desc = "This is my description";
        int runtime = 12;
        String genre = "Action";
        double price = 22.22;
        movieJSON.put("productID", prodID);
        movieJSON.put("name", name);
        movieJSON.put("price", price);
        movieJSON.put("ageRating",age);
        movieJSON.put("description", desc);
        movieJSON.put("runtime", runtime);
        movieJSON.put("genre", genre);
        movieJSON.put("publisherID", pubID);
        MovieStorePageInfoFactory instance = new MovieStorePageInfoFactory();
        StoreListing result = instance.create(movieJSON);
        assertEquals(prodID, result.getProductID());
        assertEquals(name, result.getName());
    }

    /**
     * Test of getMovieInfo method, of class MovieStorePageInfoFactory.
     */
    @Test
    public void testGetMovieInfo() throws Exception {
        System.out.println("getMovieInfo");
        JSONObject movieJSON = new JSONObject();
        int pubID = 1;
        int prodID = 2;
        String name = "Name";
        int age = 12;
        String desc = "This is my description";
        int runtime = 12;
        String genre = "Action";
        double price = 22.22;
        movieJSON.put("productID", prodID);
        movieJSON.put("name", name);
        movieJSON.put("price", price);
        movieJSON.put("ageRating",age);
        movieJSON.put("description", desc);
        movieJSON.put("runtime", runtime);
        movieJSON.put("genre", genre);
        movieJSON.put("publisherID", pubID);
        MovieStorePageInfoFactory instance = new MovieStorePageInfoFactory();
        StoreListing result = instance.getMovieInfo(movieJSON);
        assertEquals(prodID, result.getProductID());
        assertEquals(name, result.getName());
    }
    
}
