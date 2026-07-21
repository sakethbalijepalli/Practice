package Neetcode.neetcode150.arrays;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSubArrays {
    void main() {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int currentSum = 0;
        int targetSum = k * threshold;

        int L = 0;
        for (int R = 0; R < arr.length; R++) {
            currentSum += arr[R];
            if (R - L + 1 == k) {
                if (currentSum >= targetSum) {
                    res++;
                }
                currentSum -= arr[L];
                L++;
            }
        }

        return res;
    }
}
