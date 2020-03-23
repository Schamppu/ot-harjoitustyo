package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(10000);
    }
    
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);      
    }
    @Test
    public void kassassaRahaa() {
        assertTrue(kassa.kassassaRahaa() == 100000);      
    }
    @Test
    public void myydytLounaat() {
        assertTrue(kassa.edullisiaLounaitaMyyty() == 0 && kassa.maukkaitaLounaitaMyyty() == 0);      
    }
    @Test
    public void syoMaukkaasti() {
        assertTrue(kassa.syoMaukkaasti(400) == 0 && kassa.maukkaitaLounaitaMyyty() == 1);      
    }
    @Test
    public void syoEdullisesti() {
        assertTrue(kassa.syoEdullisesti(240) == 0 && kassa.edullisiaLounaitaMyyty() == 1);      
    }
    @Test
    public void syoMaukkaastiEiRiita() {
        assertTrue(kassa.syoMaukkaasti(30) == 30);      
    }
    @Test
    public void syoEdullisestiEiRita() {
        assertTrue(kassa.syoEdullisesti(20) == 20);      
    }
    @Test
    public void lataaRahaa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertTrue(kassa.kassassaRahaa() == 100000+1000 && kortti.saldo() == 10000+1000);      
    }
    @Test
    public void lataaRahaaNolla() {
        kassa.lataaRahaaKortille(kortti, -1000);
        assertTrue(kassa.kassassaRahaa() == 100000 && kortti.saldo() == 10000);      
    }
    @Test
    public void ostaKortillaEdullisesti() {
        assertTrue(kassa.syoEdullisesti(kortti) == true && kortti.saldo() == 10000-240 && kassa.edullisiaLounaitaMyyty() == 1);      
    }
    @Test
    public void ostaKortillaEdullisestiEiRiita() {
        Maksukortti kortti = new Maksukortti(100);
        assertTrue(kassa.syoEdullisesti(kortti) == false && kortti.saldo() == 100 && kassa.edullisiaLounaitaMyyty() == 0);      
    }
    @Test
    public void ostaKortillaMaukkaasti() {
        assertTrue(kassa.syoMaukkaasti(kortti) == true && kortti.saldo() == 10000-400 && kassa.maukkaitaLounaitaMyyty() == 1);      
    }
    @Test
    public void ostaKortillaMaukkaastiEiRiita() {
        Maksukortti kortti = new Maksukortti(100);
        assertTrue(kassa.syoMaukkaasti(kortti) == false && kortti.saldo() == 100 && kassa.maukkaitaLounaitaMyyty() == 0);      
    }
}
