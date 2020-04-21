// Alla hahmon tiedot. Kommentteja tiedostoon voi kirjoittaa aloittamalla uuden rivin //-merkinnällä.
// Rivinvaihdon saa kirjoittamalla "/n"

#NAME Miklu
#AGE 20
#BIO oikeesti 16. Discord: xXxMikLuMagicxXx /n Fortnite: GoldenMixuli04 /n /n :ghost:: mikluboi04
#PIC miklu.png
#JOB opiskelija
#STUDY Mäkelänrinteen Lukio
#CITY Helsinki
#VICTORY Päädyit treffeille Miklun kanssa.

// Alla hahmon kanssa käytävä dialogi.
// Uuden dialogitekstin voi lisätä kirjoittamalla # ja jokin numero. Numero on kyseisen dialogin viitenumero (ID).
// Dialogitekstin, joka alkaa siis esimerkiksi viitteellä #131 alle tulee #OPT -merkinnällä aloittamalla vastausvaihtoehdot.
// #OPT:n jälkeen kirjoitetaan mitä vastausvaihtoehtonappulassa lukee.
// #MSG:n jälkeen lukee mitä pelaajan hahmon viesti sisältää kun nappulaa painaa.
// #REF:n jälkeen lukee mihin dialogiin siirrytään (jonka dialogin viitenumero määrittää)

// Mikäli dialogiin ei tule yhtään vastausvaihtoehtoa, vaan keskustelukumppani kirjoittaa välittömästi toisen viestin sen jälkeen
// kirjoita dialogin määrittelyn alle vain #REF ja viitenumero, esim #REF 131.

// HUOM! On ehdottoman tärkeää, että kaikki tulevat samalle riville!

#0 Pelaatko forttii? :think: :think:
#OPT Tervehdi #MSG no moi vaan sulleki :smile1: #REF 1
#OPT Kyllä #MSG joo kyl mä oon pelannu sitä jonkin verran :cool: #REF 2
#OPT Ei #MSG en kyllä ole :sad1: #REF 3
#OPT Mikä fortti? #MSG niin mikä fortti? :laugh0: #REF 4

#1 Joo moi
#OPT Pelaat Fortnitea #MSG niin kyl mä pelaan sitä forttia :laugh0: #REF 2
#OPT Et pelaa Fortnitea #MSG nii en kyl pelaa forttii #REF 3
#OPT Kysy mitä tekee Hinderissä #MSG niin mitä sä teet tääl Hinderissä? :smile0: #REF 20

#2 Nice pelaaks MC
#OPT Kyllä #MSG joo kyl mä sitäkin joskus #REF 5
#OPT Ei #MSG en pelaa MC:tä #REF 3
#OPT Mikä ihmeen MC? #MSG siis mikä on MC? #REF 7

#3 Aa lol :grin: :grin: mitä sä sit teet
#OPT Kerro harrastukset #MSG harrastuksena käyn salilla ja juokseulenkillä sillon tällön #REF 40
#OPT Kerro ja kysy samalla harrastuksia #MSG käyn salilla ja juoksulenkillä, entä sä? #REF 41
#OPT Kerro että lukee bio:ssa #MSG mun bios lukee mitä harrastan, et vissii lukenu :laugh0: #REF 42

#4 Aa :xd: se on yks peli vaa, mitä sä harrastat?
#OPT Kerro harrastukset #MSG harrastuksena käyn salilla ja juokseulenkillä sillon tällön #REF 40
#OPT Kerro ja kysy samalla harrastuksia #MSG käyn salilla ja juoksulenkillä, entä sä? #REF 41
#OPT Kerro että lukee bio:ssa #MSG mun bios lukee mitä harrastan, et vissii lukenu :laugh0: #REF 42

#5 Ok me kelattii frendin kaa tehä oma MC servu voit tulla sinne pelaa :smile0:
#REF 6

#6 Harrastaks jtn :smile0: :smile0:
#OPT Kerro harrastukset #MSG harrastuksena käyn salilla ja juokseulenkillä sillon tällön #REF 40
#OPT Kerro ja kysy samalla harrastuksia #MSG käyn salilla ja juoksulenkillä, entä sä? #REF 41
#OPT Kerro että lukee bio:ssa #MSG mun bios lukee mitä harrastan, et vissii lukenu :laugh0: #REF 42

#7 Aa :xd: :xd: me just frendin kaa meinattii perustaa oma MC servu
#REF 6

#8 Minecraft :xd: :xd: :xd: salee et oo kuullu siit kaikki tietää sen
#REF 6

// Harrastukset
#40 Nice ooks thicc :fire: :fire:
#OPT Joo #MSG joo kyl ihan :grin: #REF 45
#OPT Ei #MSG no en nyt tiiä :grinsweat: #REF 47
#OPT Mikä thicc #MSG mikä se on? #REF 48

#41 Nice :thumbup: :thumbup: :xd: joo meitsi pelaa ja sit skuuttailen semisti :cool: käyn välil kans trampoliinipuistos pomppimas
#OPT Kehu harrastuksia #MSG sul on kyl siistit harrastukset #REF 44
#OPT Kritisoi harrastuksia #MSG vitun jonne :grinsweat: #REF 101

#42 Aa joo :xd: :xd: :xd: en ikin jagee lukee noit :xd: mut cool :thumbup:
#OPT Kysy harrastuksia #MSG mitä sä sit harrastat? :smile0: #REF 43
#OPT Kysy mitä tekee Hinderissä #MSG mitä sä teet tääl hinderis? #REF 20

#43 Meitsi skuuttailee ja pelaa välil :cool: ja käyn välil trampoliinipuistos pomppimas :xd: :xd:
#OPT Kehu harrastuksia #MSG iha kivat harrastukset sul! #REF 44
#OPT Kritisoi harrastuksia #MSG vittu sä oot jonne :grinsweat: #REF 101

#44 Thx :cool:
#OPT Puhu töistä #MSG ooksä hakenu kesäduuneja tai käyny töis? #REF 50
#OPT Kysy miten koulussa menee #MSG mites sul menee koulus? :smile0: #REF 70

#45 Uu sul on salee hyvä peba :peach: :fire:
#OPT Kiitä #MSG hei kiitos :inlove: #REF 46
#OPT Kysy harrastuksia #MSG nii mitäs sä sit harrastat? :smirk: #REF 43
#OPT Sano että Hinder on aikuisille #MSG kai sä tiesit et Hinder on aikusille meinattu :laugh0: #REF 90

#46 Ei midii :cool:
#OPT Kysy harrastuksia #MSG mitäs sä harrastat? #REF 43
#OPT Sano että Hinder on aikuisille #MSG kai tiesit et tää sovellus on aikusille? #REF 90

#47 Aa no ei se mitää emmäkää oo :xd: :xd:
#OPT Kysy harrastuksia #MSG mitäs sä harrastat? #REF 43
#OPT Sano että Hinder on aikuisille #MSG kai tiesit et tää sovellus on aikusille? #REF 90

#48 Se on vaa semmone et on tiäks hyvä perse ja näin :grinsweat: :xd:
#OPT Kysy harrastuksia #MSG mitäs sä harrastat? #REF 43
#OPT Sano että Hinder on aikuisille #MSG kai tiesit et tää sovellus on aikusille? #REF 90

// Vanhojen tanssit
#20 Mul on vanhojen tanssit tulossa :grinsweat: :grin: etin tanssiparii ku kuumottaa kysyy koulust :grin: :grin:
#OPT Kysy miten koulu menee #MSG miten sulla menee sit koulus? #REF 71
#OPT Kysy harrastuksista #MSG mitä sä harrastat? #REF 43
#OPT Puhu töistä #MSG ooksä hakenu kesäduuneja tai käyks töis? #REF 51
#OPT Sano että Hinder on aikuisille #MSG kai sä tiesit et tää on aikusille meinattu tää sovellus :think: #REF 90

#21 :surprised:
#REF 22

#22 :surprised: :surprised:
#REF 23

#23 :cool:
#REF 24

#24 Ois iha vitun bängeri jos tuut meitsin kans tanssii :cool: :cool:
#OPT Ehdota treffejä #MSG no nähääks vaikka huomenna ja sovitaan noist tansseist? #REF 25
#OPT Solvaa #MSG läppä oli en vitussakaa tuu tanssimaan sun kans #REF 101
#OPT Trollaa #MSG joo :relief: ja voitais me jotain muutakin tehä :egg: :drops: #REF 26

#25 Joo khyl käy heti koulun jälkeen :cool: :cool:
#WIN

#26 :surprised: :surprised: :inlove: :surprised:
#REF 27

#27 :surprised: :surprised:
#REF 28

#28 :think:
#RMV

// Työt
#50 Joo siis meitsi myy denssii mun mautost aika paljon :xd: :xd: ja sit olin TETis päiväkodis pari vuot sitte
#OPT Kerro omista töistä #MSG joo :grinteeth: siistii, mä oon ollu täs vuoden töissä Espresso Housella #REF 55
#OPT Kritisoi nuuskaamista #MSG hyi nuuskaa :grinsweat: mut ainakin toi päiväkoti oli varmaan jees? #REF 51
#OPT Solvaa #MSG vitun nuuskamuikkunen oikeesti :xd: #REF 101

#51 No ei kyl ku piti vaihtaa vaippoi jne :xd: :xd: :xd: ja denssi on just :goblin: jees :xd:
#REF 55

#55 Tykkääks olla tuol espresso housel?
#OPT Kyllä #MSG on siel kyl tosi kivaa! #REF 56
#OPT Ei #MSG no en ehkä aio loppuelämääni siellä viettää :rolleyes: #REF 57

#56 Nice mä en hirveest kahvii kyl juo :xd: juon lähinnä megist ja esarii :xd: :xd: :grinsweat: :fire:
#OPT Okei #MSG ookei... :smile1: #REF 58
#OPT Kysy koulunkäynnistä #MSG mites sulla menee koulussa? :smile0: #REF 70
#OPT Solvaa #MSG ei vitun jonne :smile1: #REF 101

#57 Aaa :sad1: :sad1: mäkään en diggaa kyl töist sillee :xd:
#OPT Kysy koulunkäynnistä #MSG mites sulla menee koulus? :happy0: #REF 70
#OPT Solvaa #MSG vittu sä oot jonne #REF 101

#58 Joo khyl :xd: :xd:
#REF 59

#59 Megis pärtsii :fire:
#OPT Kysy koulunkäynnistä #MSG mites sul menee koulus? :smirk: #REF 70
#OPT Solvaa #MSG ihme jonne oot kyl :grin: #REF 101

// Koulu
#70 No ihan hyvin menee koulussa :grin: :grin: :smirk: ainut vaa et tarvisin parin wanhojen tansseihi :xd:
#OPT Ehdota että tulet pariksi #MSG entä jos mä tuun pariksi? #REF 21
#OPT Kysy enemmän koulusta #MSG kiva kuulla :happy0: ootko saanu hyvii numeroit? #REF 72

#71 No ihan hyvin kyl paitsi et tarvitsisin sen tanssiparin :xd: :xd: // Vaihtoehto edelliselle jos tulee kohdasta 20
#OPT Ehdota että tulet pariksi #MSG entä jos mä tuun pariksi? #REF 21
#OPT Kysy enemmän koulusta #MSG kiva kuulla :happy0: ootko saanu hyvii numeroit? #REF 72


// Tää sovellus on aikuisille
#90 No joo kyl mä tiiän :xd: mut iha sama :grin: :grin:
#OPT Valista #MSG sun kantsii olla varovainen täällä hei, voi olla vaik millasii tyyppejä liikenteessä :think: #REF 101
#OPT Kysy menestyksestä Hinderissä #MSG mites, ootko löytäny sit mitää täältä Hinderistä? #REF 101

// Estot
#101 K.
#REF 102

#102 YOLO
#RMV
