### Testausdokumentti

Projekti on testattu yksikkötesteillä. Käytössä on JUnit-testaus. Testit suuoritetaan NetBeanssissa painamalla projektin nimen kohdalta ja valitsemalla "Test". Testin voi suorittaa myös painamalla Alt F6. Konsolissa testit voi suorittaa komennolla "mvn test".

Testauksen apuna on Jacoco jonka avulla voidaan tarkastella testien rivi- ja haarautumakattavuutta. Jacocon voi suorittaa komentoriviltä komennolla "mvn test jacoco:report". Koodin laatua ja luettavuutta varten mukana on myös Checkstyle (+ jxr). Tarkastuksen voi suorittaa komennolla "mvn jxr:jxr checkstyle:checkstyle". Chechstyle herjaa 5 metodin kohdalla pituuden  ylittymisestä,mutta näitä en ehtinyt muokata.

Suorituskykytestauksella on selvitetty algoritmien ja tietorakenteiden nopeutta. Suorituskykyä on testattu mm Javan omalla Systems.currentTimeMillis() metodilla. Aika suorituksen alussa ja lopussa tallennetaan ja erotuksesta saadaan suorituksen kesto.

Testausta on tehty sekä omille tietorakenteille Keko, Lista ja Solmulista että myös omille Algoritmeille. Yksikkötestausta tehdessä huomasin, että Astar-algoritmi ei toimi ilman maalia. 

Suorituskykytestauksessa huomataan että pienillä syötteillä molemmat algoritmit löytävät samta lyhimmät reitit suurinpiirtein samassa ajassa. Kuitenkin isommilla syötteillä Astarin edut näkyvät ja reitti löytyy nopeammin. 

Alla on muutamia esimerkkejä syötteiden koon ja lyhimmän reitin suhteen. Oman toteutukseni Astar ei kuitenkaan toimi täysin oiken vaan lyhimmän reitin pituus nousee joillain syötteillä. Tästä huolimatta Astar toimii yli 100000 mitaisilla syötteillä nopeasti ja nopeusero on merkittävä. Tämän enempää ei kuitenkaan ollut järkeä tehdä vertailuja kun algoritmi ei toimi kaikilta osin niin kuin pitäisi.


|      | Ruudukon koko | Kuljettavia Solmuja | Lyhin reitti| Kuljettuja Solmuja| Aika/ms
|---|---|----|---|---|---|
|Dijkstra|512x512|262144|1006||95|
|Astar|512x512|235892|850|1006|30|



|      | Ruudukon koko | Kuljettavia Solmuja | Lyhin reitti| Kuljettuja Solmuja| Aika/ms
|---|---|----|---|---|---|
|Dijkstra|512x224|101312|713||69|
|Astar|512x224|101312|727|59223|62|



|      | Ruudukon koko | Kuljettavia Solmuja | Lyhin reitti| Kuljettuja Solmuja| Aika/ms
|---|---|----|---|---|---|
|Dijkstra|5x34|105|38||0|
|Astar|5x34|105|38|89|1|










