package Neetcode.neetcode150.binarysearch;

public class Search2DMatrix {
    static void main() {
        System.out.println(searchMatrix(new int[][]{{1,2,4,8},{10,11,12,13},{14,20,30,40}},10));;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int mid;
        int COLS = matrix[0].length;
        int ROWS = matrix.length;
        int left = 0,right = (ROWS * COLS) - 1;
        while (left <= right){
            mid = left + (right - left) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            if(target > matrix[row][col]){
                left = mid + 1;
            }else if(target < matrix[row][col]){
                right = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
