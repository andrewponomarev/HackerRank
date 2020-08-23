package algorithms.implementation.nextPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 07.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();

        String[] s = null;
        int t = 0;

        try {
            String ts = in.readLine();
            t = Integer.parseInt(ts);
            s = new String[t];
            for (int i = 0; i < t; i++) {
                s[i] = in.readLine();
            }
            /*scan.nextLine();
            for (int i = 0; i < t; i++) {
                s[i] = scan.nextLine();
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < t; i++) {
            char[] answer = nextPermutation(s[i].toCharArray());
            if (answer == null) {
                System.out.println("no answer");
            } else {
                System.out.println(new String(answer));
            }
        }
    }

    private static char[] nextPermutation(final char[] c){
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst(c);
        if (first == -1) {
            return null;
        }
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = getLast(c, first);
        // 3. Swap elements with indexes first and last
        swap(c, first++, toSwap);
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.length - 1;
        while (first < toSwap) {
            swap(c, first++ , toSwap--);
        }
        return c;
    }


    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    private static int getFirst( final char[] c ) {
        for ( int i = c.length - 2; i >= 0; --i )
            if ( c[i] < c[i + 1] )
                return i;
        return -1;
    }

    private static int getLast(final char[] c, int first) {
        int toSwap = c.length - 1;
        while ( c[first] > c[toSwap]) {
            --toSwap;
        }
        return toSwap;
    }

    // swaps two elements (with indexes i and j) in array
    private static void swap( final char[] c, final int i, final int j ) {
        final char tmp = c[ i ];
        c[ i ] = c[ j ];
        c[ j ] = tmp;
    }
}
