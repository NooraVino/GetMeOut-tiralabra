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
public class Lista {
    private String[] lista;
    private int indeksi;
    private int size;
    
    public Lista() {
        lista = new String[10];
        indeksi = 0;
        size = 0;
    }
    
    public void add (String s) {
        if (indeksi < lista.length) {
            size++;
            lista[indeksi]=s;
            indeksi++;
        }
        else {
            kasvataListaa(lista);
            add(s);
        }
    }
    
    private void kasvataListaa(String[] lista){
        String[] apulista=new String[lista.length+10];
            for(int i=0;i<this.lista.length;i++){
                apulista[i]=this.lista[i];
            }
            this.lista=apulista;
    }
    
    public String get(int i){
        return lista[i];
    }
     public int size(){
        return size;
    }
 
}
