/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Algoritmit;

import java.io.File;
//import java.util.ArrayList;
import java.util.Scanner;
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.Tietorakenteet.Lista;

/**
 *
 * @author vino
 */
public class Dijkstra {

    //public Solmu maali;
    Keko DijkstraKeko;
    Solmu[][] solmut;
    public int korkeus;
    public int leveys;
    public int yhteensa;
    public int vierailuja;
    Lista rivit;

    public void Dijkstra() {
        this.korkeus = 0;
        this.leveys = 0;
        this.yhteensa = 0;
        this.vierailuja = 0;
    }

    public Keko alustatiedostosta(File tiedosto) {
        this.solmut = new Solmu[600][600];

        DijkstraKeko = new Keko();
        //ArrayList<String> rivit = new ArrayList<>();
        rivit = new Lista();

        try (Scanner lukija = new Scanner(tiedosto)) {
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
                    yhteensa++;
                    solmu.setEtaisyys(0);
                    DijkstraKeko.lisaaSolmu(solmu);

                }
                /**
                 * Maalisolmun asettaminen.
                 */

                if (arvo == 'x') {
                    yhteensa++;
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
    public int laskeReitti() {
        int maara = 0;

        while (!DijkstraKeko.isEmpty()) {
            Solmu kasiteltava = DijkstraKeko.PoistaMinimi();

            if (kasiteltava.getNaapuriYla().getY() >= 0) {
                Solmu ylaNaapuri = solmut[kasiteltava.getNaapuriYla().getY()][kasiteltava.getNaapuriYla().getX()];
                updateSolmu(kasiteltava, ylaNaapuri);
            }

            if (kasiteltava.getNaapuriAla().getY() <= this.korkeus) {
                Solmu alaNaapuri = solmut[kasiteltava.getNaapuriAla().getY()][kasiteltava.getNaapuriAla().getX()];
                updateSolmu(kasiteltava, alaNaapuri);
            }

            if (kasiteltava.getNaapuriVasen().getX() >= 0) {
                Solmu VasenNaapuri = solmut[kasiteltava.getNaapuriVasen().getY()][kasiteltava.getNaapuriVasen().getX()];
                updateSolmu(kasiteltava, VasenNaapuri);
            }
            if (kasiteltava.getNaapuriOikea().getX() <= this.leveys) {
                Solmu OikeaNaapuri = solmut[kasiteltava.getNaapuriOikea().getY()][kasiteltava.getNaapuriOikea().getX()];
                updateSolmu(kasiteltava, OikeaNaapuri);
            }

            if (kasiteltava.getMaali()) {

                maara = tulostaReitti(kasiteltava);
            }

        }

        System.out.println("kuljettavia solmuja yhteenä: " + yhteensa);
        System.out.println("kaikenkaikkiaan solmuja: " + (korkeus + 1) * (leveys + 1));

        if (maara == 0) {
            System.out.println("maalia ei löytynyt");
        }
        return maara;
    }

    /**
     * Paivittaa kasiteltavan solmun kaikkien taulukon sisällä olevien naapurien
     * arvot jos naapuri on kuljettava.
     *
     * @param kasiteltava
     * @param naapuri
     */
    public void updateSolmu(Solmu kasiteltava, Solmu naapuri) {
        if (naapuri.getKuljettava() && naapuri.getEtaisyys() > kasiteltava.getEtaisyys() + 1) { //jos paivitettavan etäisyys alkuun on suurempaa kuin kasiteltavan etäisyys niin srvo päivitetään.
            naapuri.setEtaisyys(kasiteltava.getEtaisyys() + 1);
            naapuri.setEdeltaja(kasiteltava);
            DijkstraKeko.lisaaSolmu(naapuri);
            yhteensa++;

        }

    }

    /**
     * Laskee lyhimmän reitin pituuden maalisolmusta lähtösolmuun.
     *
     * @param maali
     * @return
     */

    public int tulostaReitti(Solmu maali) {
        int solmuMaara = 1;

        while (maali.getEdeltaja() != null) {
            maali = maali.getEdeltaja();

            solmuMaara++;
        }
        return solmuMaara;
    }

}
