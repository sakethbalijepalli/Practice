package Neetcode.DataStructuresAndAlgorithms.dynamicprogamming;

public class UniquePaths {
    void main() {
        // In a 2D grid, if we are only allowed to go down or right.
        System.out.println(dfs(0,0,4,4));
        System.out.println(dpTopDown(0,0,4,4,new int[4][4]));
        System.out.println(dpBottomUp(4,4));
    }

    // Using recursion, time complexity O(2 ^ (m + n))
    public int dfs(int r,int c,int ROWS,int COLS){
        if(r == ROWS || c == COLS){
            return 0;
        }
        if(r == ROWS - 1 && c == COLS - 1){
            return 1;
        }
        return dfs(r + 1,c,ROWS,COLS) + dfs(r,c + 1,ROWS,COLS);
    }

    // Using DP top down approach, time complexity O(M + N)
    public int dpTopDown(int r,int c,int ROWS,int COLS,int[][] cache){
        if(r == ROWS || c == COLS){
            return 0;
        }
        if(cache[r][c] > 1){
            return cache[r][c];
        }
        if(r == ROWS - 1 && c == COLS - 1){
            return 1;
        }
        cache[r][c] = dpTopDown(r + 1,c,ROWS,COLS,cache) + dpTopDown(r, c + 1,ROWS,COLS,cache);
        return cache[r][c];
    }

    // Using DP bottom up approach, time complexity O(M + N)
    public int dpBottomUp(int rows, int cols) {
        int[] prevRow = new int[cols];

        for (int i = rows - 1; i >= 0; i--) {
            int[] curRow = new int[cols];
            curRow[cols - 1] = 1;
            for (int j = cols - 2; j >= 0; j--) {
                curRow[j] = curRow[j + 1] + prevRow[j];
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}
