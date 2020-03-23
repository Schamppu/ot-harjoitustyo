package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void korttiSaldo() {
        kortti = new Maksukortti(10);
        assertTrue(kortti.saldo() == 10);      
    }
    
    @Test
    public void korttiSaldoLisaa() {
        kortti = new Maksukortti(10);
        kortti.lataaRahaa(10);
        assertTrue(kortti.saldo() == 20);      
    }
    
    @Test
    public void korttiSaldoOta() {
        kortti = new Maksukortti(10);
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo() == 5);      
    }
    
    @Test
    public void korttiSaldoOtaVirhe() {
        kortti = new Maksukortti(10);
        kortti.otaRahaa(20);
        assertTrue(kortti.saldo() == 10);      
    }
    
    @Test
    public void korttiSaldoOtaTrue() {
        kortti = new Maksukortti(10);
        assertTrue(kortti.otaRahaa(5));      
    }
    
    @Test
    public void korttiSaldoOtaFalse() {
        kortti = new Maksukortti(10);
        assertFalse(kortti.otaRahaa(15));      
    }
    
    @Test
    public void korttiToString() {
        kortti = new Maksukortti(10);
        assertFalse(kortti.toString() == "saldo: 10.00");      
    }
}
