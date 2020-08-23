package dataStructure.stacks.gameOfTwoStacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            System.out.println(a0 + "   " + gameOfTwoStacks(a, b, n, m, x));
        }
    }

    private static int gameOfTwoStacks(int[] a, int[] b, int n, int m, int x) {
        int sum = 0;
        int count = 0;
        int i = 0;
        int j = 0;

        while(i < n && sum + a[i] <= x) {
            sum += a[i++];
            count++;
        }

        while(j < m && i >= 0) {
            sum += b[j++];
            while (sum > x && i > 0) {
                sum -= a[--i];
            }
            if (sum <= x && count < i + j) {
                count = i + j;
            }
        }
        return count;
    }
}


