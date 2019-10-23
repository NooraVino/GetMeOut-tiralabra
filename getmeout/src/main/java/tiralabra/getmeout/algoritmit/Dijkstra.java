/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.algoritmit;

import tiralabra.getmeout.Ruudukko;
import tiralabra.getmeout.tietorakenteet.Keko;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.tietorakenteet.SolmuLista;

/**
 *
 * @author vino
 */
public class Dijkstra {

    Keko dijkstraKeko;
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
        dijkstraKeko = new Keko();
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
        dijkstraKeko.lisaaSolmu(alku);

        while (!dijkstraKeko.isEmpty()) {
            Solmu kasiteltava = dijkstraKeko.poistaMinimi();

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
                Solmu vasenNaapuri = solmut[kasiteltava.getNaapuriVasen().getY()][kasiteltava.getNaapuriVasen().getX()];
                updateSolmu(kasiteltava, vasenNaapuri);
            }
            if (kasiteltava.getNaapuriOikea().getX() <= ruudukko.getLeveys()) {
                Solmu oikeaNaapuri = solmut[kasiteltava.getNaapuriOikea().getY()][kasiteltava.getNaapuriOikea().getX()];
                updateSolmu(kasiteltava, oikeaNaapuri);
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
            dijkstraKeko.lisaaSolmu(naapuri);

        }

    }

    /**
     * Laskee lyhimmän reitin pituuden maalisolmusta lähtösolmuun.
     *
     * @param solmu
     * @return
     */
    public int lyhinReitti(Solmu solmu) {
        if (solmu.getEdeltaja() != null) {
            polku.lisaa(solmu);
            lyhinReitti(solmu.getEdeltaja());
        }
        return lyhinPolku++;
    }

}
