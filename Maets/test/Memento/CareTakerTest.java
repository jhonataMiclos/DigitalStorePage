/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import UI.LoginPanel;
import javax.swing.JPanel;
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
public class CareTakerTest {
    
    public CareTakerTest() {
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
     * Test of getInstance method, of class CareTaker.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        CareTaker expResult =CareTaker.getInstance();
        CareTaker result = CareTaker.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class CareTaker.
     */
    @Test
    public void test() {
        System.out.println("add");
        JPanel Test=new JPanel();
        Memento state = new Memento(Test);
        CareTaker instance = new CareTaker();
        instance.add(state);
        int n = 1;
        Memento result = instance.get(n);
        assertEquals(Test, result.getState());
    }

    
}
