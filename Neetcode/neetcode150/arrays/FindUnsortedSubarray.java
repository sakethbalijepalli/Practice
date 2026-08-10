package Neetcode.neetcode150.arrays;

import java.util.Arrays;

public class FindUnsortedSubarray {
    void main() {
        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                if (start == -1) start = i;
                end = i;
            }
        }

        return end == -1 ? 0 : end - start + 1;
    }
}
