package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class  Oblig1 {
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
       // if (s.equals("")|| t.equals("")){

        //    throw new UnsupportedOperationException("Tabellen er tom");
       // }

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
       // if (s.equals(" ")) {
         //   throw new UnsupportedOperationException("Tablen er tom");
      // }
        if(s.length == 0){
            return "";
        }
        int maks = s[0].length();
        for (int i = 1; i < s.length; i++) {
            if (s.length > maks) {
                maks = s.length;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= maks+1; i++) {
            for (String b : s) {
                if (b.length() > i) {
                    str.append(b.charAt(i));
                }
            }
        }
        return str.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int [] indeksliste = new int[a.length];
        int [] acopy = Arrays.copyOf(a,a.length);
        for (int i =0; i< acopy.length; i++){
            int indek = i;
            int minverdi = acopy[i];
            for (int j = i+1; j<acopy.length;j++){
                if (acopy[j]< minverdi){
                    indek =j;
                    minverdi = acopy[j];
                }
            }
            int temp = acopy[i];
            acopy[i]=acopy[indek];
            acopy[indek] = temp;
        }
        for (int i = 0;i< a.length; i++){
            int verdi = a[i];
            for (int j= 0;j< acopy.length;j++){
                if (acopy[j]==verdi){
                    indeksliste[j]=i;
                }
            }
        }
        return indeksliste;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {

        int n = a.length;
        if (n < 3)
        {
            throw new NoSuchElementException("Tabellen må ha minst tre elementer");

        }
        int [] index = indekssortering(new int[] {a[0], a[1], a[2]});

        int m = index[0];
        int nm = index[1];
        int tm = index[2];

        int minverdi = a[m];
        int nestminverdi = a[nm];
        int tredjeminverdi = a[tm];

        for (int i = 3; i < a.length; i++)
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
                    else
                    {
                        tm = nm;
                        tredjeminverdi = nestminverdi;

                        nm = i;
                        nestminverdi = verdi;
                    }
                }
                else
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
