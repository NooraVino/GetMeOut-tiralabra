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
    public class Esimerkki {
        int[][] labyrinth;
        
    public static void main(String[] args) {
      makeRandomLabyrinth(10,0.8);
    }
    
    public static int[][] makeRandomLabyrinth(int size, double p){
		int[][] labyrinth=new int[size][size];
		for (int i1=0; i1<size; i1++) {
                    System.out.print("\n");
			for (int i2=0; i2<size; i2++) {
				double r = Math.random();
				labyrinth[i1][i2]=r<p?1:0; //Question: If r<p, then [i1][i2] = 1, else: then [i1][i2] = 0
                                System.out.print(labyrinth[i1][i2]);
			}
		}
		return labyrinth;
    }
}
    

