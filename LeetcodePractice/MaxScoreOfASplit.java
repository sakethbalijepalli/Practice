package LeetcodePractice;


public class MaxScoreOfASplit {
    void main() {
        int[] arr = {10,-1,3,-4,-5};
        System.out.println(maximumScore(arr));
    }

    public long maximumScore(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        long[] suffixMins = new long[n];
        suffixMins[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMins[i] = Math.min(nums[i], suffixMins[i + 1]);
        }

        long maxScore = Long.MIN_VALUE;
        long currentPrefixSum = 0;

        for (int i = 0; i < n - 1; i++) {
            currentPrefixSum += nums[i];
            long currentSuffixMin = suffixMins[i + 1];

            long currentScore = currentPrefixSum - currentSuffixMin;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
