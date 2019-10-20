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
public class Asolmu {
    private int x;
    private int y;
    private int etaisyys;
     
    public Asolmu(int x, int y, int etaisyys) {
        this.x = x;
        this.y = y;
        this.etaisyys = etaisyys;
    }
    
    public Asolmu(int etaisyys) {
        this.x = 0;
        this.y = 0;
        this.etaisyys = etaisyys;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getEtaisyys() {
        return etaisyys;
    }
    
    public int setEtaisyys() {
        return etaisyys;
    }
      
}
