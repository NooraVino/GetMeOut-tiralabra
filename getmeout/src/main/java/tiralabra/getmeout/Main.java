/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

import java.io.File;
import tiralabra.getmeout.algoritmit.Astar;
import tiralabra.getmeout.algoritmit.Dijkstra;

/**
 *
 * @author vino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File tiedosto = new File("testi512x512.txt"); //testi6x6, testi5x34, testi22x512, testi512x224, testi512x512
        Ruudukko ruudukko = new Ruudukko();
        ruudukko.alustaTiedostosta(tiedosto);

        System.out.println("Ruudukossa solmuja yhteensä: " + (ruudukko.getKorkeus() + 1) * (ruudukko.getLeveys() + 1));
        System.out.println("Ruudukossa kuljettavia solmuja yhteenä: " + ruudukko.getYhteensa() + "\n");

        Astar astar = new Astar(ruudukko);

        double aloitusaikaA = System.currentTimeMillis();
        int reittiA = astar.laskeReitti();
        double lopetusaikaA = System.currentTimeMillis();
        double aikaA = lopetusaikaA - aloitusaikaA;

        System.out.println("A*:lla aikaa kului: " + aikaA + " millisekuntia.");
        System.out.println("A*:lla polkua haettaessa tutkittiin yhteensä " + astar.getMaara() + " solmua.");
        System.out.println("solmuja lyhimpään polkuun kuuluu " + reittiA + " kappaletta.");

        System.out.println("------------------------------------------------");

        Ruudukko ruudukko1 = new Ruudukko();
        ruudukko1.alustaTiedostosta(tiedosto);
        Dijkstra dijkstra = new Dijkstra(ruudukko1);

        double aloitusaika = System.currentTimeMillis();
        int reittiD = dijkstra.laskeReitti();
        double lopetusaika = System.currentTimeMillis();
        double aika = lopetusaika - aloitusaika;

        System.out.println("Dijkstralla aikaa kului: " + aika + " millisekuntia.");
        System.out.println("solmuja lyhimpään polkuun kuuluu " + reittiD + " kappaletta.");

    }

}
