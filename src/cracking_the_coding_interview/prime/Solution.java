package cracking_the_coding_interview.prime;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int[] arr = new int[p];
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            arr[a0] = n;
        }
        for (int i = 0; i < p; i++) {
            String answer = isPrime(arr[i]) ? "Prime" : "Not prime";
            System.out.println(answer);
        }
    }

    public static boolean isPrime(long n) {
        if (n == 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
