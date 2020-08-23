package statistics.LSR;

public class Solution {



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

    public static double mean(double[] nums) {
        double sum = 0;
        for (double n : nums) {
            sum += n;
        }
        return sum/nums.length;
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
}
