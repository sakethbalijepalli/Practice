package LeetcodePractice.LeetCode75;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MoveZeroes {

    static void main() {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {

        int[] arr = {0,1,5,0,2,0,3,0};

        int zeroCount = (int) Arrays.stream(arr)
                .filter(x -> x == 0)
                .count();

        int[] result =
                IntStream.concat(
                        Arrays.stream(arr).filter(x -> x != 0),
                        IntStream.generate(() -> 0).limit(zeroCount)
                ).toArray();
        System.out.println(Arrays.toString(result));

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
