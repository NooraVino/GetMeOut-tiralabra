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
    
    public Solmu(int x, int y) {
        this.x = x;
        this.y = y; 
        this.kuljettava = false;
        this.distance = 0; /*pitäisi kai olla ääretön*/
        this.edeltaja = null;
    }
    public int getX(){
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public boolean getKuljettava() {
        return this.kuljettava;
    }
    public void setKuljettava() {
        this.kuljettava = true;
    }
    
    /**
    * asetetaan solmun etäisyysarvio lähtösolmusta.
    */
    public void setEtaisyys(int d) { 
        this.distance = d;
    }
    
    public int getEtaisyys(){
        return this.distance;
    } 
    /**
     * asetetaan edeltävä solmu toistaiseksi lyhyimmällä polulla.
     * @param edeltaja Edeltävä solmu.
     */
    public void setPolku(Solmu edeltaja) { 
       this.edeltaja = edeltaja;  
    }
    
    public Solmu getPolku() {
        return this.edeltaja;
    }
    
    
}