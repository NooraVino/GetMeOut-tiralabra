/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Algoritmit;

import tiralabra.getmeout.Ruudukko;
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.Tietorakenteet.SolmuLista;

/**
 *
 * @author vino
 */
public class Dijkstra {

    Keko DijkstraKeko;
    int vierailuja;
    Ruudukko ruudukko;
    Solmu[][] solmut;
    SolmuLista polku;
    Solmu alku;
    int lyhinPolku;

    public Dijkstra(Ruudukko ruudukko) {
        this.vierailuja = 0;
        this.ruudukko = ruudukko;
        solmut = ruudukko.getSolmut();
        alku = ruudukko.getAlku();
        DijkstraKeko = new Keko();
        this.polku = new SolmuLista();
        this.lyhinPolku = 0;

    }

    /**
     * Poistaa pienimmän Solmun keosta ja jos Solmulla on naapuri niin päivittää
     * kyseisin naapurin arvot. Toistetaan kunnes Keko on tyhjä. Jos maaliSolmu
     * löytyy niin kutsutaan metodia TulostaKeko.
     *
     * @return
     */
    public int laskeReitti() {

        DijkstraKeko.lisaaSolmu(alku);

        while (!DijkstraKeko.isEmpty()) {
            Solmu kasiteltava = DijkstraKeko.poistaMinimi();

            if (kasiteltava.getMaali()) {
                return lyhinReitti(kasiteltava);
            }

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

        }

        return -1;
    }

    /**
     * Paivittaa kasiteltavan solmun kaikkien taulukon sisällä olevien naapurien
     * arvot jos naapuri on kuljettava. Arvo päivitetään vain jos se on suurempi
     * kuin kasiteltavan arvo+1.
     *
     * @param kasiteltava
     * @param naapuri
     */
    public void updateSolmu(Solmu kasiteltava, Solmu naapuri) {
        if (naapuri.getKuljettava() && naapuri.getEtaisyys() > kasiteltava.getEtaisyys() + 1) {
            naapuri.setEtaisyys(kasiteltava.getEtaisyys() + 1);
            naapuri.setEdeltaja(kasiteltava);
            DijkstraKeko.lisaaSolmu(naapuri);

        }

    }

    /**
     * Laskee lyhimmän reitin pituuden maalisolmusta lähtösolmuun.
     *
     * @param maali
     * @return
     */
    private int lyhinReitti(Solmu Solmu) {
        if (Solmu.getEdeltaja() != null) {
            polku.lisaa(Solmu);
            lyhinReitti(Solmu.getEdeltaja());
        }
        return lyhinPolku++;
    }

}
