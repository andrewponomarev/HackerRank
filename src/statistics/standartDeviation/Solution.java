package statistics.standartDeviation;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 03.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(round(std(nums), 1));
    }

    private static double std(Integer[] nums) {
        double mean = mean(nums);
        float sum = 0;
        for (float n : nums) {
            sum += (n - mean)*(n - mean);
        }
        return Math.sqrt(sum/nums.length);
    }

    public static float mean(Integer[] nums) {
        float sum = 0;
        for (float n : nums) {
            sum += n;
        }
        return sum/nums.length;
    }

    public static double round(double value, int scale) {
        return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
    }


}
