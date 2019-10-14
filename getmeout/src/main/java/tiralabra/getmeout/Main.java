/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

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

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.alustatiedostosta();

        double aloitusaika = System.currentTimeMillis();
        dijkstra.laskeReitti();
        double lopetusaika = System.currentTimeMillis();
        double aika = lopetusaika - aloitusaika;
        System.out.println("aikaa kului: " + aika + " millisekuntia");

    }

}
