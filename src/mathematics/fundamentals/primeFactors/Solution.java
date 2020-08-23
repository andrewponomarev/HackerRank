package mathematics.fundamentals.primeFactors;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextLong();
        }
        for (long num : nums) {
            System.out.println(primeFactors(num));
        }

    }

    private static int primeFactors(long n) {
        long product = 1;
        int answer = 0;
        for (int i = 0; i < primes.length; i++) {
            product *= primes[i];
            if (product <= n) {
                answer++;
            }
        }
        return answer;
    }
}
