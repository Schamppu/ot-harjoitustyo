# Arkkitehtuuri
## Rakenne
Ohjelman rakenne ilmenee seuraavasta kuvasta:

![alt text](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/logic.png)

Rakenne selitettynä tarkemmin auki:
* hinder-pakkaus sisältää ohjelman toiminnalle välttämättömimmät luokat, eli HinderUi:n ja HinderMethods:n. Nämä luokat sisältävät suurimman osan ohjelman toiminnallisuudesta, pääsääntöisesti niin että HinderUi sisältää pelkän käyttöliittymän ja HinderMethods siihen liittyviä metodeja.
* classes-pakkaus sisältää luokkia, joita luodaan useita. Näitä on profiilit, popupit ja dialogit.


## Käyttöliittymä
Tähän lisätään jatkossa parempi kuvaus käyttöliittymästä.

## Sovelluslogiikka
Ohjelman sovellus- ja luokkalogiikkaa selittää seuraava kuva:

![alt text](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/classes.png)

Sovelluslogiikkaa tarkemmin auki selitettynä:
* Main.java ainoastaan käynnistää HinderUi:n. Tämä on välttämätöntä, että JavaFX toimii oikein.
* HinderUi.java sisältää käyttöliittymään liittyvät koodit ja pyörittää myös AnimationTimeria, joka vastaa joistakin käyttöliittymään liittyvistä toiminnallisuuksista. Muut toiminnallisuudet on ulkoistettu HinderMethods.java:lle.
* HinderMethods.java sisältää käyttöliittymään ja muuhun sovelluslogiikkaan liittyviä metodeja. Sisältää Runsaasti siis kutsuttavia metodeja, joita muut luokat kutsuvat.
* Profile.java sisältää yhden .profile -tiedoston sisältämän datan käännettynä .profile -tiedoston tekstimuotoisesta syntaksista sovellukselle ymmärrettävään muotoon. Näitä luokkia luodaan yhtä monta, kuin /resources/profiles/ hakemistossa on .profile tiedostoja.
* Dialog.java sisältää yhden dialogitekstin referensseineen, teksteineen ja vaihtoehtoineen. Nämä luo Profile.java, ja yhdellä profiililla saattaa olla jopa satoja dialogiolioita luotuna.
* Popup.java on .profile -tiedostojen ja muiden pelin hieman normaalista poikkeavaan laajennettavuuteen liittyvä luokka, joka luo virheilmoituksen. Virheellisestä syntaksista .profile tiedostoissa luodaan esimerkiksi virheilmoituksia.

## Tietojen pysyväistallennus
Pelistä karsittu myöhemmässä vaiheessa tallentaminen vaatimuksista. Näin lyhyessä pelissä en kokenut tarpeelliseksi lisätä mahdollisuutta pelin vaiheen tallentamiseen. Kuitenkin, peli lataa tietonsa tiedostoista (.profile ja .data tiedostoista.) Nämä tiedot noudattavat omaa syntaksiaan, joka on dokumentoitu tarkasti kyseisissä tiedostoissa kommenteissa. Nämä tiedostot pääpiirteittäin toimii seuraavalla periaatteella:

* # -merkki aloittaa "tagin", esimerkiksi #NAME määrittelee profiilin nimen.
* Kommentteja tiedostoon voi lisätä kirjoittamalla // -merkit

Ylläolevien periaatteiden mukaisesti peli osaa generoida profiileja ja niihin liittyvät keskustelut. Keskustelut voivat haarautua useaan suuntaan.

Peli myös osaa etsiä kaikki .profile -tiedostot sen /resources -hakemistosta ja käsitellä ne. Peli myös generoi virheilmoituksia, mikäli .profile -tiedostojen syntaksissa on virheitä.

Laajempi esimerkki tiedoston rakenteesta:
```
#NAME Miklu
#AGE 20
#BIO oikeesti 16. Discord: xXxMikLuMagicxXx /n #NAME Miklu
#AGE 20
#BIO oikeesti 16. Discord: xXxMikLuMagicxXx /n Fortnite: GoldenMixuli04 /n /n :ghost:: mikluboi04
#PIC miklu.png
#JOB opiskelija
#STUDY Mäkelänrinteen Lukio
#CITY Helsinki
#VICTORY Päädyit treffeille Miklun kanssa.Fortnite: GoldenMixuli04 /n /n :ghost:: mikluboi04
#PIC miklu.png
#JOB opiskelija
#STUDY Mäkelänrinteen Lukio
#CITY Helsinki
#VICTORY Päädyit treffeille Miklun kanssa.
```

## Tiedostot
/resources -hakemiston sisältämiä tiedostoja ovat:

* emoji.data: sisältää emojit.
* character.data: sisältää erilaiset pelaajahahmon vaihtoehdot.
* .profile tiedosto: sisältää kekustelukumppaneiden profiileita.
* /pictures: kansion sisältämät kuvat.

## Päätoiminnallisuudet
Seuraavaksi luetellaan pelin päätoiminnallisuudet.
### Pelin aloitus
Peli alkaa esittelemällä pelin tarkoituksen ja mainitsemalla sen sisällöstä. Tämän jälkeen näytetään pelaajan profiili ja pelaajan ensimmäisen keskustelukumppanin profiili. Tämä toiminnallisuus tapahtuu täysin HinderUi -luokassa. Käytännössä tämä pelin vaihe sisältää ainoastaan nappuloita ja tekstiä.

Pelin aloitus hyödyntää kuitenkin HinderMethods -olion metodia createEmojiText() joka luo tekstiä korvaten emoji-tagit kuvilla, jotka sisältävät kyseisen emojin.

### Keskustelut
Pelin pääpiirteenä on hahmojen kanssa käytävät keskustelut. Ne toimivat niin, että valitun keskustelukumppanin .profile tiedostosta ladataan hahmoon liittyvä keskustelu pelin sisältämiin tietorakenteisiin, ja siirrytään referenssikoodeja käyttämällä eri chat-vaihtoehtojen välillä. Viestit piirretään niiden ilmestymisjärjestyksessä pelaajalle.

Keskustelulogiikkaa kuvaa seuraava sekvenssikaavio:
![alt text](https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/sequence.png)

Sekvenssikaavio kekustelulogiikasta avaa pelin päätoiminnallisuutta, eli miten peli käytännössä toimii. HinderUi -luokka, joka sisältää käyttöliittymän toiminnallisuudet, pyytää profiiliin liittyvää dataa Profile-oliolta. Profile-olio on puolestaan ladannut kaiken datansa siihen kytketystä .profile -tiedostosta, minkä perusteella se luo Dialog-olioita. Nämä dialog-oliot välitetään HinderUi-luokalle.

HinderMethods-puolestaan sisältää metodit joita Profile-luokka sekä HinderUi-luokka käyttää. Nämä metodit sisältää mm. createCharacterData() -metodin, jolla profiiliin liitettyyn tiedostoon pohjautuen generoidaan Dialog-olioita.
