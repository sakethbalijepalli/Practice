package Neetcode.neetcode150.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    //top down dp
    int[][] memo;
    public int uniquePathsTopDown(int m, int n) {
        memo = new int[m][n];
        for(int[] it : memo) {
            Arrays.fill(it, -1);
        }
        return dfs(0, 0, m, n);
    }

    public int dfs(int i, int j, int m, int n) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }
        if (i >= m || j >= n) return 0;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        return memo[i][j] = dfs(i, j + 1, m, n) +
                dfs(i + 1, j, m, n);
    }

    //Bottom up dp
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for(int i = m - 1;i >= 0;i--){
            int[] currRow = new int[n];
            currRow[n - 1] = 1;
            for(int j = n - 2;j >= 0;j--){
                currRow[j] = currRow[j + 1] + prevRow[j];
            }
            prevRow = currRow;
        }
        return prevRow[0];
    }
}
