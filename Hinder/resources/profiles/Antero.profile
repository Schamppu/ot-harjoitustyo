// Alla hahmon tiedot. Kommentteja tiedostoon voi kirjoittaa aloittamalla uuden rivin //-merkinnällä.
// Rivinvaihdon saa kirjoittamalla "/n"

#NAME Antero
#AGE 65
#BIO Olin 13 V kun löysin ison patin haaroistani ,,, Se oli Iso suonikas ja Paksu,,, olikin minun "Penikseni " /n /n naiset ottakaa yhteyttä ;)
#PIC antero.png
#JOB Peräkylän rakennusperkeleet Oy
#STUDY Kainuun Ammattikoulu
#CITY Kainuu
#VICTORY Antero tuli tapaamaan sinua autollaan Kainuusta asti, ja vei sinut treffeille Ruskeasannan Shellille. Istuitte pöydässä nautiskellen Shellin antimia, ja jo lyhyen keskustelun päätteeksi ymmärsit, että sinä ja Antero ette tule hyvin toimeen. Antero yritti lähennellä useaan otteeseen, mikä aiheutti lähinnä kiusaantunutta ahdistuneisuutta, ja lopulta päädyit menemään julkisilla takaisin kotiisi.

// Kirjoita alle rivi #CONTINUE jos treffit eivät onnistu ja etsinnän on jatkuttava.
#CONTINUE

// Alla hahmon kanssa käytävä dialogi.
// Uuden dialogitekstin voi lisätä kirjoittamalla # ja jokin numero. Numero on kyseisen dialogin viitenumero (ID).
// Dialogitekstin, joka alkaa siis esimerkiksi viitteellä #131 alle tulee #OPT -merkinnällä aloittamalla vastausvaihtoehdot.
// #OPT:n jälkeen kirjoitetaan mitä vastausvaihtoehtonappulassa lukee.
// #MSG:n jälkeen lukee mitä pelaajan hahmon viesti sisältää kun nappulaa painaa.
// #REF:n jälkeen lukee mihin dialogiin siirrytään (jonka dialogin viitenumero määrittää)

// Mikäli haluat, että keskustelukumppani estää sinut, korvaa #REF viitenumero merkinnällä #RMV, tämän jälkeen peli etsii
// toisen keskustelukumppanin.

// Mikäli haluat, että pelaaja päätyy treffeille hahmon kanssa (eli voittaa pelin), korvaa #REF viitenumero merkinnällä #WIN.

// Mikäli dialogiin ei tule yhtään vastausvaihtoehtoa, vaan keskustelukumppani kirjoittaa välittömästi toisen viestin sen jälkeen
// kirjoita dialogin määrittelyn alle vain #REF ja viitenumero, esim #REF 131.

// HUOM! On ehdottoman tärkeää, että kaikki tulevat samalle riville!


// Initial keskustelu
#0 Morjensta ,,,, taitaa tytön vanhemmat olla Simpukoita , kun Olet tuommoinen limainen vittu saatana ;)
#OPT Tervehdi #MSG moi, sähän olet aika hauska :grin: #REF 1
#OPT Moikkaa tylysti #MSG moi #REF 2
#OPT Vastaa irstaasti #MSG moi komistus :wink: tollaset viestit laittaa ihan sukat pyörimään jaloissa :drool: #REF 3

#1 "Hauska" ja "  hauska" ,,, setä on kuule ennen kin repinyt tuollaisia kaunottaria hiuksista :))) ja muutakin ,, tehty on
#REF 4

#2 Jaa Jaa ,,, ollaankos sitä hankala??? Ei "kannata " olla ;)
#REF 4

#3 Wau JanicaSex-Honey ;) ;) ihan alkaa ottamaan eteen minulla ,,, kuvaasi katselen
#REF 4

#4 Mitäs sulla on nyt päällä ??
#OPT Normaalit vaatteet #MSG eei mitään kummallista... ihan normaalit vaatteet :smile0: #REF 5
#OPT Vähäiset vaatteet #MSG pelkät pikkarit :wink: muuten olen aivan alasti... #REF 6
#OPT Älä suostu kertomaan #MSG öö, en halua kertoa mitä mulla on päällä #REF 7

#5 Hymyilemäänkö aloit oikein kun "setä " kyselee,,, oletko "märkä" ;)
#OPT Kyllä #MSG joo #REF 6
#OPT En #MSG en ole #REF 7

#6 WAU!!! Olet nainen Minun Makuun ,,, kyrpäni aivan pullistuu boksereissa ja "sanoo ",,, että uloshan tuo tahtois ;)
#REF 20

#7 Höh ,,, Hankalako  taidat olla ?? Mistä haluaisit "jutella " :)
#OPT Harrastuksista #MSG no mitä sä harrastat? #REF 8
#OPT Sano suorat sanat #MSG musta tuntuu että meillä ei juurikaan ole yhteistä Antero ja olet todella ällöttävä #REF 23

// Harrastuskeskustelu
#8 Harrastuksia vai :)) olen ainakin yhdessä " lajissa " todella hyvä ,,, naiset ovat niin sanoneet ! Tiedätkö mikä "laji" On kyseessä ??
#OPT Arvaa laji #MSG seksi? :egg: #REF 9
#OPT Älä arvaa #MSG en tiedä :think: #REF 10
#OPT Kerro omista harrastuksista #MSG käyn itse kuntosalilla ja lenkkeilen :smile0: #REF 11

#9 Oikein Arvattu !! Haluaisitko Harrastaa kanssani ?? Naiset kehuneet hyväksi ,,, voisin oikein lypsää kyrpääni spermasta tyhjäksi Sulle mielisairaalla kiimalla
#OPT Suostu #MSG joo, ehkä... milloin? #REF 20
#OPT Älä suostu #MSG ei kiitos #REF 13

#10 No minäpä Kerron ;) harrastukseni on "Seksi",,, Haluaisin sut pumpata täyteen spermaa
#REF 20

#11 Sullahan on varmaan sitten oikein Tiukka ja hyvä perä ;) Haluaisin sua "puristella" !!
#REF 12

#12 Tunnen "painetta " etumuksessa ,,, oiHHH kun tekisi mieli päästä sitä Purkamaan !
#REF 20

#13 Älä nyt viitsi olla hankala ;)) Haluan tavata sut ! Tehdään jotain "kivaa " ;)
#OPT Kuuntele Anteron tarjous #MSG okei... #REF 20
#OPT Kieltäydy #MSG ei nähdä :smirk: #RMV
#OPT Sano suorat sanat #MSG olet ihan helvetin ällöttävä :vomit: iän puolestas voisit olla mun isä. en todellakaan tahdo tavata sua #REF 23

// Voittaminen ja tapaaminen
#20 Voisin ajaa autolla sinne Vantaalle,,, Luoksesi huomenna ;) mitäs sanot ???
#OPT Suostu #MSG tuu vaan niin tavataan! #REF 21
#OPT Älä suostu #MSG en usko että haluan tavata sua :sad0: #REF 22
#OPT Sano suorat sanat #MSG olet todella inhottava ja ällöttävä :vomit: meillä on ikäeroa yli 40v hyi helvetti, ei nähdä #REF 23

#21 Ihanaa Janicca ,,, huomenna nähään !!!
#WIN

// Vonkaaminen

#22 Tyllerö vittu, ,,, älä nyt rupea hankalaksi ! Voisimme tavata ,,, ja Harrastaa seksiä estoitta aamuin illoin ;),,
#OPT Suostu #MSG no okei, nähdään huomenna #REF 21
#OPT Älä suostu #MSG ei nähdä :smirk: #RMV
#OPT Sano suorat sanat #MSG olet ihan helvetin ällöttävä :vomit: iän puolestas voisit olla mun isä. en todellakaan tahdo tavata sua #REF 23

#23 Ihme Pilluämmä olet Janica !!
#RMV
