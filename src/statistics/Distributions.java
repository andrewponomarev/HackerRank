package statistics;

import static mathematics.Mathematics.C;
import static mathematics.Mathematics.factorial;
import static statistics.Statistics.round;

public class Distributions {

    /**
     * Функция вероятности для биномиального распределения b(x,n,p)
     * x - число успешных событий, вероятность которых p
     * n - число всех событий
     * @param lo - минимальное значение x
     * @param hi - максимальное значение x
     * @param n
     * @param p
     * @return
     */
    public static double binomial(int lo, int hi, int n, double p) {
        double answer = 0.0;
        for (int i = lo; i <= hi; i++) {
            answer += C(n, i) * Math.pow(p, i) * Math.pow(1-p, n-i);
        }
        return answer;
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
    public static double negativeBinomial(int x, int n, double p) {
        double answer = C(n-1, x-1) * Math.pow(p, x) * Math.pow(1-p, n-x);
        return answer;
    }

    /**
     * Геометрическое распределение
     * Число неудач до первого успеха
     * @param n
     * @param p
     * @return
     */
    public static double geometric(int n, int p) {
        return negativeBinomial(1, n, p);
    }

    /**
     * РАспределение Пуассона
     * Вероятность, что случится ровно k успехов
     * при условии, что в среднем случается lambda
     */
    public static double poison(int k, double lambda) {
        return Math.pow(lambda, k) * Math.exp(-lambda)/(double)factorial(k);
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
