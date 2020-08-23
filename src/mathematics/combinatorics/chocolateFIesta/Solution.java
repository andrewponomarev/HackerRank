package mathematics.combinatorics.chocolateFIesta;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 05.11.17.
 */
public class Solution {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++ ){
//            a[i] = scan.nextInt();
//        }
//        System.out.println(numOfEvenSubsets(a));
        for (int i = 0; i <= 33; i++) {
            System.out.println(C(33,i));
        }
    }

    private static long numOfEvenSubsets(int[] a) {
        int n_odd = 0;
        for (int aa : a) {
            if (aa % 2 == 1) {
                n_odd++;
            }
        }
        int n_even = a.length - n_odd;

        long numOfSubsets = (long)Math.pow(2, a.length) - 1;
        long numOfOddSubsets = 0;
        for (int i = 1; i <= n_odd; i = i + 2) {
            numOfOddSubsets += C(n_odd, i);
        }
        numOfOddSubsets *= Math.pow(2, n_even);
        return numOfSubsets - numOfOddSubsets;
    }

    /**
     * Факториал
     * @param n
     * @return
     */
    static long factorial(long n)
    {
        long f=1;
        for(long i=2;i<=n;++i)
            f=f*i;
        return f;
    }

    /**
     * Число сочетаний из n по k
     * @param n
     * @param k
     * @return
     */
    static long C(long n, long k)
    {
        double t = 1;
        k = (k  > n - k) ? n - k : k;
        for (int i = 1; i <= k ; i++) {
            t = t * (n - k + i) / i;
        }
        if ((long)t<= 0) {
            System.out.println("dddd");
        }
        return (long)t;
    }
}
