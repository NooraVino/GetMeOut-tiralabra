/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Algoritmit;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Solmu;

/**
 *
 * @author vino
 */
public class Dijkstra {

    public Solmu maali;
    Keko DijkstraKeko;
    Solmu[] solmut;

    public void Dijkstra() {

    }

    public Keko alustatiedostosta() {
        this.solmut = new Solmu[25];
        DijkstraKeko = new Keko();
        ArrayList<String> rivit = new ArrayList<>();

        try (Scanner lukija = new Scanner(new File("labyrinth.txt"))) {
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());

        }
        DijkstraKeko.lisaaSolmu(new Solmu(0, 0));
        int a = 0;
        for (int y = 0; y < rivit.size(); y++) {
            String rivi = rivit.get(y);

            for (int x = 0; x < rivi.length(); x++) {
                char arvo = rivi.charAt(x);
                Solmu solmu = new Solmu(x, y);

                solmu.setNaapurit(x, y);
                solmu.setEtaisyys(Integer.MAX_VALUE);

                if (arvo == '1') {
                    solmu.setKuljettava();
                }

                solmut[a] = solmu;
                a++;
            }

        }

        return DijkstraKeko;

    }

    public void laskeReitti() {
        Solmu maali = new Solmu(2, 3);

        while (DijkstraKeko.getHeapSize() > 0) {
            Solmu kasiteltava = DijkstraKeko.PoistaMinimi();

            if (kasiteltava.getX() == maali.getX() && kasiteltava.getY() == maali.getY()) {
                //tulostaReitti();
                return;

            }

            Solmu ylaNaapuri = kasiteltava.getNaapuriYla();
            if (ylaNaapuri != null && ylaNaapuri.getKuljettava()) {
                ylaNaapuri.setEtaisyys(kasiteltava.getEtaisyys() + 1);
                ylaNaapuri.setEdeltaja(kasiteltava);
            }
            //tämä toistetaan kaikille naapureille, ala, vasen oikea ja sen jälkeen lisätään solmut kekoon.

        }

    }

}
