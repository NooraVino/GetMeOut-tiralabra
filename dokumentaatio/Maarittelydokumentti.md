### 1. Määrittelydokumentti

Harjoitustyönä vertailen miten Dikstra ja A* eroavat toisistaan kun algoritmin on tarkoitus löytää
lyhin reitti kartalla kahden pisteen välillä. Työssä tarkastelen mm sitä miten kartan koko vaikuttaa tulokseen
tai onko esimerkiksi lähtö ja maalipisteiden etäisyydellä tai esteillä merkitystä.

Ohjelma saa syötteenä kartan 2-ulotteisena taulukkona, jossa 1 merkitsee seinätöntä kohtaa ja 0
seinää. Kartta ajatellaan verkkona ja ruudut ovat verkon solmuja. Yhdellä solmulla voi olla
neljä vierussolmua.

Dijkstra löytää lyhimmät polut annetusta lähtösolmusta kaikkiin verkon solmuihin. Dijkstra käyttää
aputietorakenteena minimikekoa. Mukaan tarvitaan aputaulukot (etäisyys ja polku), sekä
aliohjelmat kaarten löysäämiseksi (päivitys ja alustus).

A* tarvitsee minimikeon lisäksi avukseen heuristiikkafunktion joka tässä tapauksessa voi olla ns
Manhattanetäisyys sillä liike tapahtuu vain neljään (ei kahdeksaan suuntaan). A* voi
heuristiikkafunktion avulla löytää lyhimmän reitin nopeammin kuin Dijkstra mutta huomioitavaa on
että algoritmi löytää varmasti lyhimmän polun vain jos loppuosan etäisyysarvio ei ole millekään
solmulle suurempi kuin solmun todellinen etäisyys maalisolmusta ja heuristiikkafunktio
on monotoninen.

Sekä Dijkstran että A*:n toivottu aikavaativuus O((|E|+|V|) log|V|) tilavaativuus O(|V|).

##### Lähteet:
Tietorakenteet ja Algoritmit luentomoniste 2017 (Jyrki Kivinen)

A*-reitinhaku -Tietorakenteiden harjoitustyö (www.harbu.org/uploads/tiralabra/)

Tietorakenteiden harjoitustyö, tapio2075. Vuosi 2012 (www.github.com/tapio2705/tira/blob/master/Projekti/src/Main.java)

Kartat (www.movingai.com/benchmarks/grids.html)
