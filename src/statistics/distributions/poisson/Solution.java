package statistics.distributions.poisson;



public class Solution {

    public static void main(String[] args) {
        System.out.println(round(160 + 40*(0.88 + 0.88 * 0.88), 3));
        System.out.println(round(128 + 40*(1.55 + 1.55 * 1.55), 3));
    }

    /**
     * РАспределение Пуассона
     * Вероятность, что случится ровно k успехов
     * при условии, что в среднем случается lambda
     */
    public static double poison(int k, double lambda) {
        return Math.pow(lambda, k) * Math.exp(-lambda)/(double)factorial(k);
    }

    public static int factorial(int n)
    {
        int f=1;
        for(int i=2;i<=n;++i)
            f=f*i;
        return f;
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
