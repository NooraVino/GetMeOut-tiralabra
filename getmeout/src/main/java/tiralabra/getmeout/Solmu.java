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
public class Solmu {

    private int x;
    private int y;
    private boolean kuljettava;
    private int distance;
    private Solmu edeltaja;
    private Solmu naapuriYla;
    private Solmu naapuriAla;
    private Solmu naapuriVasen;
    private Solmu naapuriOikea;
    private int paikka;
   

    public Solmu(int x, int y) {
        this.x = x;
        this.y = y;
        this.kuljettava = false;
        this.edeltaja = null;
        this.paikka = 0;
      
    }

    public void setNaapurit(int x, int y) {
       
            this.naapuriYla = new Solmu(x, y - 1);
            this.naapuriAla = new Solmu(x, y + 1);
            this.naapuriVasen = new Solmu((x - 1), y);
            this.naapuriOikea = new Solmu((x + 1), y);
        

    }

    public Solmu getNaapuriYla() {
        if (this.naapuriYla.getY() < 0) {
            return null;
        }
        else {
            return this.naapuriYla;
        }
    }
    


    public Solmu getNaapuriVasen() {
        return this.naapuriVasen;
    }

    public Solmu getNaapuriOikea() {
        return this.naapuriOikea;
    }

    public Solmu getNaapuriAla() {
        return this.naapuriAla;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Vaihtaa this.kuljettavan arvoksi true jos kyseessä on esteetön eli
     * kuljettava kohta.
     */
    public void setKuljettava() {
        this.kuljettava = true;
    }

    public boolean getKuljettava() {
        return this.kuljettava;
    }

    /**
     * asetetaan solmun etäisyysarvio lähtösolmusta.
     */
   
    
    public void setEtaisyys(int i) {
      this.distance = i;
    }

    public int getEtaisyys() {
        return this.distance;
    }

    /**
     * asetetaan edeltävä solmu toistaiseksi lyhyimmällä polulla.
     *
     * @param edeltaja Edeltävä solmu.
     */
    public void setEdeltaja(Solmu edeltaja) {
        this.edeltaja = edeltaja;
    }

    public Solmu getEdeltaja() {
        return this.edeltaja;
    }

    public int getPaikkaKeossa() {
        return paikka;
    }

    public void setPaikkaKeossa(int paikka) {
        this.paikka = paikka;
    }

}
