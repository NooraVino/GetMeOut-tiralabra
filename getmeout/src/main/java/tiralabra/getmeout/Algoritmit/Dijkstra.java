/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout.Algoritmit;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import tiralabra.getmeout.Tietorakenteet.Keko;
import tiralabra.getmeout.Solmu;

/**
 *
 * @author vino
 */
public class Dijkstra {

    public Solmu maali;
    Keko DijkstraKeko;
    Solmu[][] solmut;
    public int korkeus;
    public int leveys;
    public Solmu[] apu;
    public int i;

    public void Dijkstra() {
        this.korkeus = 0;
        this.leveys = 0;
        this.i = 0;

    }

    public Keko alustatiedostosta() {
        this.solmut = new Solmu[25][25];
        
        DijkstraKeko = new Keko();
        ArrayList<String> rivit = new ArrayList<>();

        try (Scanner lukija = new Scanner(new File("labyrinth.txt"))) {
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());

        }

        for (int y = 0; y < rivit.size(); y++) {
            String rivi = rivit.get(y);

            for (int x = 0; x < rivi.length(); x++) {
                char arvo = rivi.charAt(x);
                Solmu solmu = new Solmu(x, y);

                solmu.setNaapurit(x, y);
                solmu.setEtaisyys(Integer.MAX_VALUE);

                if (arvo == '1') {
                    solmu.setKuljettava();
                }
                /**
                 * Aloitussolmun lisääminen kekoon
                 */
                if (arvo == '2') {
                    solmu.setEtaisyys(0);
                    DijkstraKeko.lisaaSolmu(solmu);
                }

                if (arvo == '3') {
                    solmu.setKuljettava();
                    solmu.setMaali();
                }

                this.korkeus = y;
                this.leveys = x;
                solmut[y][x] = solmu;

            }

        }

        return DijkstraKeko;

    }

    public void laskeReitti() {
        //Solmu maali = new Solmu(3, 3);
        this.apu = new Solmu [35];

        while (!DijkstraKeko.IsEmpty()) {
            //System.out.println(DijkstraKeko.getHeapSize());
            Solmu kasiteltava = DijkstraKeko.PoistaMinimi();
            //System.out.println("käsiteltävä: " + kasiteltava.getY() + "," + kasiteltava.getX());
            if (kasiteltava.getEdeltaja() != null) {
            //System.out.println("edeltaja: " + kasiteltava.getEdeltaja().getY()+ ","+ kasiteltava.getEdeltaja().getX());
            }
            if (kasiteltava.getNaapuriYla().getY() >= 0) {
                Solmu ylaNaapuri = solmut[kasiteltava.getNaapuriYla().getY()][kasiteltava.getNaapuriYla().getX()];
               // System.out.println("ylaNaapuri: " + ylaNaapuri.getKuljettava() + ylaNaapuri.getY() + ylaNaapuri.getX());
                updateSolmu(kasiteltava, ylaNaapuri);
            }

            if (kasiteltava.getNaapuriAla().getY() <= this.korkeus) {
                Solmu alaNaapuri = solmut[kasiteltava.getNaapuriAla().getY()][kasiteltava.getNaapuriAla().getX()];
                //System.out.println("alaNaapuri: " + alaNaapuri.getKuljettava() + alaNaapuri.getY() + alaNaapuri.getX());
                updateSolmu(kasiteltava, alaNaapuri);
            }

            if (kasiteltava.getNaapuriVasen().getX() >= 0) {
                Solmu VasenNaapuri = solmut[kasiteltava.getNaapuriVasen().getY()][kasiteltava.getNaapuriVasen().getX()];
                //System.out.println("VasenNaapuri: " + VasenNaapuri.getKuljettava() + VasenNaapuri.getY() + VasenNaapuri.getX());
                updateSolmu(kasiteltava, VasenNaapuri);
            }
            if (kasiteltava.getNaapuriOikea().getX() <= this.leveys) {
                Solmu OikeaNaapuri = solmut[kasiteltava.getNaapuriOikea().getY()][kasiteltava.getNaapuriOikea().getX()];
                //System.out.println("OikeaNaapuri: " + OikeaNaapuri.getKuljettava() + OikeaNaapuri.getY() + OikeaNaapuri.getX());
                updateSolmu(kasiteltava, OikeaNaapuri);
            }
            
            if (kasiteltava.getMaali()) {
                
                tulostaReitti(kasiteltava);
                return;

            }

        } 
    }

    public void updateSolmu(Solmu kasiteltava, Solmu naapuri) {
      
        if (naapuri.getKuljettava()&& contains(naapuri)== false) {
         
            if (naapuri.getEtaisyys() > kasiteltava.getEtaisyys()+1) { //jos paivitettavan etäisyys alkuun on suurempaa kuin kasiteltavan etäisyys niin srvo päivitetään.
            naapuri.setEtaisyys(kasiteltava.getEtaisyys() + 1);
            naapuri.setEdeltaja(kasiteltava);
            }
            
            //naapuri.setEdeltaja(kasiteltava);
            if (!DijkstraKeko.contains(naapuri)) {
               
                DijkstraKeko.lisaaSolmu(naapuri);
            }
            apu[i]=naapuri;
            i++;
        }

    }
    
    public boolean contains(Solmu n){
        for(int i=0;i<apu.length-1;i++){
            if(apu[i]== n){
                return true;
            }
        }
        return false;
        
    }

    public void tulostaReitti(Solmu maali) {
        this.maali = maali;
        System.out.println(this.maali.getY()+ ","+ this.maali.getX());
       while (this.maali.getEdeltaja() != null) {
           System.out.println(this.maali.getEdeltaja().getY()+ ","+ this.maali.getEdeltaja().getX());
           this.maali = this.maali.getEdeltaja();
       }
        
      

       }

    

}
