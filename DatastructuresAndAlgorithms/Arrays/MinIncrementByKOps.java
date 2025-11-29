package DatastructuresAndAlgorithms.Arrays;


public class MinIncrementByKOps {

    static void main() {
        int[] arr = {4, 7, 19, 16};
        System.out.println(minIncrementByKops(arr,3));
    }

    static int minIncrementByKops(int[] arr,int k){
        int MAX = Integer.MIN_VALUE;

        int result = 0;
        for (int value : arr) {
            MAX = Math.max(MAX, value);
        }

        for (int j : arr) {
            if ((MAX - j) % k != 0) {
                return -1;
            } else {
                result += (MAX - j) / k;
            }
        }
        return result;
    }
}
