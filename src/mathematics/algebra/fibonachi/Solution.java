package mathematics.algebra.fibonachi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 06.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        long[] n = new long[t];
        for (int i = 0; i < t; i++) {
            n[i] = scan.nextLong();
        }
        long m = max(n);
        List<Long> sequence = gameSequence(m);
        for (int i = 0; i < t; i++) {
            if (sequence.contains(n[i])) {
                System.out.println("Go On Bob " + steps(n[i]));
            } else {
                System.out.println("Better Luck Next Time");
            }
        }
    }

    private static List<Long> gameSequence(long n) {
        long num = 1;
        long i = 2;
        List<Long> sequence = new ArrayList<Long>();
        while(num <= n) {
            sequence.add(num);
            num = num + i;
            i++;
        }
        return sequence;
    }

    private static long steps(long s) {
        return (long)((Math.sqrt(8*s + 1) - 1) / 2);
    }


    public static long max(long[] array) {

        long maximum = array[0];

        for (int i = 0; i < array.length; i++)
            if (maximum < array[i]) maximum = array[i];

        return maximum;
    }
}
