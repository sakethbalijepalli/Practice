package DatastructuresAndAlgorithms.Arrays;

import java.util.Arrays;

public class RotateArray {

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotateArr(arr,2);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        d %= n;

        rotate(arr, 0, n - 1);

        rotate(arr, 0, d - 1);

        rotate(arr, d, n - 1);
    }

    static void rotate(int[] arr,int start, int end){

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
