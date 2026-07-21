package Neetcode.DataStructuresAndAlgorithms.advancedAlgorithms.arrays;

public class KadanesAlgorithm {
    void main() {
        System.out.println(maxSubArray(new int[]{-1}));
    }

    public int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int curSum = 0;

        for (int n : nums) {
            curSum = Math.max(n, curSum + n);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
