package mathematics.numberTheory.lcm;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 04.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scan.nextInt();
            }
            long[] b = b(a);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n + 1; j++) {
                sb.append(b[j]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static long[] b(int[] a) {
        long[] b = new long[a.length + 1];
        b[0] = a[0];
        for ( int i = 0; i < b.length - 2; i++) {
            b[i + 1] = lcm(a[i], a[i+1]);
        }
        b[b.length - 1] = a[a.length - 1];
        return b;
    }

    public static long gcd(long a, long b) {
        return b==0 ? Math.abs(a) : gcd(b, a%b);
    }

    /**
     * Наименьшее общее кратное
     * Наименьшее число, которое делится и на a, и на b
     */
    public static long lcm(long a, long b) {
        return Math.abs(a*b)/gcd(a,b);
    }
}
