/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

import java.io.File;
import tiralabra.getmeout.Algoritmit.Astar;
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Algoritmit.Dijkstra;

/**
 *
 * @author vino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File tiedosto = new File("testi.txt"); //huone, labyrintti2, testi, testi2
        Ruudukko ruudukko = new Ruudukko();
        ruudukko.alustaTiedostosta(tiedosto);
        
       
       System.out.println("Ruudukossa solmuja yhteensä: " + (ruudukko.getKorkeus()+1 ) * (ruudukko.getLeveys()+1 ));
       System.out.println("Ruudukossa kuljettavia solmuja yhteenä: " + ruudukko.getYhteensa() + "\n");
        
        Dijkstra dijkstra = new Dijkstra(ruudukko);
        Astar astar = new Astar(ruudukko);
        
        
        double aloitusaikaA = System.currentTimeMillis();
        int reittiA = astar.laskeReitti();
        double lopetusaikaA = System.currentTimeMillis();
        double aikaA = lopetusaikaA - aloitusaikaA;
        
        System.out.println("A*:lla aikaa kului: " + aikaA + " millisekuntia.");
        System.out.println("A*:lla polkua haettaessa tutkittiin yhteensä "+astar.getMaara() + " solmua.");
        System.out.println("solmuja lyhimpään polkuun kuuluu " + reittiA + " kappaletta." );
        
        System.out.println("------------------------------------------------");
        
        
        double aloitusaika = System.currentTimeMillis();
        int reittiD =  dijkstra.laskeReitti();
        double lopetusaika = System.currentTimeMillis();
        double aika = lopetusaika - aloitusaika;
       
        System.out.println("Dijkstralla aikaa kului: " + aika + " millisekuntia.");
        System.out.println("solmuja lyhimpään polkuun kuuluu " + reittiD + " kappaletta.");
        
        


    }

}
