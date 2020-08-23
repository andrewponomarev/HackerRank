package statistics.spearman;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++){
            x[i] = scan.nextDouble();
        }
        for (int i = 0; i < n; i++){
            y[i] = scan.nextDouble();
        }
        System.out.printf("%.3f", spearman(x,y,n));
    }

    /**
     * Ранговая корреляция Спирмана
     *
     */
    public static double spearman(double[] x, double[] y, int n) {
        if (n != x.length || n != y.length) {
            throw new IllegalArgumentException("dsad");
        }
        double[] sortedX = Arrays.copyOf(x, n);
        double[] sortedY = Arrays.copyOf(y, n);

        Arrays.sort(sortedX);
        Arrays.sort(sortedY);

        int[] rX = new int[n];
        int[] rY = new int[n];

        for (int i = 0; i < n; i++) {
            rX[i] = Arrays.binarySearch(sortedX, x[i]);
            rY[i] = Arrays.binarySearch(sortedY, y[i]);
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = rX[i] - rY[i];
        }

        double sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += d[i]*d[i];
        }
        return 1 - 6 * sumD / ( n * ( n * n - 1));
    }
}
