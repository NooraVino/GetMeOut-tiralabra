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
        
        File tiedosto = new File("huone.txt"); //huone, labyrintti2, testi, testi2
        Ruudukko ruudukko = new Ruudukko();
        ruudukko.alustaTiedostosta(tiedosto);
        Dijkstra dijkstra = new Dijkstra(ruudukko);
        //Heuristic h = new Heuristic();
      

      Astar pathFinder = new Astar(ruudukko);
        double aloitusaikaA = System.currentTimeMillis();
        
        int j = pathFinder.laskeReitti();
        double lopetusaikaA = System.currentTimeMillis();
        double aikaA = lopetusaikaA - aloitusaikaA;
        System.out.println("aikaa kului: " + aikaA + " millisekuntia");
        System.out.println("A* algoritmilla polkua haettaessa tutkittiin solmuja yhteensä "+pathFinder.getCount());
        System.out.println(j);
        
        System.out.println("**********************************************");
        
        
        double aloitusaika = System.currentTimeMillis();
        int maara =  dijkstra.laskeReitti();
        double lopetusaika = System.currentTimeMillis();
        double aika = lopetusaika - aloitusaika;
       
        System.out.println("aikaa kului: " + aika + " millisekuntia");
        System.out.println("solmuja lyhimpään polkuun kuuluu " + maara + " kappaletta.");
       

    }

}
