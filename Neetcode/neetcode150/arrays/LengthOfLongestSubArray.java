package Neetcode.neetcode150.arrays;

public class LengthOfLongestSubArray {

    void main() {
        System.out.println(lenOfSubArray(new int[]{4,2,2,3,3,3}));
    }

    public int lenOfSubArray(int[] arr){
        int currLen = 0;
        int maxLen = Integer.MIN_VALUE;
        int L = 0;
        int R = 0;
        while (R < arr.length){
            if (arr[L] == arr[R]) {
                currLen++;
                R++;
            } else {
                L++;
                currLen = 0;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
    public int lenOfSubArrayUsingSlidingWindow(int[] arr){
        int L = 0;
        int maxLen = 0;
        for(int R = 0;R < arr.length;R++){
            if(arr[L] != arr[R]){
                L = R;
            }
            maxLen = Math.max(maxLen,R - L + 1);
        }
        return maxLen;
    }
}
