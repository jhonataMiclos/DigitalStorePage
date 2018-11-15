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
 * @author jakec
 */
public class PublisherUIHandlerIT {
    
    public PublisherUIHandlerIT() {
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
     * Test of verifyGameDataInput method, of class PublisherUIHandler.
     */
    @Test
    public void testVerifyGameDataInput() {
        System.out.println("verifyGameDataInput");
        String name = "Game Name";
        String price = "22.22";
        String ageRating = "12";
        String genre = "Action";
        String desc = "This is a Game";
        String minSpecs = "Running requirements";
        String file = "/Users";
        PublisherUIHandler instance = new PublisherUIHandler(1);
        String expResult = "";
        String result = instance.verifyGameDataInput(name, price, ageRating, genre, desc, minSpecs, file);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testVerifyNameFailGameDataInput() {
        System.out.println("verifyGameDataInput");
        String name = "";
        String price = "22.22";
        String ageRating = "12";
        String genre = "Action";
        String desc = "This is a Game";
        String minSpecs = "Running requirements";
        String file = "/";
        PublisherUIHandler instance = new PublisherUIHandler(1);
        String expResult = "\n Game name incorrect";
        String result = instance.verifyGameDataInput(name, price, ageRating, genre, desc, minSpecs, file);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyMovieDataInput method, of class PublisherUIHandler.
     */
    @Test
    public void testVerifyMovieDataInput() {
        System.out.println("verifyMovieDataInput");
        String name = "Movie Name";
        String price = "22.22";
        String ageRating = "12";
        String genre = "Action";
        String desc = "This is a movie";
        String runtime = "12";
        String file = "/Users";
        PublisherUIHandler instance = new PublisherUIHandler(1);
        String expResult = "";
        String result = instance.verifyMovieDataInput(name, price, ageRating, genre, desc, runtime, file);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyMovieDataInput method, of class PublisherUIHandler.
     */
    @Test
    public void testVerifyNameFailMovieDataInput() {
        System.out.println("verifyMovieDataInput");
        String name = "";
        String price = "22.22";
        String ageRating = "12";
        String genre = "Action";
        String desc = "This is a movie";
        String runtime = "12";
        String file = "/Users";
        PublisherUIHandler instance = new PublisherUIHandler(1);
        String expResult = "\n Game name incorrect";
        String result = instance.verifyMovieDataInput(name, price, ageRating, genre, desc, runtime, file);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyMovieDataInput method, of class PublisherUIHandler.
     */
    @Test
    public void testVerifyPriceFailMovieDataInput() {
        System.out.println("verifyMovieDataInput");
        String name = "Name";
        String price = "Text";
        String ageRating = "12";
        String genre = "Action";
        String desc = "This is a movie";
        String runtime = "12";
        String file = "/Users";
        PublisherUIHandler instance = new PublisherUIHandler(1);
        String expResult = "\n Input valid Price";
        String result = instance.verifyMovieDataInput(name, price, ageRating, genre, desc, runtime, file);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerifyAgeFailMovieDataInput() {
        System.out.println("verifyMovieDataInput");
        String expResult = "\n Input valid age";
        String name = "Name";
        String price = "22.22";
        String ageRating = "Text";
        String genre = "Action";
        String desc = "This is a movie";
        String runtime = "12";
        String file = "/Users";
        PublisherUIHandler instance = new PublisherUIHandler(1);
        String result = instance.verifyMovieDataInput(name, price, ageRating, genre, desc, runtime, file);
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of getID method, of class PublisherUIHandler.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        PublisherUIHandler instance = new PublisherUIHandler(1);
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }
    
}
