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
public class Labyrintti {

    private int[][] taulukko;
    private Solmu[] keko;
    public ArrayList<String> rivit;

    public Labyrintti() {
        this.taulukko = new int[5][5];
        this.rivit = new ArrayList<>();
        this.keko = new Solmu[25];

    }

    public void lue() {

        try (Scanner lukija = new Scanner(new File("labyrinth.txt"))) {
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    public void alusta() {
        int a = 0;
        for (int i = 0; i < rivit.size(); i++) {
            String rivi = rivit.get(i);

            for (int j = 0; j < rivi.length(); j++) {
                taulukko[i][j] = Integer.valueOf(rivi.charAt(j));
                char y = rivi.charAt(j);
                Solmu solmu = new Solmu(i, j);
                this.keko[a] = solmu;
                a++;
                /**
                 * alustetaan solmun etäisyysarvio nollaksi.
                 */
                solmu.setEtaisyys(0);
                
                if (y == '1') {

                    solmu.setKuljettava();
                }

            }
        }

    }

    public void tulostaKeko() {
        for (int i = 0; i < keko.length; i++) {
            Solmu s = keko[i];
            System.out.println(s.getKuljettava());

        }
    }

}
