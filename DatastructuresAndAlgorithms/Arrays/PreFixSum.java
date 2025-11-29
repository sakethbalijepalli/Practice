package DatastructuresAndAlgorithms.Arrays;

import java.util.Arrays;

public class PreFixSum {

    static void main() {
        int[] arr = {3, 1, 4, 2};
        System.out.println(prefixSum(arr));
    }

    static int prefixSum(int[] arr){
        int sum = arr[0];
        int result = 0;

        for(int i = 1;i < arr.length;i++){
            sum += arr[i];
            arr[i] = sum;
        }
        System.out.println(Arrays.toString(arr));

        for(int i = 1;i < arr.length;i++){
            result = arr[arr.length - i] - arr[i - 1];
        }
        return result;
    }
}
