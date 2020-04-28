// Alla hahmon tiedot. Kommentteja tiedostoon voi kirjoittaa aloittamalla uuden rivin //-merkinnällä.
// Rivinvaihdon saa kirjoittamalla "/n"

#NAME Ludwig
#AGE 23
#BIO :fin:/:swe: /n Lähellä sydäntäni on viini, purjehdus ja kylkiluut. /n /n Ekoille treffeille Roomaan?
#PIC ludwig.png
#JOB Nordea Bank
#STUDY Hanken Svenska handelshögskolan
#CITY Espoo
#VICTORY Ludwigin kanssa ei voi päätyä treffeille.

// Kirjoita alle rivi #CONTINUE jos treffit eivät onnistu ja etsinnän on jatkuttava.

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


// Initial convo

#0 Tjena. :wave:
#OPT Tervehdi #MSG moi! :smile0: #REF 1
#OPT Tervehdi ruotsiksi #MSG hejsan Ludwig! #REF 2
#OPT Moikkaa tylysti #MSG moi #REF 1
#OPT Kysy veneen hintaa #MSG paljonko sun vene makso? #REF 4

#1 Niin olitteko oikeasti 22 vuotias ja töissä Espresso Housella? :grinsweat:
#OPT Joo #MSG joo, oon ollu jo vuoden :happy0: #REF 20
#OPT Miksi kysyt? #MSG joo, kui? #REF 30
#OPT Keksi joku selitys #MSG joo siis oon vaan osa-aikaisena tuolla ku luen oikiksen pääsykokeisiin :rolleyes: #REF 21

#2 Kan du pratar Svenska?
#OPT En #MSG no en muuta kuin ihan vähän, kirjoitin A:n lukiossa ruotsista #REF 3

#3 Ahh :grin: Menikö sulla muut kirjoitukset miten?
#OPT Kerro totuus #MSG no meni vähän huonosti :laugh0: sain C, C, C, B, A #REF 5
#OPT Valehtele #MSG no siis ainoostaan toi meni huonosti, muuten sain L ja E kaikista :happy0: #REF 10

#5 Senkö takia olet nyt töissä Espresso House etkä opiskele?
#OPT Tykkään käydä töissä #MSG viihdyn töissä ja ei tässä mikään kiire vielä ole opiskelemaan #REF 6
#OPT Haen opiskelemaan #MSG haen kyllä nyt opiskelemaan, ajattelin hakea oikikseen #REF 7

#7 :grin: Sä et tule koskaan tolla todistuksella kyllä pääsemään sinne :thumbdown:
#REF 8

#8 Mä opiskelen nyt Hanken:issa :happy0: Kolmas vuosi menossa. Olen myös töissä Nordea Bankenissa.
#REF 9

#10 Jassoo. Minä kirjoittin kuusi Laudatur. :happy0:
#REF 9

// Matkustelu
#9 Tykkäätkö matkustella?
#OPT Joo #MSG kyllä tykkään :relief: #REF 50
#OPT Jos on rahaa #MSG joo, aina kun on rahaa niin se on kivaa #REF 51
#OPT Kysy voitko päästä Roomaan #MSG joo! voidaanko mennä ekoille treffeille sinne Roomaan? :relief: #REF 56

#50 Missä olet matkustanut viimeaikainen?
#OPT Kerro #MSG käytiin porukoiden kanssa Ruotsissa :swe: pari kuukautta sitten laivalla #REF 52
#OPT Liioittele #MSG oon ollu vaikka ja missä! jenkeissä New Yorkis, Thaimaassa, Austraalias ja Kroatiassa viime aikoina #REF 53

#51 Aivan. Onko vanhempasi fattig? Inte pengar?
#OPT Kyllä #MSG no siis ei ne nyt mitään miljonäärejä ole :grinsweat: #REF 6
#OPT Ei #MSG no siis on niillä rahaa, ne vaan ei viime aikoina oo ehtiny oikein mennä mun kanssa reissuihin #REF 54
#OPT Mitä sillä on väliä? #MSG mitä väliä sillä on et paljonko niillä on rahaa? :raisedbrow: #REF 4

#52 Ai risteilyllä kävitte. Mahtoi olla hauskaa :grinsweat:
#REF 55

#53 Fantastisk!
#REF 55

#54 Ikävä kuulla. Matkutaminen on kuitenkin todella kivaa tekemistä :happy0:
#REF 55

#55 Olen itse viimeksi käynyt lentäen Yhdysvalloissa, Vietnamissa ja Singapore. Purjehdin myös Monacoon kesällä, samalla vietin aikaa Italiassa.
#REF 60

#56 Jag vet inte :grin: Mun täytyy ensin ottaa selkoa susta, toistaiseksi uskon että emme ole lähdössä Roomaan :smirk:
#REF 50


// Haetteko opiskelemaan
#20 Haetteko opiskelemaan? :think: pääsykokeet tulossa
#OPT Valehtele että haet #MSG joo, haen oikikseen nyt :happy0: #REF 21
#OPT En #MSG en hae, käyn vaan töissä nyt #REF 100

#21 Mielenkiintoinen. Harkitsin myös itse oikeustiedettä, mutta päädyin Hanken:ssiin. Miksi oikeustiede kiinnostaa?
#OPT Raha ja status #MSG no mua lähinnä kiinnostaa se kun siitä maksetaan hyvin ja se vaan kuulostaa tosi kivalta et opiskelis oikiksessa #REF 22
#OPT Ihmisten auttaminen #MSG haluan auttaa ihmisiä ja uskon oikeuteen ja oikeudenmukaisuuteen, siks sitä haluan opiskella #REF 23
#OPT Et keksinyt muuta #MSG no siis en keksinyt muuta tutkintoa mikä kiinnostas niin luen tohon #REF 24

#22 Riktig! :grin: Minun pappa on asianajaja ja sanoo, että raha on oikeustieteessä parasta. Kauppatieteessä myös.
#REF 9

#23 Jaha. Kuulostaa naisten tunteiluilta tuollaiset syyt opiskella jotain.
#REF 9

#24 Et keksinyt muuta? Ja lukion jälkeen sinulla on ollut jo monta vuotta aikaa miettiä mitä haet?
#REF 100

// Miksi kysyt?
#30 Kiinnostaa tietää. Olen itse aika menestynyt elämässä nuoresta iästä huolimatta. Etsin samanlaista henkilöä.
#REF 31

#31 Opiskelen itse nyt Hanken:ssa. Töissä olen Nordea Bankenissa. :smile0:
#REF 20 // Mene Haetteko opiskelemaan -kohtaan

// Elämän tavoitteet
#60 Missä näet itsesi viiden vuoden kuluttua?
#OPT Opiskelemassa #MSG uskoisin, että olen silloin opiskelemassa :smile0: #REF 61
#OPT Töissä #MSG varmaan edelleen töissä :grinsweat: #REF 62
#OPT Avaudu keskustelun pinnallisuudesta #MSG kuules Ludwig :laugh0: sua tuntuu tän keskustelun aika kiinnostavan ainoastaan mun varallisuus mikä on todella epäkohteliasta ja antaa susta mulle aika bad vibes. #REF 4

#61 Kuulostaa hyvältä. :smile0:
#OPT Pyydä treffeille #MSG lähdetäänkö treffeille? #REF 65
#OPT Kysy mitä etsii Hinderistä #MSG mitä sä etsit Hinderistä? #REF 66

#62 Mmm. Jaha...
#REF 101

#65 En ikävä kyllä usko, että haluaisin kanssasi treffeille.
#REF 101

#66 Etsin Hinderistä itselleni vaimoa :smile0: Mutta ikävä kyllä minusta tuntuu, että sinä et sovellu siihen.
#REF 101

// Estot
#4 Just, jävla tiggare :grinsweat:
#RMV

#6 Selvä :wave:
#RMV

#100 Haiskahdat luuserilta :wave:
#RMV

#101 Oli kiva keskustella :wave:
#RMV
