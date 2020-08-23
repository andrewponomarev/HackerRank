package mathematics.algebra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 06.11.17.
 */
public class Vika {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int A = Math.min(a,b);
        int B = Math.max(a,b);
        List<Integer> F = F(n, A, B);
        if (F.isEmpty()) {
            System.out.print(-1);
        }
        else {
            for (Integer f : F) {
                System.out.print(f + " ");
            }
        }
    }

    /**
     * Последовательность F_i(n)
     * образуют числа f_i(n) = i(!^n)
     * где A <= f_i(n) <= B
     * @param n
     * @return
     */
    private static List<Integer> F(int n, int A, int B) {
        List<Integer> F = new ArrayList<Integer>();
        int fact = 1;
        int i = 0;
        while (true) {
            fact = n_factorial(i, n);
            if (fact > B) {
                break;
            }
            if (fact >= A) {
                F.add(fact);
            }
            i++;
        }
        return F;
    }


    /**
     * Вычисление n-кратного факториала
     * m(!^n) = ( n * p - r) * (n * (p-1) - r) ... (n-r)
     * для m = n * p - r
     * 0(!^n) = 1
     * @param m
     * @param n
     * @return
     */
    private static int n_factorial(int m, int n) {
        int p = m / n + 1;
        int r = n * p - m;

        int fact = 1;
        while ( p > 0 ) {
            fact *= n * p - r;
            p--;
        }
        return fact;
    }
}
