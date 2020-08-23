package statistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 03.11.17.
 */
public class Statistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] x = new double[]{95,85,80,70,60};
        double[] y = new double[]{85,95,70,65,70};
        System.out.printf("%.3f",regressionYwithValueX(x,y,80));
    }

    public static double mean(double[] nums) {
        double sum = 0;
        for (double n : nums) {
            sum += n;
        }
        return sum/nums.length;
    }

    public static float median(Integer[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 1) {
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2] + nums[nums.length/2 - 1]) / 2;
        }
    }

    public static int mode(Integer[] nums) {
        Arrays.sort(nums, Collections.reverseOrder());
        int count = 1;
        int max_count = 0;
        float prev_num = 0;
        float mode = 0;

        for (float num : nums) {
            if (num == prev_num) {
                count++;
            } else {
                if (count > max_count) {
                    max_count = count;
                    mode = prev_num;
                }
                prev_num = num;
            }
        }
        return (int)(mode == 0 ? nums[nums.length] : mode);
    }

    public static double weightedMean(int[] xs, int[] ws, int n) {
        double result = 0;
        int wSum = 0;
        for (int i = 0; i < n; i++) {
            result += ws[i]*xs[i];
            wSum += ws[i];
        }
        return round(result/wSum, 1);
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }

    private static double[] quartiles(Integer[] nums) {
        double[] q = new double[3];
        q[1] = median(nums);
        int halfLength = nums.length / 2;
        int startOf2 =  nums.length % 2 == 0 ? halfLength  : halfLength + 1;
        Integer[] nums1 = new Integer[halfLength];
        Integer[] nums2 = new Integer[halfLength];

        System.arraycopy(nums, 0, nums1,0, halfLength);
        System.arraycopy(nums, startOf2, nums2,0, halfLength);

        q[0] = median(nums1);
        q[2] = median(nums2);

        return q;
    }

    private static double interQuartileRange(Integer[] x, Integer[] f, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += f[i];
        }
        Integer[] s = new Integer[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < f[i]; t++){
                s[j+t] = x[i];
            }
            j += f[i];
        }
        double[] q = quartiles(s);
        return q[2] - q[0];
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
    public static double pearson(double[] x, double[] y, int n) {
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

    /**
     * Ранговая корреляция Спирмана
     *
     */
    public static double spearman(double[] x, double[] y, int n) {
        if (n != x.length || n != y.length) {
            throw new IllegalArgumentException("dsad");
        }
        double[] sortedX = Arrays.copyOf(x, n);
        double[] sortedY = Arrays.copyOf(y, n);

        Arrays.sort(sortedX);
        Arrays.sort(sortedY);

        int[] rX = new int[n];
        int[] rY = new int[n];

        for (int i = 0; i < n; i++) {
            rX[i] = Arrays.binarySearch(sortedX, x[i]);
            rY[i] = Arrays.binarySearch(sortedY, y[i]);
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = rX[i] - rY[i];
        }

        double sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += d[i]*d[i];
        }
        return 1 - 6 * sumD / ( n * ( n * n - 1));
    }

    /**
     * Total sums of squares
     * @param X
     * @param Y
     * @return
     */
    public static double SST(double[] X, double[] Y){
        int n = Y.length;
        double sum = 0;
        double y_mean = mean(Y);
        for (int i = 0; i < n; i++){
            sum += (Y[i] - y_mean) * (Y[i] - y_mean);
        }
        return sum;
    }

    /**
     * Regression sums of squares
     */
    public static double SSR(double[] X, double [] Y){
        int n = Y.length;
        double sum = 0;
        double y_mean = mean(Y);
        double[] yy = regression(X,Y);
        for (int i = 0; i < n; i++){
            sum += (yy[i] - y_mean) * (yy[i] - y_mean);
        }
        return sum;
    }

    /**
     * Error sums of squares
     */
    public static double SSE(double[] X, double [] Y){
        int n = Y.length;
        double sum = 0;
        double[] yy = regression(X,Y);
        for (int i = 0; i < n; i++){
            sum += (yy[i] - Y[i]) * (yy[i] - Y[i]);
        }
        return sum;
    }


    public static double[] regression(double[] X, double [] Y){
        int n = Y.length;
        double[] yy = new double[n];
        double b = pearson(X, Y, n) * std(Y) / std(X);
        double a = mean(X) - b * mean(Y);
        for (int i = 0; i < n; i++) {
            yy[i] = a + b * X[i];
        }
        return yy;
    }

    public static double regressionYwithValueX(double[] X, double [] Y, int x){
        int n = X.length;
        double b = pearson(X, Y, n) * std(Y) / std(X);
        double a = mean(X) - b * mean(Y);
        return a + b*x;
    }

}
