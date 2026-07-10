package Neetcode.neetcode150.Graphs;

import java.util.Arrays;

public class FloodFill {
    void main() {
        int[][] grid = {{1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}};
        System.out.println(Arrays.deepToString(floodFill(grid, 1, 1, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int startingColor = image[sr][sc];
        if (startingColor == color) return image;
        return dfs(image,sr,sc,color,startingColor);
    }

    private int[][] dfs(int[][] image, int row, int col, int color,int startingColor){
        int ROW = image.length, COL = image[0].length;
        if(Math.min(row,col) < 0 || row == ROW || col == COL || image[row][col] != startingColor){
            return image;
        }

        image[row][col] = color;

        dfs(image,row + 1,col,color,startingColor);
        dfs(image,row - 1,col,color,startingColor);
        dfs(image,row ,col + 1,color,startingColor);
        dfs(image,row,col - 1,color,startingColor);

        return image;
    }
}
