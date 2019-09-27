/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Tietorakenteet;

import tiralabra.getmeout.Solmu;

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
        
        Solmu vertailtavalapsi = keko[top];
        Solmu vertailtavaParent = keko[top/2];
        
        uusiSolmu.setPaikkaKeossa(top);
        
         while ((vertailtavalapsi.getEtaisyys()) < (vertailtavaParent.getEtaisyys()) && (vertailtavaParent.getPaikkaKeossa()) > 1) {
                    swap(vertailtavalapsi.getPaikkaKeossa(), vertailtavaParent.getPaikkaKeossa());
                    int uusiVanhempi = ((vertailtavalapsi.getPaikkaKeossa()) / 2);
                    vertailtavaParent = keko[uusiVanhempi];
                }
               
                this.top++;

    }
    
    public void swap(int solmu, int lapsi) {
        Solmu valiaikainenLapsi = keko[lapsi];
        Solmu valiaikainenSolmu = keko[solmu];

        valiaikainenLapsi.setPaikkaKeossa(solmu); 
        valiaikainenSolmu.setPaikkaKeossa(lapsi);

        keko[lapsi] = valiaikainenSolmu;
        keko[solmu] = valiaikainenLapsi;

    }

    public Solmu PoistaMinimi() {
        if (top == 0) {
            return null;
        }
        Solmu minimi = keko[1];
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
                
                if (vasemmankoko<oikeankoko) {
                    swap(indeksi, (indeksi*2));
                    heapify((indeksi*2));
                }          
                
                else {
                swap(indeksi, (indeksi*2+1));
                heapify(indeksi*2+1);
                }
               
            }

        } else if ((indeksi * 2) < top) {
            int vasemmankoko = (keko[(indeksi * 2)]).getEtaisyys();
            int tarkistettavasolmu = (keko[indeksi]).getEtaisyys();
            if (tarkistettavasolmu > vasemmankoko) {
                
                swap(indeksi, (indeksi*2));
           }

        }

    }

    public void tulostaKeko() {
        for (int i = 0; i < keko.length; i++) {
            Solmu s = keko[i];
            System.out.println(s.getPaikkaKeossa());
            //System.out.println(s.getY());
            //System.out.println(s.getX());

        }
    }

}
