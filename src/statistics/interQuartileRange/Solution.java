package statistics.interQuartileRange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 03.11.17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        System.out.println(interQuartileRange(x, f, n));
    }

    private static double interQuartileRange(int[] x, int[] f, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += f[i];
        }
        int[] s = new int[k];
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

    private static double[] quartiles(int[] nums) {
        double[] q = new double[3];
        q[1] = median(nums);
        int halfLength = nums.length / 2;
        int startOf2 =  nums.length % 2 == 0 ? halfLength  : halfLength + 1;
        int[] nums1 = new int[halfLength];
        int[] nums2 = new int[halfLength];

        System.arraycopy(nums, 0, nums1,0, halfLength);
        System.arraycopy(nums, startOf2, nums2,0, halfLength);

        q[0] = median(nums1);
        q[2] = median(nums2);

        return q;
    }

    private static float median(int[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 1) {
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2] + nums[nums.length/2 - 1]) / 2;
        }
    }
}
