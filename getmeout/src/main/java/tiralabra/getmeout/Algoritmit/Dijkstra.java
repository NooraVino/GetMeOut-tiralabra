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
   private Solmu maali;
    Keko DijkstraKeko;

    public void Dijkstra() {
        Solmu maali = new Solmu (2,4);

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
        for (int y = 0; y < rivit.size(); y++) {
            String rivi = rivit.get(y);

            for (int x = 0; x < rivi.length(); x++) {
                char arvo = rivi.charAt(x);
                Solmu solmu = new Solmu(x, y);
                solmu.setNaapurit(x,y);
                System.out.print(solmu.getX());
                System.out.print(solmu.getY() + "   ");
                System.out.print(solmu.getNaapuriOikea().getX());
                System.out.println(solmu.getNaapuriOikea().getY());
              
                a++;

                solmu.setEtaisyys(Integer.MAX_VALUE);
                if (arvo == '1') {
                    solmu.setKuljettava();
                }
                DijkstraKeko.lisaaSolmu(solmu);
            }
        }
        
     
        DijkstraKeko.tulostaKeko();
       
       
        return DijkstraKeko;

    }
     public void laskeReitti() {
         
         
         while (DijkstraKeko.getHeapSize() > 0) {
         Solmu kasiteltava = DijkstraKeko.PoistaMinimi();
         
         
         if (kasiteltava.getX() == maali.getX() && kasiteltava.getY() == maali.getY()) {
            //tulostaReitti();
            return;
         
         }
         
         }
         
         
         
            
                 }

}
