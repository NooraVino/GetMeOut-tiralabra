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
import tiralabra.getmeout.tietorakenteet.Lista;

/**
 *
 * @author vino
 */
public class ListaTest {

    private Lista lista;
    private String sana;

    public ListaTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lista = new Lista();
        sana = "sana";

    }

    @After
    public void tearDown() {
    }

    @Test
    public void AddLisaaKaksi() {
        lista.lisaa(sana);
        lista.lisaa(sana);
        assertTrue(lista.size() == 2);
    }

    @Test
    public void ListaPitenee() {
        for (int i = 0; i < 12; i++) {
            lista.lisaa(sana);
        }
        assertTrue(lista.size() == 12);

    }

}
