# Arkkitehtuuri
## Rakenne
Ohjelman rakenne ilmenee seuraavasta kuvasta:

(https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/logic.png)

Rakenne selitettynä tarkemmin auki:
* hinder-pakkaus sisältää ohjelman toiminnalle välttämättömimmät luokat, eli HinderUi:n ja HinderMethods:n. Nämä luokat sisältävät suurimman osan ohjelman toiminnallisuudesta, pääsääntöisesti niin että HinderUi sisältää pelkän käyttöliittymän ja HinderMethods siihen liittyviä metodeja.
* classes-pakkaus sisältää luokkia, joita luodaan useita. Näitä on profiilit, popupit ja dialogit.


## Käyttöliittymä
Tähän lisätään jatkossa parempi kuvaus käyttöliittymästä.

## Sovelluslogiikka
Ohjelman sovellus- ja luokkalogiikkaa selittää seuraava kuva:

(https://github.com/Schamppu/ot-harjoitustyo/blob/master/documentation/classes.png)

Sovelluslogiikkaa tarkemmin auki selitettynä:
* Main.java ainoastaan käynnistää HinderUi:n. Tämä on välttämätöntä, että JavaFX toimii oikein.
* HinderUi.java sisältää käyttöliittymään liittyvät koodit ja pyörittää myös AnimationTimeria, joka vastaa joistakin käyttöliittymään liittyvistä toiminnallisuuksista. Muut toiminnallisuudet on ulkoistettu HinderMethods.java:lle.
* HinderMethods.java sisältää käyttöliittymään ja muuhun sovelluslogiikkaan liittyviä metodeja. Sisältää Runsaasti siis kutsuttavia metodeja, joita muut luokat kutsuvat.
* Profile.java sisältää yhden .profile -tiedoston sisältämän datan käännettynä .profile -tiedoston tekstimuotoisesta syntaksista sovellukselle ymmärrettävään muotoon. Näitä luokkia luodaan yhtä monta, kuin /resources/profiles/ hakemistossa on .profile tiedostoja.
* Dialog.java sisältää yhden dialogitekstin referensseineen, teksteineen ja vaihtoehtoineen. Nämä luo Profile.java, ja yhdellä profiililla saattaa olla jopa satoja dialogiolioita luotuna.
* Popup.java on .profile -tiedostojen ja muiden pelin hieman normaalista poikkeavaan laajennettavuuteen liittyvä luokka, joka luo virheilmoituksen. Virheellisestä syntaksista .profile tiedostoissa luodaan esimerkiksi virheilmoituksia.

## Tietojen pysyväistallennus
Suoritetaan tulevaisuudessa tietokannan kautta.

## Tiedostot
/resources -hakemiston sisältämiä tiedostoja ovat:

* emoji.data: sisältää emojit.
* character.data: sisältää erilaiset pelaajahahmon vaihtoehdot.
* .profile tiedosto: sisältää kekustelukumppaneiden profiileita.
* /pictures: kansion sisältämät kuvat.
