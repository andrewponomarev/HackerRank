package statistics.weighted_mean;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] xs = new int[n];
        int[] ws = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ws[i] = scan.nextInt();
        }
        System.out.println(weightedMean(xs, ws, n));
    }

    private static double weightedMean(int[] xs, int[] ws, int n) {
        double result = 0;
        int wSum = 0;
        for (int i = 0; i < n; i++) {
            result += ws[i]*xs[i];
            wSum += ws[i];
        }
        return round(result/wSum, 1);
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
