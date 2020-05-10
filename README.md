# Hinder
Hinder on peli, joka simuloi satiirinomaisesti erilaisia nettideittauspalveluita ja applikaatioita. Pelissä on erilaisia hahmoja, jotka vastailevat käyttäjän valitsemiin vaihtoehtoihin eri tavoin.

Pelin tarkoituksena on, että pelaaja löytäisi itselleen treffiseuraa ja saisi elämänkumppanin. Peli päättyy joko siihen, että pelaaja päätyy parisuhteeseen (joka voi päättyä onnellisesti tai huonosti), mikä lasketaan voitoksi, tai sitten ei löydä ketään, eli häviää pelin.

### Pelin sisällöstä
**HUOM** Kaikki pelin hahmon ovat kuvitteellisia. Hahmoja esittävät kuvat ovat löydetty Googlesta tai erilaisilta sivuilta, jotka tarjoavat ilmaisia stock -kuvia. Näiden lisäksi kuvat, joissa esiintyy ihmisiä, on sumennettu Polygonize-algoritmilla satunnaisesti, jotta niissä olevia henkilöitä ei voida tunnistaa.

Muistakaa, että pelissä karikatyylisesti tuodaan esille erilaisia deittipalveluissa esiintyviä stereotypioita ja että sen tarkoituksena ei ole loukata ketään.

*Sisältää voimakasta kielenkäyttöä ja seksuaalissävytteisiä teemoja.*

### Pelin sisällön laajentaminen (modding)
Hinder sisältää mahdollisuuden niille, joille ohjelmointikieli, millä peli on kehitetty (Java) ei ole tuttu  lisätä siihen uusia keskustelukumppaneita ja myöhemmin mahdollisesti muutakin sisältöä.

Tarkemmat ohjeet siihen miten peliin voi lisätä uutta sisältöä löytyy dokumentaatiosta: [modding](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/MODDING.md).

## Linkkejä projektin dokumentaatioon
Tässä erilaisia linkkejä projektiin liittyvään dokumentaatioon:
* [määrittelydokumentti](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/DESIGN.md). Sisältää alustavan design -dokumentaation (määrittelydokumentin).
* [aikakirjanpito](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/TIME.md). Sisältää työaikakirjanpidon projektiin liittyen.
* [changelog](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/CHANGELOG.md). Sisältää laajemmat kuvaukset liittyen pelin eri kehitysversioihin.
* [todo](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/TODO.md). Sisältää listauksen puuttuvista toiminnallisuuksista.
* [modding](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/MODDING.md). Ohjeet uuden sisällön lisäämiseen peliin.
* [sovellusarkkitehtuuri](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/ARCHITECTURE.md). Sovellusarkkitehtuurista diagrammeja ja lisätietoa.
* [käyttöohje](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/QUICKSTART.md). Yksinkertainen käyttöohje ohjelman käytön aloittamiseen.
* [testaus](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/TESTING.md). Testaukseen liittyvä dokumentaatio.

## Kuvankaappauksia
Muutama kuvankaappaus versiosta 0.1: [screenshot 1](https://github.com/Schamppu/ot-harjoitustyo/blob/master/screenshots/shot1.png), [screenshot 2](https://github.com/Schamppu/ot-harjoitustyo/blob/master/screenshots/shot2.png), [screenshot 3](https://github.com/Schamppu/ot-harjoitustyo/blob/master/screenshots/shot3.png), [screenshot 4](https://github.com/Schamppu/ot-harjoitustyo/blob/master/screenshots/shot4.png).

# Release
* [Loppupalautus-release](https://github.com/Schamppu/ot-harjoitustyo/releases/tag/loppu). Loppupalautuksen release.
* [v. 0.21](https://github.com/Schamppu/ot-harjoitustyo/releases/tag/viikko5). Alustavasti suunnitellut toiminnallisuudet sisältävä versio.

## Ohjeita projektin käynnistämiseen ja komentorivikomentoja

### Käynnistys
Voit käynnistää projektin joko lataamalla sen githubista ja suorittamalla NetBeansilla tai komentorivikomennolla
```
mvn compile exec:java -Dexec.mainClass=hinder.HinderUi
```

### Testaus
Testit on mahdollista suorittaa komentorivikomennolla
```
mvn test
```
Ja testikattavuusraportin saa komentorivikomennolla
```
mvn jacoco:report
```

### Checkstyle
Checkstyle raportti on mahdollista generoida seuraavalla komennolla:
```
mvn jxr:jxr checkstyle:checkstyle
```
