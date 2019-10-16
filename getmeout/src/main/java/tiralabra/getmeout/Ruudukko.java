/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.getmeout;

import java.io.File;
import java.util.Scanner;
import tiralabra.getmeout.Tietorakenteet.Lista;

/**
 *
 * @author vino
 */
public class Ruudukko {

    Lista rivit;
    Solmu[][] solmut;
    public int korkeus;
    public int leveys;
    public int yhteensa;
    Solmu alku;

    public Ruudukko() {
        this.korkeus = 0;
        this.leveys = 0;
        this.yhteensa = 0;
        this.solmut = new Solmu[600][600];
        rivit = new Lista();

    }
    
    /**
     * Lukee parametrina saadun tiedoston rivi kerrallaan ja luo jokaista taulukossa olevaa merkkiä kohden Solmun.
     * Alustaa jokaiselle solmulle x ja y -koordinaatit sekä määrittelee onko solmu kujettava. Asettaa solmuille naapurit
     * sekä merkitsee maali ja lähtösolmun.
     * @param tiedosto 
     */
    

    public void alustaTiedostosta(File tiedosto) {

        try (Scanner lukija = new Scanner(tiedosto)) {
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

                if (arvo == '.') {
                    solmu.setKuljettava();
                }          
                if (arvo == 'u') {
                    yhteensa++;
                    solmu.setEtaisyys(0);
                    setAlku(solmu);
                }

                if (arvo == 'x') {
                    yhteensa++;
                    solmu.setKuljettava();
                    solmu.setMaali();
                }

                this.korkeus = y;
                this.leveys = x;
                solmut[y][x] = solmu;

            }

        }

    }

    public Solmu[][] getSolmut() {
        return this.solmut;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getYhteensa() {
        return this.yhteensa;
    }

    public void kasvata() {
        this.yhteensa++;
    }

    public void setAlku(Solmu s) {
        alku = s;
    }

    public Solmu getAlku() {
        return alku;
    }
}
