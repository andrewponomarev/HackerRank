package cracking_the_coding_interview.dfs;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(maxRegionLength(grid));
    }

    private static int maxRegionLength(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int countRegion = countRegion(grid, i, j);
                    if (countRegion > max) {
                        max = countRegion;
                    }
                }
            }
        }
        return max;
    }

    private static int countRegion(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        count += countRegion(grid, i - 1, j - 1);
        count += countRegion(grid, i - 1, j);
        count += countRegion(grid, i - 1, j + 1);
        count += countRegion(grid, i, j - 1);
        count += countRegion(grid, i , j + 1);
        count += countRegion(grid, i + 1, j - 1);
        count += countRegion(grid, i + 1, j );
        count += countRegion(grid, i + 1, j + 1);

        return count;
    }
}
