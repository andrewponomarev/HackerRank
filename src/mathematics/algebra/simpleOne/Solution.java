package mathematics.algebra.simpleOne;

import sun.tools.java.ScannerInputReader;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 06.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int p = scan.nextInt();
            int q = scan.nextInt();
            int n = scan.nextInt();
            System.out.println(tan(n, p/(double)q));
        }
    }

    /**
     * Вычисляем tan(a+b)
     * @param t = tan(a)
     * @param u = tan(b)
     * @return tan(a+b)
     */
    private static double tanAdd(double t,double u) {
        return (t + u)/ (1 - t*u);
    }

    /**
     * Вычисляем tan(n*a)
     * @param n = n
     * @param t = tan(a)
     * @return tan(n*a)
     */
    private static double tan(int n, double t) {
        if (n == 1) {
            return t;
        } else if (n % 2 == 0) {
            double result = tan(n/2, t);
            return tanAdd(result, result);
        } else {
            double result = tan( n-1, t);
            return tanAdd(result, t);
        }
    }

}
