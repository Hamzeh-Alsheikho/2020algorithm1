package no.oslomet.cs.algdat.Oblig1;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        //assertEquals(true, false, "Implementer maks og denne testen");
        int[]a ={8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        int maks = Oblig1.maks(a);
        assertEquals(20, maks);
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        //assertEquals(true, false, "Implementer ombyttinger og denne testen");
        int[]a ={8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        Oblig1.ombyttinger(a);
        assertEquals(8,Oblig1.ombyttinger(a));
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        assertEquals(true, false, "Implementer antallUlikeSortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        //assertEquals(true, false, "Implementer antallUlikeUsortert og denne testen");
        int[]a ={8,4,17,10,6,20,1,11,15,3,18,9,2,7,19,19};
        Oblig1.antallUlikeUsortert(a);
        assertEquals(15,Oblig1.antallUlikeUsortert(a));
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        //assertEquals(true, false, "Implementer rotasjon og denne testen");
      //  char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
       // Oblig1.rotasjon1(c,1);
       // assertEquals(, Oblig1.rotasjon1(c,1));
    }

    @org.junit.jupiter.api.Test
    void flett() {
       //assertEquals(true, false, "Implementer flett og denne testen");
        String s = Oblig1.flett("ABC", "DEFGH");
        String t = Oblig1.flett("IJKLMN", "OPQ");
        Oblig1.flett(s,t);
        assertEquals("AIDOBJEPCKFQGLHMN",Oblig1.flett(s,t));

        String ss = Oblig1.flett ("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        Oblig1.flett(s);
        assertEquals("ALGORITMER OG DATASTRUKTURER",Oblig1.flett(ss));
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }
}