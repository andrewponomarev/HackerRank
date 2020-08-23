package algorithms.sorting.countingSorting;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = 100;
        countingSort(100, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] countArr(int max, int[] arr) {
        int[] countArr = new int[max];
        for (int i = 0; i < arr.length; i++){
            countArr[arr[i]]++;
        }
        return countArr;
    }

    private static void countingSort(int max, int[] arr) {
        int[] countArr = countArr(max, arr);
        int i = 0;
        int x = 0;
        while (i < arr.length) {
            int count = countArr[x];
            while (count > 0) {
                arr[i++] = x;
                count--;
            }
            x++;
        }
    }

}
