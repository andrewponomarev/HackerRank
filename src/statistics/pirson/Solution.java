package statistics.pirson;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++){
            x[i] = scan.nextDouble();
        }
        for (int i = 0; i < n; i++){
            y[i] = scan.nextDouble();
        }
        System.out.printf("%.3f", pirson(x,y,n));
    }

    private static double std(double[] nums) {
        double mean = mean(nums);
        float sum = 0;
        for (double n : nums) {
            sum += (n - mean)*(n - mean);
        }
        return Math.sqrt(sum/nums.length);
    }

    /**
     * Корреляция Пирсона
     *
     * ro_xy = cov(x,y)/(sigma_x*sigma_y)
     */
    public static double pirson(double[] x, double[] y, int n) {
        if (n != x.length || n != y.length) {
            throw new IllegalArgumentException("dsad");
        }
        double std_x = std(x);
        double std_y = std(y);
        return cov(x,y,n)/(std_x * std_y);
    }

    /**
     * Ковариация
     *
     * cov(x,y) = 1/n * sum( (x_i - x_mean) / (y_i - y_mean))
     *
     */
    public static double cov(double[] x, double[] y, int n) {
        if (n != x.length || n != y.length) {
            throw new IllegalArgumentException("dsad");
        }
        double sum = 0;
        double x_mean = mean(x);
        double y_mean = mean(y);
        for (int i = 0; i < n; i++) {
            sum += (x[i] - x_mean) * (y[i] - y_mean);
        }
        return sum/n;
    }

    public static double mean(double[] nums) {
        double sum = 0;
        for (double n : nums) {
            sum += n;
        }
        return sum/nums.length;
    }
}
