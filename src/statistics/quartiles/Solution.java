package statistics.quartiles;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by ponomarevandrew on 03.11.17.
 */

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        double[] quartiles = quartiles(nums);
        System.out.println((int)quartiles[0]);
        System.out.println((int)quartiles[1]);
        System.out.println((int)quartiles[2]);
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
