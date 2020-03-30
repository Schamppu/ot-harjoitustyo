// Alla hahmon tiedot. Kommentteja tiedostoon voi kirjoittaa aloittamalla uuden rivin //-merkinnällä.
// Rivinvaihdon saa kirjoittamalla "/n"

#NAME Yucca
#AGE 27
#BIO Girls whos like fast cars and racying is’nt wierd shes a gift from god |pray /n /nNissan Skyline R34 2.5T GTT manuaalivaihteinen 
#PIC yucca.png
#JOB Automekaanikko
#STUDY Riihimäen Ammattikoulu
#CITY Korso
#VICTORY Päädyit treffeille Yucan kanssa.

// Alla hahmon kanssa käytävä dialogi.
// Uuden dialogitekstin voi lisätä kirjoittamalla # ja jokin numero. Numero on kyseisen dialogin viitenumero (ID).
// Dialogitekstin, joka alkaa siis esimerkiksi viitteellä #131 alle tulee #OPT -merkinnällä aloittamalla vastausvaihtoehdot.
// #OPT:n jälkeen kirjoitetaan mitä vastausvaihtoehtonappulassa lukee.
// #MSG:n jälkeen lukee mitä pelaajan hahmon viesti sisältää kun nappulaa painaa.
// #REF:n jälkeen lukee mihin dialogiin siirrytään (jonka dialogin viitenumero määrittää)

// Mikäli dialogiin ei tule yhtään vastausvaihtoehtoa, vaan keskustelukumppani kirjoittaa välittömästi toisen viestin sen jälkeen
// kirjoita dialogin määrittelyn alle vain #REF ja viitenumero, esim #REF 131.

// HUOM! On ehdottoman tärkeää, että kaikki tulevat samalle riville!

#0 Tjena.
#OPT Tervehdi #MSG moi, sähän olet aika hauska |grin #REF 1
#OPT Tervehdi ruotsiksi #MSG moi, sähän olet aika hauska |grin #REF 1
#OPT Moikkaa tylysti #MSG moi #REF 2


#1 "Hauska" ja "  hauska" ,,, setä on kuule ennen kin repinyt tuollaisia kaunottaria hiuksista :))) ja muutakin ,, tehty on
#REF 4

#2 Jaa Jaa ,,, ollaankos sitä hankala??? Ei "kannata " olla ;)
#REF 4

#3 Wau sexbätäng ;) ;) ihan alkaa ottamaan eteen minulla ,,, kuvaasi katselen
#REF 4

#4 Mitäs sulla on nyt päällä ??
#OPT Normaalit vaatteet #MSG eei mitään kummallista... ihan normaalit vaatteet |smile0 #REF 5
#OPT Vähäiset vaatteet #MSG pelkät pikkarit |wink muuten olen aivan alasti... #REF 6
#OPT Älä suostu kertomaan #MSG öö, en halua kertoa mitä mulla on päällä #REF 7




//#NUMBER TEXT
//#OPT TEXT #MSG TEXT #REF NUMBER
