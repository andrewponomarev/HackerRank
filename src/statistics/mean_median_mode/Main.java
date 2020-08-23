package statistics.mean_median_mode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ponomarevandrew on 01.11.17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Float[] nums = new Float[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextFloat();
        }
        System.out.println(mean(nums));
        System.out.println(median(nums));
        System.out.println(mode(nums));

    }

    private static float mean(Float[] nums) {
        float sum = 0;
        for (float n : nums) {
            sum += n;
        }
        return sum/nums.length;
    }

    private static float median(Float[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 1) {
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2] + nums[nums.length/2 - 1]) / 2;
        }
    }
    private static int mode(Float[] nums) {
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
}
