package cracking_the_coding_interview.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }

            int[] answer = searchFlavors(m, a);
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    private static int[] searchFlavors(int m, int[] a) {
        int[] sortedArr = a.clone();
        Arrays.sort(sortedArr);
        for (int i = 0; i < a.length; i++) {
            int complement = m - a[i];
            int complementIndex = Arrays.binarySearch(sortedArr, i+1, sortedArr.length, complement);
            if (complementIndex >= 0 && complementIndex < sortedArr.length && sortedArr[complementIndex] == complement) {
                int[] indicies = getIndiciesFromValues(a, a[i], complement);
                return indicies;
            }
        }
        return null;
    }

    private static int[] getIndiciesFromValues(int[] a, int value1, int value2) {
        int index1 = indexOf(a, value1, -1);
        int index2 = indexOf(a, value2, index1);
        int[] result = {Math.min(index1, index2) + 1, Math.max(index1, index2) + 1};
        return result;
    }

    private static int indexOf(int[] a, int value, int excludeIndex) {
        for (int i = 0; i < a.length; i++) {
            if (i == excludeIndex) {
                continue;
            }
            if (value == a[i]) {
                return i;
            }
        }
        return -1;
    }
}
