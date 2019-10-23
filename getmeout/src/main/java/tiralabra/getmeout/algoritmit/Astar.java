/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.algoritmit;

import tiralabra.getmeout.Heuristic;
import tiralabra.getmeout.Ruudukko;
import tiralabra.getmeout.Solmu;
import tiralabra.getmeout.tietorakenteet.Keko;
import tiralabra.getmeout.tietorakenteet.SolmuLista;

/**
 *
 * @author vino
 */
public class Astar {

    private int maara;
    private int lyhinPolku;
    Ruudukko ruudukko;
    Keko avoin;
    Solmu alku;
    Solmu maali;
    SolmuLista suljettu;
    SolmuLista polku;
    Solmu[][] solmut;

    public Astar(Ruudukko ruudukko) {
        this.maara = 0;
        this.ruudukko = ruudukko;
        this.avoin = new Keko();
        this.suljettu = new SolmuLista();
        this.polku = new SolmuLista();
        this.solmut = ruudukko.getSolmut();
        this.lyhinPolku = 0;

    }

    public int laskeReitti() {
        avoin.lisaaSolmu(ruudukko.getAlku());
        while (!avoin.isEmpty()) {
            Solmu kasiteltava = avoin.poistaMinimi();

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

    public void updateSolmu(Solmu kasiteltava, Solmu naapuri) {

        if (naapuri.getMatkaAlkuun() == Integer.MAX_VALUE && naapuri.getKuljettava()) {
            int matkaAlkuun = kasiteltava.getMatkaAlkuun() + 1;
            maara++;
            naapuri.setEdeltaja(kasiteltava);
            naapuri.setMatkaAlkuun(matkaAlkuun);
            naapuri.setEtaisyys(naapuri.getMatkaAlkuun() + Heuristic.matka(naapuri, ruudukko.getMaali()));

            avoin.lisaaSolmu(naapuri);

        }
    }

    public int lyhinReitti(Solmu n) {
        if (n.getEdeltaja() != null) {
            polku.lisaa(n);
            lyhinReitti(n.getEdeltaja());
        }
        return lyhinPolku++;
    }

    public int getMaara() {
        return maara;
    }
}
