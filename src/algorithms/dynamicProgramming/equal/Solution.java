package algorithms.dynamicProgramming.equal;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] answers = new long[t];
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            answers[i] = numOfOps(arr);
        }
        for(int i = 0; i < t; i++) {
            System.out.println(answers[i]);
        }
    }

    private static long numOfOps(int[] a) {
        int min = findMin(a);
        int[] copy = new int[a.length];
        long sum = Long.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i] - min;
        }

        for (int base = 0; base < 3; base++) {
            int currentSum = 0;
            for (int i = 0; i < a.length; i++) {
                int delta = copy[i] + base;
                currentSum += delta / 5 + delta % 5 / 2 + delta % 5 % 2;
            }
            sum = Math.min(currentSum,sum);
        }

        return sum;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }


}
