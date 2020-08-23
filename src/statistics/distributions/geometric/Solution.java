package statistics.distributions.geometric;

import static mathematics.Mathematics.C;
import static statistics.Statistics.round;

public class Solution {


    public static void main(String[] args) {
        double p = 1/3.0;
        double answer = 0.0;

        for (int i = 1; i <= 5; i++) {
            answer += geometric(i, p);
        }

        System.out.println(round(answer, 3));
    }
    /**
     * Отрицательное биномиальное распределение
     * Число неудач в посследовательности испытпний бернули
     * с вероятностью успеха p, проводимой до x-го успеха
     * @param x
     * @param n
     * @param p
     * @return
     */
    private static double negativeBinomial(int x, int n, double p) {
        double answer = C(n-1, x-1) * Math.pow(p, x) * Math.pow(1-p, n-x);
        return round(answer,3);
    }

    /**
     * Геометрическое распределение
     * Число неудач до первого успеха
     * @param n
     * @param p
     * @return
     */
    private static double geometric(int n, double p) {
        return negativeBinomial(1, n, p);
    }

    /**
     * Факториал
     * @param n
     * @return
     */
    static int factorial(int n)
    {
        int f=1;
        for(int i=2;i<=n;++i)
            f=f*i;
        return f;
    }

    /**
     * Число сочетаний из n по k
     * @param n
     * @param k
     * @return
     */
    static int C(int n, int k)
    {
        return factorial(n)/factorial(k)/factorial(n-k);
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }

}
