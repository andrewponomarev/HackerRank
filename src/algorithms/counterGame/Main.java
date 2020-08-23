package algorithms.counterGame;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 01.11.17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int t = scan.nextInt();
        for (int i = 0; i < t; i++){
            boolean isLoiseStep = true;
            long n = scan.nextLong();
            while ( n > 1) {
                long p2 = 1;
                while (p2 * 2 < n && p2 * 2 > 0) {
                    p2 *= 2;
                }
                isLoiseStep = !isLoiseStep;
                n -= p2;
            }
            sb.append(isLoiseStep ? "Richard" : "Louise");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}
