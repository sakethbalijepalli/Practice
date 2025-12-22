package LeetcodePractice;

public class NoOfIslands {

    static void main() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int noOfIslands = 0;

        for(int r = 0;r < row;r++){
            for(int c = 0;c < col;c++){
                if(grid[r][c] == '1'){
                    dfs(grid,r,c,row,col);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;

    }

    public static void dfs(char[][] arr, int rowNo, int colNo, int maxRow, int maxCol){
        if (rowNo < 0 || rowNo >= maxRow || colNo < 0 || colNo >= maxCol) {
            return;
        }

        if (arr[rowNo][colNo] == '0') {
            return;
        }
        arr[rowNo][colNo] = '0';

        for(int[] dir : directions){
            int newRow = rowNo + dir[0];
            int newCol = colNo + dir[1];

            dfs(arr, newRow, newCol, maxRow, maxCol);
        }
    }
}
