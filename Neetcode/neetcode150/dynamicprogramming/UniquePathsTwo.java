package Neetcode.neetcode150.dynamicprogramming;

import java.util.Arrays;

public class UniquePathsTwo {
    void main() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},
                                                                {0,0,0},
                                                                {0,1,0}}));
        System.out.println(uniquePathsWithObstaclesTopDown(new int[][]{{0,0,0},
                {0,0,0},
                {0,1,0}}));
        System.out.println(bottomUpDfs(3,3,new int[][]{{0,0,0},
                                                            {0,0,0},
                                                            {0,1,0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 0 0 0
        // 0 0 0
        // 0 1 0
        return dfs(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid);
    }

    private int dfs(int r,int c,int ROW,int COL,int[][] obstacleGrid){
        if(r == ROW || c == COL || obstacleGrid[r][c] == 1){
            return 0;
        }

        if(r == ROW - 1 && c == COL - 1){
            return 1;
        }

        return dfs(r + 1,c,ROW,COL,obstacleGrid) + dfs(r, c + 1,ROW,COL,obstacleGrid);
    }

    public int uniquePathsWithObstaclesTopDown(int[][] obstacleGrid) {
        // 0 0 0
        // 0 0 0
        // 0 1 0
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return dfsTopDown(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid,dp);
    }


    private int dfsTopDown(int r,int c,int ROW,int COL,int[][] obstacleGrid,int[][] memoization){
        if(r == ROW || c == COL || obstacleGrid[r][c] == 1){
            return 0;
        }
        if(r == ROW - 1 && c == COL - 1){
            return 1;
        }
        if(memoization[r][c] != -1){
            return memoization[r][c];
        }
        memoization[r][c] = dfsTopDown(r + 1,c,ROW,COL,obstacleGrid,memoization) + dfsTopDown(r, c + 1,ROW,COL,obstacleGrid,memoization);
        return memoization[r][c];
    }

    private int bottomUpDfs(int r,int c,int[][] obstacleGrid){
        int[] dp = new int[c];
        if (obstacleGrid[r - 1][c - 1] == 0) {
            dp[c - 1] = 1;
        }
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j + 1 < c) {
                        dp[j] = dp[j] + dp[j + 1];
                    }
                }
            }
        }
        return dp[0];
    }

}
