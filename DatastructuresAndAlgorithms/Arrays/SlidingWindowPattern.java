package DatastructuresAndAlgorithms.Arrays;

public class SlidingWindowPattern {
    static void main() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSubArray(arr,3));
    }

    public static int maxSubArray(int[] arr, int k){
        if(arr.length < k) return -1;
        int windowSum = 0;
        for(int i = 0;i < k;i++){
            windowSum += arr[i];
        }
        int maxSum = 0;
        for(int i = k;i < arr.length;i++){
            windowSum = windowSum - arr[i - k] + arr[i];

            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
