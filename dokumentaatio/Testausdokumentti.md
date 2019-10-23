Testausdokumentti

Projekti on testattu yksikkötesteillä. Käytössä on JUnit-testaus. Testit suuoritetaan NetBeanssissa painamalla projektin nimen kohdalta ja valitsemalla "Test". Testin voi suorittaa myös painamalla Alt F6. Konsolissa testit voi suorittaa komennolla "mvn test".

Testauksen apuna on Jacoco jonka avulla voidaan tarkastella testien rivi- ja haarautumakattavuutta. Jacocon voi suorittaa komentoriviltä komennolla "mvn test jacoco:report". Koodin laatua ja luettavuutta varten mukana on myös Checkstyle (+ jxr). Tarkastuksen voi suorittaa komennolla "mvn jxr:jxr checkstyle:checkstyle".

Suorituskykytestauksella on selvitetty algoritmien ja tietorakenteiden nopeutta. Suorituskykyä on testattu mm Javan omalla Systems.currentTimeMillis() metodilla. Aika suorituksen alussa ja lopussa tallennetaan ja erotuksesta saadaan suorituksen kesto.

Testausta on tehty sekä omille tietorakenteille Keko, Lista ja Solmulista että myös omille Algoritmeille. Yksikkötestausta tehdessä huomasin, että Astar-algoritmi ei toimi ilman maalia. 

Suorituskykytestauksessa huomataan että pienillä syötteillä molemmat algoritmit löytävät samta lyhimmät reitit suurinpiirtein samassa ajassa. Kuitenkin isommilla syötteillä Astarin edut näkyvät ja reitti löytyy paljon nopeammin. 


