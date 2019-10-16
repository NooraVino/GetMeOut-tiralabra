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
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Algoritmit.Dijkstra;
import tiralabra.getmeout.Solmu;

/**
 *
 * @author vino
 */
public class DijkstraTest {
    File tiedosto = new File("testi.txt");
    File maaliton = new File("testi2.txt");
    Keko testiKeko;
    Dijkstra dijkstra;
    
    public DijkstraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dijkstra = new Dijkstra(tiedosto);
       
        
        
      
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void UpdateSolmuEiPaivitaJosNaapurinEtaisyysPienenpi() {
        
        
       Solmu kasiteltava = new Solmu(1, 1);
       kasiteltava.setEtaisyys(5);
       Solmu naapuri = new Solmu(3,4);
       naapuri.setEtaisyys(3);
       
       dijkstra.updateSolmu(kasiteltava, naapuri);
       assertEquals(naapuri.getEtaisyys(), 3);
        
       
      
    }
   
    @Test
    public void UpdateSolmuPaivittaaVainJosNaapuriKuljettava() {
       Solmu kasiteltava = new Solmu(1, 1);
       kasiteltava.setEtaisyys(2);
       Solmu naapuri = new Solmu(3,4);
       naapuri.setEtaisyys(6);
       naapuri.setKuljettava();
       
       dijkstra.updateSolmu(kasiteltava, naapuri);
       assertEquals(naapuri.getEtaisyys(), 3);
        
       
      
    }
    
    @Test
    public void UpdateSolmuEiPaivitaJosNaapuriEiOleKuljettava() {
       Solmu kasiteltava = new Solmu(1, 1);
       kasiteltava.setEtaisyys(2);
       kasiteltava.setKuljettava();
       Solmu naapuri = new Solmu(3,4);
       naapuri.setEtaisyys(6);
       
       
       dijkstra.updateSolmu(kasiteltava, naapuri);
       assertEquals(naapuri.getEtaisyys(), 6);
        
       
      
    }
    
  
    @Test
    public void UpdateSolmuPaivittaajosKasiteltavanEtaisyysSuurempi() {
       Solmu kasiteltava = new Solmu(1, 1);
       kasiteltava.setEtaisyys(2);
       Solmu naapuri = new Solmu(3,4);
       naapuri.setEtaisyys(6);
       naapuri.setKuljettava();
       
       dijkstra.updateSolmu(kasiteltava, naapuri);
       assertEquals(naapuri.getEtaisyys(), 3);
        
       
      
    }
    
    @Test
    public void LaskeReittiToimiiIlmanMaalia() {
        dijkstra = new Dijkstra(maaliton);
      
       
       int i = dijkstra.laskeReitti();
       assertEquals(i, 0);
        
       
      
    }

    
}
