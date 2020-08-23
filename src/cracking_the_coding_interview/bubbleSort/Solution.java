package cracking_the_coding_interview.bubbleSort;

/**
 * Created by ponomarevandrew on 12.11.2017.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int numOfSwaps = bubbleSort(arr);
        System.out.println("Array is sorted in " + numOfSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[n - 1]);
    }

    private static int bubbleSort(int[] a) {
        int n = a.length;
        int numberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            int cur_num = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                    cur_num++;
                }
            }

            numberOfSwaps += cur_num;
            if (cur_num == 0) {
                break;
            }
        }
        return numberOfSwaps;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}