package statistics.centralLimitTheorem;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        double ticketsLeft = 250;
        int    n           = 100;
        double mean        = 2.4;
        double std         = 2;

        System.out.printf("%.4f", cumulative(ticketsLeft, mean, std, n));
    }


    /**
     * Комулятивная функция распределения
     */
    public static double cumulative(double x, double mean, double std, int n) {
        return normal(x, mean * n, std * Math.sqrt(n));
    }

    /**
     * Нормальное распрееделение
     * @param x
     * @param mean
     * @param sdev
     * @return
     */
    public static double normal(double x, double mean, double sdev) {
        return .5*(1 + erf((x - mean) / (sdev * Math.sqrt(2))));

    }

    /**
     * Функция ошибки
     * @param z
     * @return
     */
    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                t * ( 1.00002368 +
                        t * ( 0.37409196 +
                                t * ( 0.09678418 +
                                        t * (-0.18628806 +
                                                t * ( 0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * ( 1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
    }
}
