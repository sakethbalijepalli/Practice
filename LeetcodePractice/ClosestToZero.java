package LeetcodePractice;

public class ClosestToZero {

    static void main() {
        int[] arr = {-10000,10000};
        System.out.println(findClosestNumber(arr));
    }

    public static int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int x : nums) {
            if (Math.abs(x) < Math.abs(closest)) {
                closest = x;
            }
        }

        if (closest < 0 && contains(nums, Math.abs(closest))) {
            return Math.abs(closest);
        } else {
            return closest;
        }
    }

    private static boolean contains(int[] nums, int value) {
        for (int num : nums) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
