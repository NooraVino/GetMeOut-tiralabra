Toteutusdokumentti

Molemmat algoritmit hyödyntävät saamaa metodia “alustaTiedostosta()” joka saa parametrinaan (tekstitiedoston). Tekstitiedosto tulkitaan kaksiulotteisena taulukkona. Jokainen tiedoston rivi luetaan yksi kerrallaan ja tallennetaan omaa listatoteutusta apuna käyttäen. Tiedoston jokainen merkki tallennetaan omaksi solmukseen ja solmujen kuljettavuus sekä etäisyysarviot alustetaan. Myös lähtösolmu ja maalisolmu erotellaan.Kun kaikki solmut on alustettu molemmat algoritmit toteuttavat omat laskeReitti-metodin.  

Dijkstran algoritmi käyttää apunaan minimikekoa josta pystytään tehokkaasti löytämään seuraavaksi lähin solmu. Aluksi kekoon lisätään vain aloitussolmu. Sen jälkeen keosta poistetaan aina pienin solmu minimikeon PoistaMinimi-metodia hyödyntäen. Pienin solmu on se jonka etäisyys alkuun on pienin. Kekon poistaMinimi toteus hyödyntää hepify-metodia jotta keko pysyy järjestyksessä. Pienimmän solmun poistamisen jälkeen algoritmi käy läpi kaikki poistetun solmun neljä (4) naapurisolmua (jos nämä naapurit ovat taulukon sisällä). Solmujen arvot päivitetään  (updateSolmu -metodilla) jos niiden etäisyys on suurempaa kuin poistetun solmun etäisyys +1. Myös edeltäjäsolmu päivitetään ja lopuksi solmu lisätään kekoon. Dijkstran laskeReitti algoritmi käy läpi kaikki taulukon kuljettavat solmut ja kun keko on tyhjä eikä päivitettäviä solmuja ole niin kutsutaan metodia LaskeReitti().

Astar algoritmi toimii hyvin saman tapaisesti. Siinäkin aluksi kekoon lisätään vain aloitussolmu ja keosta poistetaan aina pienin kunnes keko on tyhjä. Astar eroaa kuitenkin siinä, että siinä kaikkia solmuja ei käydä läpi vaan heuristiikkafunktion avulla lasketaan etäisyysarviota jonka avulla yritetään koko ajan kohti maalisolmua ja sillä tavoin pyrkiä siihen, ettei kaikkia solmuja tarvitsisi käydä läpi. Siinä tapauksessa että reitillä ei ole kohtuuttomasti esteitä niin Astarin pitäisi löytää reitti isoilla taulukoilla selvästi noepammin kuin Dijkstra.



Molemmat Algoritmit kutsuvat lopuksi metodia laskeReitti jonka avulla saadaan tulostettua hyvin reitti parametrina annetusta maalisolmusta lähtösolmuun hyödyntäen omaa listaToteutusta sekä Solmun edeltäjätietoa. 

Main metodi tulostaa näytölle koko ruudukon koon sekä kuljettavien solmujen määrän. Tämän lisäksi saadaan tieto molempien algorimien laskemasta lyhimmästä polusta sekä Astarin kohdalla myös tieto siitä, kuinka monta solmua käsiteltiin.
Javan omalla CurrentTimeMillis()-metodilla saadaan laskettua molempien algoritmien suoritusaika.

