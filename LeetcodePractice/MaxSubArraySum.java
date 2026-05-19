package LeetcodePractice;

import java.util.HashSet;

public class MaxSubArraySum {
    void main() {
        int[] arr = {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(arr,3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long currentSum = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 > k) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            if (right - left + 1 == k) {
                max = Math.max(max, currentSum);
            }
        }

        return max;
    }
}
