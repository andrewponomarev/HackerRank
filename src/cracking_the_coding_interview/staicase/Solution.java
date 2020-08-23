package cracking_the_coding_interview.staicase;

import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] arr = new int[s];
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            arr[a0] = n;
        }
        for (int i = 0; i < s; i++){
            System.out.println(steps(arr[i]));
        }
    }

    public static int simpleSteps(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return simpleSteps(n-1) + simpleSteps(n-2) + simpleSteps(n-3);
    }

    public static int steps(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (n == 4) return 7;

        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{0, 1, 0};
        matrix[1] = new int[]{0, 0, 1};
        matrix[2] = new int[]{1, 1, 1};

        int[] recVector = new int[]{1,2,4};

        int exp = n - 3;
        int[][] C = exp(matrix, exp);

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += C[2][i] * recVector[i];
        }
        return result;
    }

    private static int[][] exp(int[][] matrix, int exp) {
        if (exp == 1) {
            return matrix;
        }
        if (exp % 2 == 0) {
            int[][] X = exp(matrix, exp/2);
            return multiply(X, X, 3);
        } else {
            int[][] X = exp(matrix, exp -1);
            return multiply(matrix, X, 3);
        }
    }

    /**
     * Умножение квадратных матриц размера n на n
     * @param A
     * @param B
     * @return
     */
    public static int[][] multiply(int[][] A, int[][] B, int n) {
        int[][] C = new int[3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                 }
            }
        }
        return C;
    }

}
