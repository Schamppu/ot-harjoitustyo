// Alla hahmon tiedot. Kommentteja tiedostoon voi kirjoittaa aloittamalla uuden rivin //-merkinnällä.
// Rivinvaihdon saa kirjoittamalla "/n"

#NAME Yucca
#AGE 27
#BIO Girls whos like fast cars and racying is’nt wierd shes a gift from god :pray: /n /nNissan Skyline R34 2.5T GTT manuaalivaihteinen
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

#0 Terppa :smile0:
#OPT Tervehdi #MSG no moii :happy0: #REF 1
#OPT Kysy autosta #MSG siisti auto sulla! paljonko sillä on ajettu? #REF 2
#OPT Moikkaa tylysti #MSG hei #REF 1
#OPT Tervehdi englanniksi #MSG hello there, how are you doing? #REF 3
