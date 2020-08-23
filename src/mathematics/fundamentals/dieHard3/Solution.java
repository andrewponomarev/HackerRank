package mathematics.fundamentals.dieHard3;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 03.11.17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            boolean answer = dieHard(a, b, c);
            System.out.println(answer ? "YES" : "NO");
        }
    }

    private static boolean dieHard(int a, int b, int c) {
        long d = gcd(a,b);
        if (c > Math.max(a,b)) {
            return false;
        }
        if (c % d == 0) {
            return true;
        }
        return false;
    }

    public static long gcd(long a, long b) {
        return b==0 ? Math.abs(a) : gcd(b, a%b);
    }
}
