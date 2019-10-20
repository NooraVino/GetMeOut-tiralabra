/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Tietorakenteet;

import tiralabra.getmeout.Asolmu;



/**
 *
 * @author vino
 */
public class AKeko {
    private Asolmu[] keko;
    private int heapSize;
    private int top;

    public AKeko() {
        this.keko = new Asolmu[10];
        this.heapSize = 10;
        this.top = 1;
    }

    public int getHeapSize() {
        return this.top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Asolmu getSolmu(Asolmu n) {
        for (int i = 0; i < this.top; i++) {
            if (keko[i] == n) {
                return n;
            }

        }
        return null;
    }

    public int getPaikka(Asolmu n) {
        for (int i = 1; i < this.top; i++) {
            if (keko[i].equals(n)) {
                return i;
            }

        }
        return 0;

    }

    public boolean contains(Asolmu n) {
        for (int i = 0; i < this.top; i++) {
            if (keko[i] == n) {
                return true;
            }
        }
        return false;

    }

    /**
     * Kasvattaa keon koon kaksinkertaiseksi ja kopioi uuteen kekoon mukaan
     * vanhan solmut.
     *
     */
    public void kasvataKeonKokoa() {
        Asolmu[] newKeko = new Asolmu[keko.length * 2];
        for (int i = 0; i < keko.length; i++) {
            newKeko[i] = keko[i];
        }
        keko = newKeko;
        heapSize *= 2;

    }

    /**
     * Lisää uuden solmun kekoon ja tuplaa Keon koon aina tarvittaessa.
     *
     * @param uusiSolmu
     */
    public void lisaaSolmu(Asolmu uusiSolmu) {

        if (heapSize <= top) {
            kasvataKeonKokoa();
        }
        int i = top;
        
        while (i > 1 && this.keko[i / 2].getEtaisyys() > uusiSolmu.getEtaisyys()) {
           
            keko[i] = keko[i / 2];
           
            i = i / 2;
        }
        top++;
        keko[i] = uusiSolmu;
     
     

    }

    public void swap(int solmu, int lapsi) {
        Asolmu valiaikainenLapsi = keko[lapsi];
        Asolmu valiaikainenSolmu = keko[solmu];

        keko[lapsi] = valiaikainenSolmu;
        keko[solmu] = valiaikainenLapsi;

    }

    public Asolmu PoistaMinimi() {
        if (top == 0) {
            return null;
        }

        Asolmu minimi = keko[1];
        //System.out.println(minimi.getEtaisyys());

        top--;
        keko[1] = keko[top];

        heapify(1);

        return minimi;
    }

    public void heapify(int indeksi) {

        if ((indeksi * 2 + 1) < top) {

            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int oikeankoko = (keko[(indeksi * 2 + 1)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();

            if (tarkistettavasolmu > (Math.min(vasemmankoko, oikeankoko))) {

                if (vasemmankoko < oikeankoko) {
                    swap(indeksi, (indeksi * 2));
                    heapify((indeksi * 2));

                } else {
                    swap(indeksi, (indeksi * 2 + 1));
                    heapify(indeksi * 2 + 1);
                }

            }

        } else if ((indeksi * 2) < top) {
            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();
            if (tarkistettavasolmu > vasemmankoko) {

                swap(indeksi, (indeksi * 2));
            }

        }

    }

    public void tulostaKeko() {
        for (int i = 0; i < getHeapSize(); i++) {
            Asolmu s = keko[i];
            System.out.print("etaisyys: " + s.getEtaisyys());
            System.out.println("PaikkaKeossa: " +getPaikka(s));
            System.out.println("");
            //System.out.print(s.getY());
            //System.out.println(s.getX());

        }
    }
}

    

