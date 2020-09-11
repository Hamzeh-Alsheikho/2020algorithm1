package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Oblig1 {
    public static void main(String[] args) {
    }

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1)
            throw new NoSuchElementException("Tabellen a er tom!");
        for (int i = 0; i < a.length - 1; i++) {
            int left = a[i];
            int right = a[i + 1];
            if (left > right) {
                a[i + 1] = left;
                a[i] = right;
            }
        }
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        if (a.length < 1)
            throw new UnsupportedOperationException("Tabellen a er tom!");
        int teller = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                teller++;
            } else {
            }
            System.out.print(a[0]);
            for (int j = 1; j < a.length; j++) {
                System.out.print(", " + a[j]);
            }
            System.out.println();
            System.out.println(teller);
        }
        return teller;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {

        int antall = 1;

        if (a.length == 0)
            return antall = 0;

        if (a.length == 1)
            return antall;

        for (int i = 0; i < a.length - 1; i++)
            if (a[i] > a[i + 1])
                throw new IllegalStateException("Array er ikke sortert!");

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] != a[i + 1])
                antall++;
        }
        return antall;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int forskjell = 1;
        if (a.length == 0)
            return 0;
        if (a.length == 1)
            return forskjell;
        if (a[0] == a[1])
            return forskjell;
        int duplicate = 0;
        int totall = a.length;
        int count = 1;
        if (a[0] > a[1]) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]){
                        duplicate++;
                        break;
                    }
                }
            }
            return totall - duplicate;
        } else{
            for (int t = 0; t < a.length -1; t++) {
                if (a[t] != a[t + 1])
                    count++;
            }
        }
        return count;
    }
    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {


        segregateEvenOdd(a);
        odd(a, 0);
        even(a);

    }

    public static void segregateEvenOdd(int a[]) {
        if (a == null || a.length == 0) {
            return;
        }

        if (a.length == 1) {
            return;
        }

        /* Initialize left and right indexes */
        int left = 0, right = a.length - 1;
        while (left < right) {
            /* Increment left index while we see 0 at left */
            while (a[left] % 2 != 0 && left < right)
                left++;

            /* Decrement right index while we see 1 at right */
            while (a[right] % 2 == 0 && left < right)
                right--;

            if (left < right) {
                /* Swap arr[left] and arr[right]*/
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void recursiveQuickSort(int[] a, int start, int end) {

        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;
        int pivot = a[middle];

        int i = start, j = end;

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int swapTemp = a[i];
                a[i] = a[j];
                a[j] = swapTemp;
                i++;
                j--;
            }
        }

        if (start < j) {
            recursiveQuickSort(a, start, j);
        }

        if (end > i) {
            recursiveQuickSort(a, i, end);
        }

    }

    public static void odd(int[] a, int start) {
        if (a.length == 0) {
            return;
        }

        if (start > a.length) {
            return;
        }

        if (a.length == 1)
            return;


        int oddTall = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0)
                oddTall++;
        }

        if (oddTall == 0)
            return;


        // pick the pivot
        int end = oddTall - 1;
        int middle = start + (end - start) / 2;
        int pivot = a[middle];

        // make left < pivot and right > pivot
        int i = start, j = oddTall - 1;

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (start < j)
            recursiveQuickSort(a, start, j);

        if (oddTall - 1 > i)
            recursiveQuickSort(a, i, oddTall - 1);
    }

    public static void even(int[] a) {

        int evenTall = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0)
                evenTall++;
        }

        if (evenTall == 0)
            return;


        int oddTall = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0)
                oddTall++;
        }

        int end = a.length - 1;
        int middle = oddTall + (end - oddTall) / 2;
        int pivot = a[middle];


        int m = oddTall, j = a.length - 1;

        while (m <= j) {
            while (a[m] < pivot) {
                m++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (m <= j) {
                int swapTemp = a[m];
                a[m] = a[j];
                a[j] = swapTemp;
                m++;
                j--;
            }
        }

        if (oddTall < j)
            recursiveQuickSort(a, oddTall, j);

        if (a.length - 1 > m)
            recursiveQuickSort(a, m, a.length - 1);
    }


    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
//throw new UnsupportedOperationException();
        rotasjon1(a, 1);
    }

    public static void rotasjon1(char[] a, int d) {
//throw new UnsupportedOperationException();
        int n = a.length;
        if (n < 2) return;
        if ((d %= n) < 0) d += n;
        char[] b = Arrays.copyOfRange(a, n - d, n);
        for (int i = n - 1; i >= d; i--)
            a[i] = a[i - d];
        System.arraycopy(b, 0, a, 0, d);
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (n < 2) return;
        if ((k %= n) < 0) k += n;
        int s = gcd(n, k);
        for (int l = 0; l < s; l++) {
            char verdi = a[l];
            for (int i = l - k, j = l; i != l; i -= k) {
                if (i < 0) i += n;
                a[j] = a[i];
                j = i;
            }
            a[l + k] = verdi;
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        if (s.equals("")|| t.equals("")){

            throw new UnsupportedOperationException("Tabellen er tom");
        }

        int k = Math.min(s.length(), t.length());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k; i++) {
            str.append(s.charAt(i)).append(t.charAt(i));
        }
        str.append(s.substring(k)).append(t.substring(k));


        return str.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        if (s.equals("")) {
            throw new UnsupportedOperationException("Tablen er tom");
        }

        int maks = s[0].length();
        for (int i = 1; i < s.length; i++) {
            if (s.length > maks) {
                maks = s.length;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < maks; i++) {
            for (String a : s) {
                if (a.length() > i) {
                    str.append(a.charAt(i));
                }
            }
        }
        return str.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        

        throw new UnsupportedOperationException();
        //Firste versjon
        /* int[] indeks = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] elementer = new int[a.length];
        int min = a[indeks[0]];
        int ind = 0;
        int i;
        for (i = 1; i < a.length - 1; ++i) {
            //     ind = indeks[i];
            if (min > a[indeks[i]]) {

                min = a[indeks[i]];

                System.out.print(a[indeks[i]] + " ");

            }


             System.out.print(min+ " ");

        }


        return elementer;


    }*/

        //andre versjon
    /*    public static int[] tredjeMin(int[]a) {


            int n = a.length;     // tabellens lengde

            if (n < 10)     // må ha minst tre verdier
            {
                throw new IllegalArgumentException("Lengden til tabellen(" + n + ") er < 10!");
            }

            int m = 0;     // m er posisjonen til minst verdi
            int nm = 1;    // nm er posisjonen til nest minst verdi
            int tm = 2;    // tm er posisjonen til tredje minst verdi
            int fjerde = 3;
            int femte = 4;
            int sjette = 5;
            int syvende = 6;
            int ottende = 7;
            int niende = 8;
            int tiende = 9;

            // vi bytter om slik at når vi starter er m posisjonen til
            // den minste av de tre første, nm er posisjonen til den nest
            // minste og tm posisjonen til den tredje minste av de tre første

            if (a[nm] > a[m]) {
                m = 0;
                nm = 1;
            }

            if (a[tm] < a[m])   //hvis tredje minst er mindre en minst
            {
                int temp = tm;  //legger verdien til tredjeminst over temporary variabel
                tm = m;         //tredje minst flytes til minst plassen
                m = temp;        // minst blir temporary
            }

            if (a[tm] < a[nm])  //hvis tredje minst er mindre enn nest minst
            {
                int temp = tm;   //tredje minst legges over til temp
                tm = nm;         // så tredjeminst tar plassen til nest minst
                nm = temp;
            }
            if (a[fjerde] < a[tm]) {
                int temp = fjerde;
                fjerde = temp;
            }
            if (a[femte] < a[fjerde]) {
                int temp = femte;
                femte = temp;
            }


            int minverdi = a[m];                // minste verdi
            int nestminverdi = a[nm];           // nest minste verdi
            int tredjeminverdi = a[tm];         // tredje minste verdi
            int fjerdeminverdi = a[fjerde];
            int femteminverdi = a[femte];
            for (int i = 3; i < n; i++) {
                int verdi = a[i];
                if (verdi < fjerdeminverdi) {

                    if (verdi < tredjeminverdi) {
                        if (verdi < nestminverdi) {
                            if (verdi < minverdi) {

                                fjerde = tm;
                                fjerdeminverdi = tredjeminverdi;

                                tm = nm;
                                tredjeminverdi = nestminverdi;

                                nm = m;
                                nestminverdi = minverdi;

                                m = i;
                                minverdi = verdi;
                            } else  // verdi <= minverdi && verdi > nestminverdi
                            {
                                fjerde=tm;
                                fjerdeminverdi=tredjeminverdi;

                                tm = nm;
                                tredjeminverdi = nestminverdi;

                                nm = i;
                                nestminverdi = verdi;
                            }
                        } else // verdi <= nestmaksverdi && verdi > tredjemaksverdi

                        {
                            tm = i;
                            tredjeminverdi = verdi;
                            fjerde=i;
                            femteminverdi= verdi;
                        }
                        {

                        }
                    }
                }
            } // for

            return new int[]{m, nm, tm, fjerde};

        }

    }

}*/
        //Tredje versjon

        /*private int[] indekssortering(int[] a) {
        public static int maks(int[] a, int fra, int til)
        {
            if (fra < 0 || til > a.length || fra >= til)
            {
                throw new IllegalArgumentException("Illegalt intervall!");
            }

            int m = fra;              // indeks til største verdi i a[fra:til>
            int maksverdi = a[fra];   // største verdi i a[fra:til>

            for (int i = fra + 1; i < til; i++)
            {
                if (a[i] > maksverdi)
                {
                    m = i;                // indeks til største verdi oppdateres
                    maksverdi = a[m];     // største verdi oppdateres
                }
            }

            return m;  // posisjonen til største verdi i a[fra:til>
            public static int[] nestMaks(int[] a)
            {
                int n = a.length;   // tabellens lengde

                if (n < 2) throw   // må ha minst to verdier!
                        new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

                int m = maks(a);  // m er posisjonen til tabellens største verdi

                int nm;           // nm skal inneholde posisjonen til nest største verdi

                if (m == 0)                            // den største ligger først
                {
                    nm = maks(a, 1, n);                  // leter i a[1:n>
                }
                else if (m == n - 1)                   // den største ligger bakerst
                {
                    nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
                }
                else
                {
                    int mv = maks(a, 0, m);              // leter i a[0:m>
                    int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
                    nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
                }

                return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

            }

    }*/
        //Fjerde versjon
        /*  int[] indeks1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] elementer = new int[a.length];
        int[] acopy = Arrays.copyOf(a, a.length);
        int min = a[indeks1[0]];
        int ind = 0;
        int i;

        for (i = 1; i < a.length - 1; ++i) {
         ind = indeks1[i];
         for(int j = 0; j < indeks1.length; j++) {
            if (min > a[indeks1[j]]) {

                min = a[indeks1[j]];

                System.out.print(a[indeks1[i]] + " ");
            }

            System.out.print(min + " ");

        }

        return elementer;

    }*/
        //Femte versjon
        /*  int[] indeks1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] elementer = new int[a.length];
        int[] acopy = Arrays.copyOf(a, a.length);
        int min = a[indeks1[0]];
        int ind = 0;
        int i;

        for (i = 1; i < a.length - 1; ++i) {
         ind = indeks1[i];
         for(int j = 0; j < indeks1.length; j++) {
            if (min > a[indeks1[j]]) {

                min = a[indeks1[j]];

                System.out.print(a[indeks1[i]] + " ");
            }

            System.out.print(min + " ");

        }

        return elementer;

    }*/
        //Sjette versjon
        /*public static int maks(int[] a, int[] indeks,int begin, int end)
    {

        if (begin < 0 || end > a.length || begin >= end)

        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = begin;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[begin];   // største verdi i a[fra:til>

        for (int i = begin + 1; i < end; i++)
        {
            if (a[indeks[i]] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[indeks[m]];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>

}
*/
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
       // throw new UnsupportedOperationException();

        int n = a.length;     // tabellens lengde

        if (n < 3)     // må ha minst tre verdier
        {
            throw new IllegalArgumentException("Lengden til tabellen(" + n + ") er < 3!");
        }

        int m = 0;     // m er posisjonen til minst verdi
        int nm = 1;    // nm er posisjonen til nest minst verdi
        int tm = 2;    // tm er posisjonen til tredje minst verdi

        // vi bytter om slik at når vi starter er m posisjonen til
        // den minste av de tre første, nm er posisjonen til den nest
        // minste og tm posisjonen til den tredje minste av de tre første

        if (a[nm] > a[m])
        {
            m = 0;
            nm = 1;
        }

        if (a[tm] < a[m])   //hvis tredje minst er mindre en minst
        {
            int temp = tm;  //legger verdien til tredjeminst over temporary variabel
            tm = m;         //tredje minst flytes til minst plassen
            m = temp;        // minst blir temporary
        }

        if (a[tm] < a[nm])  //hvis tredje minst er mindre enn nest minst
        {
            int temp = tm;   //tredje minst legges over til temp
            tm = nm;         // så tredjeminst tar plassen til nest minst
            nm = temp;
        }

        int minverdi = a[m];                // minste verdi
        int nestminverdi = a[nm];           // nest minste verdi
        int tredjeminverdi = a[tm];         // tredje minste verdi

        for (int i = 3; i < n; i++)
        {
            int verdi = a[i];

            if (verdi < tredjeminverdi)
            {
                if (verdi < nestminverdi)
                {
                    if (verdi < minverdi)
                    {
                        tm = nm;
                        tredjeminverdi = nestminverdi;

                        nm = m;
                        nestminverdi = minverdi;

                        m = i;
                        minverdi = verdi;
                    }
                    else  // verdi <= minverdi && verdi > nestminverdi
                    {
                        tm = nm;
                        tredjeminverdi = nestminverdi;

                        nm = i;
                        nestminverdi = verdi;
                    }
                }
                else // verdi >= nestminverdi && verdi < tredjeminverdi
                {
                    tm = i;
                    tredjeminverdi = verdi;
                }
            }

        }

        return new int[]{m, nm, tm};

    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        return Character.getNumericValue(bokstav);
    }


    public static boolean inneholdt(String a, String b) {


        if (a == null || b == null) return false;

        if (a.length() >= 1 && b.length() == 0) return false;
        if (a.length() == 0 && b.length() >= 1) return true;

        int[] aArray = new int[256];
        int[] bArray = new int[256];

        for (int i = 0; i < a.length(); i++) {
            char chA = a.charAt(i);
            int chIndexA = (int) chA - 'A';
            if (chIndexA >= 0 && chIndexA < 256)
                aArray[chIndexA]++;
        }

        for (int j = 0; j < b.length(); j++) {
            char chB = b.charAt(j);
            int chIndexB = (int) chB - 'A';
            if (chIndexB >= 0 && chIndexB < 256)
                bArray[chIndexB]++;
        }


        for (int k = 0; k < aArray.length; k++) {
            if (aArray[k] > bArray[k])
                return false;

        }
        return true;
    }

}
