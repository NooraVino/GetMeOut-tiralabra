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

public class Heuristic {
    public static int matka(Solmu s, Solmu maali){
        
        int dumbHeurX=Math.abs(s.getX()-maali.getX());
        int dumbHeurY=Math.abs(s.getY()-maali.getY());
        
        return dumbHeurX+dumbHeurY+1;
    }
} 

