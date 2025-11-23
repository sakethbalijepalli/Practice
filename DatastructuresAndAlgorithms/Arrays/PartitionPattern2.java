package DatastructuresAndAlgorithms.Arrays;

/**
 * Find the smallest index i such that every element on left ≤ every element on right and leftMax[i] <= rightMin[i]
 */
public class PartitionPattern2 {

    static void main() {
        int[] arr = {5, 0, 3, 8, 6};
        System.out.println(findLeftMaxAndRightMin(arr));
        // N is 100
        for (int i = 1; i < 100; i = i * 2) {
            System.out.println("Current i: " + i);
        }
    }

    public static int findLeftMaxAndRightMin(int[] nums){
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);

        rightMin[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);

        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] <= rightMin[i+1])
                return i+1;
        }

        return -1;
    }
}
