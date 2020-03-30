# Hinder
Hinder on peli, joka simuloi satiirinomaisesti erilaisia nettideittauspalveluita ja applikaatioita. Pelissä on erilaisia hahmoja, jotka vastailevat käyttäjän valitsemiin vaihtoehtoihin eri tavoin.

Pelin tarkoituksena on, että pelaaja löytäisi itselleen treffiseuraa ja saisi elämänkumppanin. Peli päättyy joko siihen, että pelaaja päätyy parisuhteeseen (joka voi päättyä onnellisesti tai huonosti), mikä lasketaan voitoksi, tai sitten ei löydä ketään, eli häviää pelin.

### Pelin sisällöstä
*HUOM* Kaikki pelin hahmon ovat kuvitteellisia. Hahmoja esittävät kuvat ovat löydetty Googlesta tai erilaisilta sivuilta, jotka tarjoavat ilmaisia stock -kuvia. Näiden lisäksi kuvat, joissa esiintyy ihmisiä, on sumennettu Polygonize-algoritmilla satunnaisesti, jotta niissä olevia henkilöitä ei voida tunnistaa.

Muistakaa, että pelissä karikatyylisesti tuodaan esille erilaisia deittipalveluissa esiintyviä stereotypioita ja että sen tarkoituksena ei ole loukata ketään.

Sisältää voimakasta kielenkäyttöä ja seksuaalissävytteisiä teemoja.

### Pelin sisällön laajentaminen (modding)
Hinder sisältää mahdollisuuden niille, joille ohjelmointikieli, millä peli on kehitetty (Java) ei ole tuttu  lisätä siihen uusia keskustelukumppaneita ja myöhemmin mahdollisesti muutakin sisältöä.

Lisään tähän myöhemmin paremman dokumentaation, miten /resources -hakemiston emoji.data ja .profile -tiedostot toimii. Toistaiseksi jos olet kiinnostunut lisäämään uusia keskustelukumppaneita peliin, suosittelen tutkimaan valmiita profiileita, sillä ne sisältävät tietoa siitä miten uusia keskustelukumppaneita voi luoda.

## Linkkejä projektin dokumentaatioon
Tässä erilaisia linkkejä projektiin liittyvään dokumentaatioon:
* [suunnitelma](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/DESIGN.md). Sisältää alustavan design documentin.
* [aikakirjanpito](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/TIME.md). Sisältää työaikakirjanpidon projektiin liittyen.

## Ohjeita projektin käynnistämiseen ja komentorivikomentoja

### Käynnistys
Voit käynnistää projektin joko lataamalla sen githubista ja suorittamalla NetBeansilla tai komentorivikomennolla
```
mvn compile exec:java -Dexec.mainClass=hinder.hinderUi
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
