/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.Tietorakenteet.Keko;

/**
 *
 * @author vino
 */
public class KekoTest {

    Keko testiKeko;

    public KekoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testiKeko = new Keko();
        Solmu lahto = new Solmu(0, 0);
        lahto.setEtaisyys(0);
        
        testiKeko.lisaaSolmu(lahto);
        testiKeko.lisaaSolmu(new Solmu(1, 2));
        testiKeko.lisaaSolmu(new Solmu(3, 4));
        testiKeko.lisaaSolmu(new Solmu(4, 5));

    }

    @After
    public void tearDown() {
    }

    @Test
    public void IsEmptyPalauttaaTrue() {
        testiKeko.setTop(0);

        assertEquals(testiKeko.isEmpty(), true);
    }

    @Test
    public void IsEmptyEiTyhja() {
        testiKeko.setTop(10);

        assertEquals(testiKeko.isEmpty(), false);
    }

    @Test
    public void contains() {
        Solmu lisattava = new Solmu(2, 4);
        testiKeko.lisaaSolmu(lisattava);

        assertEquals(testiKeko.contains(lisattava), true);

    }

    @Test
    public void swapVaihtaaPaikatOikein() {
        Solmu s = new Solmu(1, 5);
        Solmu t = new Solmu(2, 5);
        testiKeko.lisaaSolmu(s);
        testiKeko.lisaaSolmu(t);

        testiKeko.swap(1, 6);

        assertEquals(testiKeko.getPaikka(t), 1);

    }

    @Test
    public void poistaaPienimmän() {
        
        Solmu t = new Solmu(2, 5);
        Solmu a = new Solmu(4, 6);
        Solmu b = new Solmu(3, 6);
        Solmu c = new Solmu(2, 6);
        Solmu d = new Solmu(5, 6);
        
        t.setEtaisyys(1);
        a.setEtaisyys(56);
        b.setEtaisyys(4);
        d.setEtaisyys(2);
        
        
        testiKeko.lisaaSolmu(t);
        testiKeko.lisaaSolmu(a);
        testiKeko.lisaaSolmu(b);
        testiKeko.lisaaSolmu(c);
        testiKeko.lisaaSolmu(d);
        
        
       
        

        testiKeko.PoistaMinimi(); //poistaa lahtoSolmun
        testiKeko.PoistaMinimi();
         testiKeko.PoistaMinimi();
         testiKeko.PoistaMinimi();
        int u = testiKeko.PoistaMinimi().getEtaisyys();
              

        assertEquals(u, 56);

    }

}
