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

#0 Morjensta ,,,, taitaa tytön vanhemmat olla Simpukoita , kun Olet tuommoinen limainen vittu saatana ;)
#OPT Tervehdi #MSG moi, sähän olet aika hauska |grin #REF 1
#OPT Moikkaa tylysti #MSG moi #REF 2
#OPT Vastaa irstaasti #MSG moi komistus |wink tollaset viestit laittaa ihan sukat pyörimään jaloissa |drool #RMV


#1 "Hauska" ja "  hauska" ,,, setä on kuule ennen kin repinyt tuollaisia kaunottaria hiuksista :))) ja muutakin ,, tehty on
#REF 4

#2 Jaa Jaa ,,, ollaankos sitä hankala??? Ei "kannata " olla ;)
#REF 4

#3 Wau sexbätäng ;) ;) ihan alkaa ottamaan eteen minulla ,,, kuvaasi katselen
#REF 4

#4 Mitäs sulla on nyt päällä ??
#OPT Normaalit vaatteet #MSG eei mitään kummallista... ihan normaalit vaatteet |smile0 #WIN
#OPT Vähäiset vaatteet #MSG pelkät pikkarit |wink muuten olen aivan alasti... #WIN
#OPT Älä suostu kertomaan #MSG öö, en halua kertoa mitä mulla on päällä #RMV




//#NUMBER TEXT
//#OPT TEXT #MSG TEXT #REF NUMBER
