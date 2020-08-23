package mathematics.numberTheory.eulerCriterion;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 04.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            long a = scan.nextLong();
            long m = scan.nextLong();
            System.out.println(eulerCriterion(a, m) ? "YES" : "NO");
        }
    }

    private static boolean eulerCriterion(long a, long m) {
        if (a == 0 || m == 2) {
            return true;
        }
        if (m % 2 == 0) {
            return false;
        }
        if (Math.pow(a, (m-1)/2) % m == 1) {
            return true;
        }
        return false;
    }
}
