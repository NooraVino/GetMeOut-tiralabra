/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.getmeout.Ruudukko;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.algoritmit.Astar;
import tiralabra.getmeout.algoritmit.Dijkstra;
import tiralabra.getmeout.tietorakenteet.Keko;

/**
 *
 * @author vino
 */
public class AstarTest {

    File tiedosto = new File("testi5x34.txt");
    File maaliton = new File("testiMaaliton.txt");
    Keko testiKeko;
    Astar astar;
    Ruudukko ruudukko;

    public AstarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruudukko();
        ruudukko.alustaTiedostosta(tiedosto);
        astar = new Astar(ruudukko);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lyhinPolkuTest() {
        Solmu a = new Solmu(1, 0);
        Solmu b = new Solmu(2, 0);
        Solmu c = new Solmu(0, 3);
        Solmu d = new Solmu(1, 2);
        a.setEdeltaja(b);
        b.setEdeltaja(c);
        c.setEdeltaja(d);

        int maara = astar.lyhinReitti(a);
        assertEquals(maara, 3);
    }
    
    @Test
    public void UpdateSolmuPaivittaaKuljettavat() {
        Solmu kasiteltava = new Solmu(1, 1);
        kasiteltava.setMatkaAlkuun(2);
        Solmu naapuri = new Solmu(3, 4);
        naapuri.setMatkaAlkuun(Integer.MAX_VALUE);
        naapuri.setKuljettava();

        astar.updateSolmu(kasiteltava, naapuri);
        assertEquals(naapuri.getMatkaAlkuun(), 3);

    }

    @Test
    public void UpdateSolmuTajuaaEsteet() {
        Solmu kasiteltava = new Solmu(1, 1);
        kasiteltava.setEtaisyys(2);
        kasiteltava.setKuljettava();
        Solmu naapuri = new Solmu(3, 4);
        naapuri.setEtaisyys(6);

        astar.updateSolmu(kasiteltava, naapuri);
        assertEquals(naapuri.getEtaisyys(), 6);

    }


}
