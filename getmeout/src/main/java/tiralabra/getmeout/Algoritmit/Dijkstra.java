/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Algoritmit;

import java.io.File;
import java.util.Scanner;
import tiralabra.getmeout.Ruudukko;
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.Tietorakenteet.Lista;

/**
 *
 * @author vino
 */
public class Dijkstra {
    Keko DijkstraKeko;
    public int vierailuja;
    Ruudukko ruudukko;
    Solmu [][] solmut;
    Solmu alku;
  

    public Dijkstra(File tiedosto) {
        this.vierailuja = 0;
        ruudukko = new Ruudukko();
        ruudukko.alustaTiedostosta(tiedosto);
        solmut = ruudukko.getSolmut();
        alku = ruudukko.getAlku();
        DijkstraKeko = new Keko();
        
    }

    
        

    /**
     * Poistaa pienimmän Solmun keosta ja jos Solmulla on naapuri niin päivittää
     * kyseisin naapurin arvot. Toistetaan kunnes Keko on tyhjä. Jos maaliSolmu
     * löytyy niin kutsutaan metodia TulostaKeko.
     */
    public int laskeReitti() {
   
    DijkstraKeko.lisaaSolmu(alku);
        int maara = 0;

        while (!DijkstraKeko.isEmpty()) {
            Solmu kasiteltava = DijkstraKeko.PoistaMinimi();

            if (kasiteltava.getNaapuriYla().getY() >= 0) {
                Solmu ylaNaapuri = solmut[kasiteltava.getNaapuriYla().getY()][kasiteltava.getNaapuriYla().getX()];
                updateSolmu(kasiteltava, ylaNaapuri);
            }

            if (kasiteltava.getNaapuriAla().getY() <= ruudukko.getKorkeus()) {
                Solmu alaNaapuri = solmut[kasiteltava.getNaapuriAla().getY()][kasiteltava.getNaapuriAla().getX()];
                updateSolmu(kasiteltava, alaNaapuri);
            }

            if (kasiteltava.getNaapuriVasen().getX() >= 0) {
                Solmu VasenNaapuri = solmut[kasiteltava.getNaapuriVasen().getY()][kasiteltava.getNaapuriVasen().getX()];
                updateSolmu(kasiteltava, VasenNaapuri);
            }
            if (kasiteltava.getNaapuriOikea().getX() <= ruudukko.getLeveys()) {
                Solmu OikeaNaapuri = solmut[kasiteltava.getNaapuriOikea().getY()][kasiteltava.getNaapuriOikea().getX()];
                updateSolmu(kasiteltava, OikeaNaapuri);
            }

            if (kasiteltava.getMaali()) {

                maara = tulostaReitti(kasiteltava);
            }

        }

        System.out.println("kuljettavia solmuja yhteenä: " + ruudukko.getYhteensa());
        System.out.println("kaikenkaikkiaan solmuja: " + (ruudukko.getKorkeus()+1 ) * (ruudukko.getLeveys()+1 ));

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
            ruudukko.kasvata();

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
