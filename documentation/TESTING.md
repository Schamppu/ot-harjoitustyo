# Testausdokumentti

Peli sisältää muutaman automatisoidun testin, jotka lähinnä testaavat että pelistä löytyy profiili ja että peli pystyy ladata sen. Tämä on pelin toiminnan kannalta tärkein ja eniten testauksessa ongelmia tuottanut asia, että peli ei tunnistanut hakemistoja oikein tai löytänyt .profile -tiedostoja.

## Testauskattavuus
Pelin testit testaavat .profile tiedostojen lataamista ja liittyvät lähes täysin siihen. Kuva testauskattavuudesta:

[testauskattavuus](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/testing.png)

Rivikattavuus on 43% ja haarautumakattavuus 48%. Pyrin tekemään lisää testejä, mutta en osannut koodata testejä ohjelmaan, sillä testien alustus ohjelman käyttämän tiedostoista lataamisen takia oli erittäin hankalaa.

## Sovelluslogiikka
Pelistä löytyvä hinderMainTest.java sisältää kaikki pelin sisältämät testit.

## Sovellukseen jääneet laatuongelmat
Testauksesta puuttuu yksityiskohtaisemmat testit, ja ohjelma lähinnä testaa emojien ja profile -tiedostojen lataamista, mikä olikin yksi tärkeimmistä testeistä jotta ohjelma voidaan edes suorittaa. Kuitenkin yksityiskohtaisempien testien tekeminen jäi ohjelmasta puuttumaan, sillä en sen erikoisen tiedostorakenteen takia saanut testien alustusta toimimaan vaan ne palauttivat aina virheilmoitukset.

Sovellus on testattu manuaalisesti pelaamalla peliä useaan kerran aika pomminvarmasti toimivaksi, mutta automaattinen testaus puuttuu.
