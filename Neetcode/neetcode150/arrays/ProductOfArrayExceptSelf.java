package Neetcode.neetcode150.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    static void main() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 4, 6})));
    }

    // We solve this problem using prefix and suffix arrays.

    public static int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        int[] res = new int[nums.length];

        pre[0] = 1; // since there are no previous elements
        suf[nums.length - 1] = 1; // since there are no elements after that last one.

        // Lets load the prefix elements by multiplying the previous elements.
        //nums array -> 1 2 4 6
        for(int i = 1;i < nums.length;i++){
            pre[i] = nums[i-1] * pre[i - 1]; // preffix array -> 1 1 2 8
        }

        // Lets load the suffix elements by multiplying the suffix elements.
        for(int i = nums.length - 2;i >= 0;i--){
            suf[i] = nums[i + 1] * suf[i + 1];
        }

        for(int i = 0;i < res.length;i++){
            res[i] = pre[i] * suf[i];
        }
        return res;
    }
}
