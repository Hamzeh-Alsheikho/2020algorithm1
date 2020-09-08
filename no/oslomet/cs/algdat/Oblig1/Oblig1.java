package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Oblig1 {
    public static void main(String[] args) {
       /* int[]a ={8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        int verdi = maks(a);
        System.out.println("Det største tallet i tabllen er: "+ verdi);
        ombyttinger(a);
        antallUlikeUsortert(a);
        System.out.println("Antall forskjellige elmenter er: "+antallUlikeUsortert(a));
        String s  =flett("ABC","DEFGH");
        String t  = flett ("IJKLMN","OPQ");
        flett(s,t);
        System.out.println(flett(s,t));
        String s = flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        System.out.println(flett(s));
        */
    }
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1)
        throw new NoSuchElementException("Tabellen a er tom!");
        for (int i = 0; i < a.length -1; i++) {
            int left = a[i];
            int right = a[i + 1];
            if (left > right) {
                a[i+1] = left;
                a[i] = right;
            }
        }
        return a[a.length -1 ];
    }
    public static int ombyttinger(int[] a) {
        if (a.length < 1)
            throw new UnsupportedOperationException("Tabellen a er tom!");
        int teller= 0;
        for (int i= 0; i< a.length-1; i++){
            if (a[i]> a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1]= temp;
                teller++;
            }else {
            }
                System.out.print(a[0]);
            for (int j = 1; j< a.length; j++){
                System.out.print(", "+a[j]);
            }
           System.out.println();
            System.out.println(teller);
        }return teller;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
       // if (a.length <= 0)
         //  throw new IllegalArgumentException("Antall forskjellige elmenter er: 0");
        int forskjellig = 1;
        for (int i = 0;i< a.length-1;i++){
            int left = a[i];
            int right = a[i + 1];
            if (left > right) {
                a[i + 1] = left;
                a[i] = right;
            }
            if (a[i]!=a[i+1])
                forskjellig++;
        }return forskjellig;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

    }
    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        /*if (s.equals("")|| t.equals(""))
            throw new IllegalArgumentException("Tabellen er tom");
         */
        int k = Math.min(s.length(), t.length());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k; i++)
        {
            str.append(s.charAt(i)).append(t.charAt(i));
        }
            str.append(s.substring(k)).append(t.substring(k));


        return str.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        if (s.equals("")){
            throw new UnsupportedOperationException("Tablen er tom");
        }
        int maks = s[0].length();
        int index =0;
        for (int i =1;i< s.length;i++){
            if (s.length>maks){
                maks = s.length;
                index =i;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < maks; i++) {
            for(String a : s) {
                if(a.length() > i) {
                    str.append(a.charAt(i));
                }
            }
        }
        return str.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}
