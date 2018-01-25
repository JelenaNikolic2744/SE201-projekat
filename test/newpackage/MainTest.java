/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     */
    @Test
    public void test1() {
        System.out.println("Provera proizvoda u porudzbini");
        Sto sto = new Sto(1);
        Proizvod proizvod1 = new Proizvod("kafa", 150);
        
        Porudzbina porudzbina = new Porudzbina(sto);
        porudzbina.upisi(proizvod1);
        
        Racun racun = new Racun(porudzbina,"12.12.2017.");
 
        boolean expResult = porudzbina.getNarudzbina().contains(proizvod1); 
        assertTrue(expResult); 
        //bice tacna zato sto zapravo ima jedan proizvod

    }
    
     @Test
    public void test2() {
        System.out.println("Proracun racuna");
        Sto sto = new Sto(1);
        Proizvod proizvod1 = new Proizvod("kafa", 150);
        Proizvod proizvod2 = new Proizvod("caj",120);
        
        Porudzbina porudzbina = new Porudzbina(sto);
        porudzbina.upisi(proizvod1,proizvod2);
        
        Racun racun = new Racun(porudzbina,"12.12.2017.");
 
        int expResult = 270;
        int ukupno = racun.izracunaj(porudzbina.getNarudzbina());
        assertEquals(expResult, ukupno, 0.0);  

    }
    
}
