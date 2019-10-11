/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.getmeout.Solmu;

/**
 *
 * @author vino
 */
public class SolmuTest {
    
    public SolmuTest() {
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

 
     @Test
     public void koordinaatitOvatOikein() {
         Solmu solmu = new Solmu(1,2);
         int x = solmu.getX();
         int y = solmu.getY();
         
         assertEquals(1==x, 2==y);
         
     }
     @Test
     public void kuljettavaVaihtuuTrueksi() {
         Solmu solmu = new Solmu(1,2);
         
         assertEquals(solmu.getKuljettava(), false);
         
         solmu.setKuljettava();
         
         assertEquals(solmu.getKuljettava(), true);
         
         
     }
     
     @Test
     public void OikeaNaapuriOikein() {
         int x = 1;
         int y = 2;
         Solmu solmu = new Solmu(x,y);
         solmu.setNaapurit(x,y);
         int naapuriX = solmu.getNaapuriOikea().getX();
         int naapuriY = solmu.getNaapuriOikea().getY();
         
         assertEquals(2==naapuriX, 2==naapuriY);
           
     }

     
     
}
