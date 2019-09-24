/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vino
 */
public class Dijkstra {

    Keko DijkstraKeko;

    public void Dijkstra() {

    }

    public Keko alustatiedostosta() {
        DijkstraKeko = new Keko();
        ArrayList<String> rivit = new ArrayList<>();

        try (Scanner lukija = new Scanner(new File("labyrinth.txt"))) {
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());

        }

        int a = 0;
        for (int i = 0; i < rivit.size(); i++) {
            String rivi = rivit.get(i);

            for (int j = 0; j < rivi.length(); j++) {
                char arvo = rivi.charAt(j);
                Solmu solmu = new Solmu(j, i);
                a++;

                solmu.setEtaisyys(Integer.MAX_VALUE);
                if (arvo == '1') {
                    solmu.setKuljettava();
                }
                DijkstraKeko.lisaaSolmu(solmu);
            }
        }

        DijkstraKeko.tulostaKeko();
        DijkstraKeko.PoistaMinimi();
       
        DijkstraKeko.tulostaKeko();

        return DijkstraKeko;

    }

}
