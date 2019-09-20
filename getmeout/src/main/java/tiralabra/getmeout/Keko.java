/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

/**
 *
 * @author vino
 */
public class Keko {

    private Solmu[] keko;
    private int heapSize;
    private int top;

    public Keko() {
        this.keko = new Solmu[20];
        this.heapSize = 1000;
        this.top = 0;
    }

    public int vanhempi(int i) {
        return (i - 1) / 2;
    }

    public int vasen(int i) {
        return (2 * i);
    }

    public int oikea(int i) {
        return (2 * i + 1);
    }

    public int getSize() {
        return this.keko.length;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void lisaaSolmu(Solmu uusiSolmu) {
        keko[top] = uusiSolmu;
        uusiSolmu.setPaikkaKeossa(top);
        top++;

    }

    public Solmu PoistaMinimi() {
        if (top == 0) {
            return null;
        }
        Solmu minimi = keko[1];
        top--;
        keko[1] = keko[top];

        //heapify(1);
        return minimi;
    }

    public void tulostaKeko() {
        for (int i = 0; i < keko.length; i++) {
            Solmu s = keko[i];
            System.out.println(s.getKuljettava());
            System.out.println(s.getY());
            System.out.println(s.getX());

        }
    }

}