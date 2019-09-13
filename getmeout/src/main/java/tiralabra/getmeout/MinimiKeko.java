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
public class MinimiKeko {

    private Solmu[] keko;
    private int heapSize;

    public MinimiKeko() {
        this.keko = new Solmu[0];
        this.heapSize = 0;
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

}
