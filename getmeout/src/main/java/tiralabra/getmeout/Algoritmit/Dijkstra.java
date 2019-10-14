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
    Solmu[][] solmut;
    public int korkeus;
    public int leveys;
   

    public void Dijkstra() {
        this.korkeus = 0;
        this.leveys = 0;
     

    }

    public Keko alustatiedostosta() {
        this.solmut = new Solmu[600][600];

        DijkstraKeko = new Keko();
        ArrayList<String> rivit = new ArrayList<>();

        try (Scanner lukija = new Scanner(new File("labyrintti2.txt"))) {
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());

        }

        for (int y = 0; y < rivit.size(); y++) {
            String rivi = rivit.get(y);

            for (int x = 0; x < rivi.length(); x++) {
                char arvo = rivi.charAt(x);
                Solmu solmu = new Solmu(x, y);

                solmu.setNaapurit(x, y);

                if (arvo == '.') {
                    solmu.setKuljettava();
                }
                /**
                 * Aloitussolmun lisääminen kekoon
                 */
                if (arvo == 'u') {
                    solmu.setEtaisyys(0);
                    DijkstraKeko.lisaaSolmu(solmu);
                    System.out.println(solmu.getX() + "," + solmu.getY());
                }
                /**
                 * Maalisolmun asettaminen.
                 */

                if (arvo == 'x') {
                    solmu.setKuljettava();
                    solmu.setMaali();
                }

                this.korkeus = y;
                this.leveys = x;
                solmut[y][x] = solmu;

            }

        }

        return DijkstraKeko;

    }

    /**
     * Poistaa pienimmän Solmun keosta ja jos Solmulla on naapuri niin päivittää
     * kyseisin naapurin arvot. Toistetaan kunnes Keko on tyhjä. Jos maaliSolmu
     * löytyy niin kutsutaan metodia TulostaKeko.
     */
    public void laskeReitti() {

        while (!DijkstraKeko.isEmpty()) {
            Solmu kasiteltava = DijkstraKeko.PoistaMinimi();

            if (kasiteltava.getNaapuriYla().getY() >= 0) {
                Solmu ylaNaapuri = solmut[kasiteltava.getNaapuriYla().getY()][kasiteltava.getNaapuriYla().getX()];
                // System.out.println("ylaNaapuri: " + ylaNaapuri.getKuljettava() + ylaNaapuri.getY() + ylaNaapuri.getX());
                updateSolmu(kasiteltava, ylaNaapuri);
            }

            if (kasiteltava.getNaapuriAla().getY() <= this.korkeus) {
                Solmu alaNaapuri = solmut[kasiteltava.getNaapuriAla().getY()][kasiteltava.getNaapuriAla().getX()];
                //System.out.println("alaNaapuri: " + alaNaapuri.getKuljettava() + alaNaapuri.getY() + alaNaapuri.getX());
                updateSolmu(kasiteltava, alaNaapuri);
            }

            if (kasiteltava.getNaapuriVasen().getX() >= 0) {
                Solmu VasenNaapuri = solmut[kasiteltava.getNaapuriVasen().getY()][kasiteltava.getNaapuriVasen().getX()];
                //System.out.println("VasenNaapuri: " + VasenNaapuri.getKuljettava() + VasenNaapuri.getY() + VasenNaapuri.getX());
                updateSolmu(kasiteltava, VasenNaapuri);
            }
            if (kasiteltava.getNaapuriOikea().getX() <= this.leveys) {
                Solmu OikeaNaapuri = solmut[kasiteltava.getNaapuriOikea().getY()][kasiteltava.getNaapuriOikea().getX()];
                //System.out.println("OikeaNaapuri: " + OikeaNaapuri.getKuljettava() + OikeaNaapuri.getY() + OikeaNaapuri.getX());
                updateSolmu(kasiteltava, OikeaNaapuri);
            }

            if (kasiteltava.getMaali()) {
                tulostaReitti(kasiteltava);
                return;

            }

        }
        System.out.println("reittiä ei löytynyt");
    }

    /**
     * Paivittaa kasiteltavan solmun kaikkien taulukon sisällä olevien naapurien
     * arvot jos naapuri on kuljettava.
     *
     * @param kasiteltava
     * @param naapuri
     */

    public void updateSolmu(Solmu kasiteltava, Solmu naapuri) {

        if (naapuri.getKuljettava()) {

            if (naapuri.getEtaisyys() > kasiteltava.getEtaisyys() + 1) { //jos paivitettavan etäisyys alkuun on suurempaa kuin kasiteltavan etäisyys niin srvo päivitetään.
                naapuri.setEtaisyys(kasiteltava.getEtaisyys() + 1);
                naapuri.setEdeltaja(kasiteltava);
                DijkstraKeko.lisaaSolmu(naapuri);
             
            }  

            }
        

    }



    public void tulostaReitti(Solmu maali) {
        this.maali = maali;
        System.out.println(this.maali.getY() + "," + this.maali.getX());
        while (this.maali.getEdeltaja() != null) {
            System.out.println(this.maali.getEdeltaja().getY() + "," + this.maali.getEdeltaja().getX());
            this.maali = this.maali.getEdeltaja();
        }

    }

}
