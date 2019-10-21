/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.tietorakenteet;

import tiralabra.getmeout.Solmu;

/**
 *
 * @author vino
 */
public class SolmuLista {

    private Solmu[] lista;
    private int indexi;
    private int koko;

    public SolmuLista() {
        lista = new Solmu[10];
        indexi = 0;
        koko = 0;
    }

    /**
     * lisää Solmun listaan. Jos listassa ei ole tilaa, pidentää listaa 10
     * paikalla
     *
     * @param solmu
     */
    public void lisaa(Solmu solmu) {
        if (indexi < lista.length) {
            koko++;
            lista[indexi] = solmu;
            indexi++;
        } else {
            kasvataListaa(lista);
            lisaa(solmu);
        }
    }

    private void kasvataListaa(Solmu[] lista) {
        Solmu[] apulista = new Solmu[lista.length + 10];
        for (int i = 0; i < this.lista.length; i++) {
            apulista[i] = this.lista[i];
        }
        this.lista = apulista;
    }

    /**
     * tarkistaa löytyykö Solmu s listasta
     *
     * @param solmu
     * @return
     */
    public boolean contains(Solmu solmu) {
        if (koko != 0) {
            for (int i = (lista.length - 1); i >= 0; i--) {
                if (solmu.equals(lista[i])) {
                    return true;
                }
            }
        }
        return false;
    }

}
