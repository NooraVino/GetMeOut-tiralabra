### 1. Määrittelydokumentti

Harjoitustyönä vertailen miten Dikstra ja A* eroavat toisistaan kun algoritmin on tarkoitus löytää
lyhin reitti labyrintista ulos. Työssä tarkastelen mm sitä miten labyrintin koko vaikuttaa tulokseen
tai onko esimerkiksi lähtö ja maalipisteiden etäisyydellä tai esteillä labyrintissa merkitystä.

Ohjelma saa syötteenä labyrintin 2-ulotteisena taulukkona, jossa 1 merkitsee seinätöntä kohtaa ja 0
seinää. Labyrintti ajatellaan verkkona ja ruudut ovat verkon solmuja. Yhdellä solmulla voi olla
neljä vierussolmua, labyrintissa ei siis voi liikkua viistosti.

Dijkstra löytää lyhimmät polut annetusta lähtösolmusta kaikkiin verkon solmuihin. Dijkstra käyttää
aputietorakenteena minimikekoa. Mukaan tarvitaan aputaulukot (etäisyys ja polku), sekä
aliohjelmat kaarten löysäämiseksi (päivitys ja alustus).

A* tarvitsee minimikeon lisäksi avukseen heuristiikkafunktion joka tässä tapauksessa voi olla ns
Manhattanetäisyys sillä liike labyrintissa tapahtuu vain neljään (ei kahdeksaan suuntaan). A* voi
heuristiikkafunktion avulla löytää lyhimmän reitin nopeammin kuin Dijkstra mutta huomioitavaa on
että algoritmi löytää varmasti lyhimmän polun jvain os loppuosan etäisyysarvio ei ole millekään
solmulle suurempi kuin solmun todellinen etäisyys maalisolmusta ja heuristiikkafunktio
on monotoninen.

Sekä Dijkstran että A*:n toivottu aikavaativuus O((|E|+|V|) log|V|) tilavaativuus O(|V|).

##### Lähteet:
Tietorakenteet ja Algoritmit luentomoniste 2017 (Jyrki Kivinen)
A*-reitinhaku -Tietorakenteiden harjoitustyö (www.harbu.org/uploads/tiralabra/)
