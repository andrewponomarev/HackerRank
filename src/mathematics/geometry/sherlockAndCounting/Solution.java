package mathematics.geometry.sherlockAndCounting;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            System.out.println(countI(n,k));
        }
    }

    static int countI(int n, int k) {
        double d = Math.pow(n, 2) - 4 * n * k;
        if (d < 0) return n - 1;
        double x2 = (n + Math.sqrt(d)) / 2;
        double x1 = (n - Math.sqrt(d)) / 2;
        int i0 = (int)Math.ceil(x2);
        int count = 0;

        for (int i = 1; i < x1; i++) {
            count++;
        }
        for (int i = i0; i < n; i++) {
            count++;
        }

        return count;
    }
}
