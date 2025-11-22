package LeetcodePractice;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length; // handle large k
        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }

        System.out.println(Arrays.toString(rotated).replace(" ", ""));
    }
}
