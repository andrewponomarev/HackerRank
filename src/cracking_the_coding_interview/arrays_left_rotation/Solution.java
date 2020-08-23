package cracking_the_coding_interview.arrays_left_rotation;

import java.util.Scanner;

/**
 * Created by ponomarevandrew on 02.11.17.
 */
public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] result = new int[n];
        k = k % n;
        for (int i = 0; i < n; i++) {
            int j = (i + k) % n;
            result[i] = a[j];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }

}

