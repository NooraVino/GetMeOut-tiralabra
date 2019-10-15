/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

import java.io.File;
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
        
        File tiedosto = new File("testi.txt");

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.alustatiedostosta(tiedosto);

        double aloitusaika = System.currentTimeMillis();
        int maara =  dijkstra.laskeReitti();
        double lopetusaika = System.currentTimeMillis();
        double aika = lopetusaika - aloitusaika;
       
        System.out.println("aikaa kului: " + aika + " millisekuntia");
        System.out.println("solmuja lyhimpään polkuun kuuluu " + maara + " kappaletta.");
       

    }

}
