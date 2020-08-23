package statistics.distributions.binomial;

public class Solution {

    public static void main(String[] args) {
        System.out.println(binomial(0, 2, 10, 0.12));
        System.out.println(binomial(2, 10, 10, 0.12));
    }

    private static double binomial(int lo, int hi, int n, double p) {
        double answer = 0.0;
        for (int i = lo; i <= hi; i++) {
            answer += C(n, i) * Math.pow(p, i) * Math.pow(1-p, n-i);
        }
        return round(answer,3);
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
