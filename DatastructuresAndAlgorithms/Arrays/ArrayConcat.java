package DatastructuresAndAlgorithms.Arrays;

import java.util.Arrays;

public class ArrayConcat {

    static void main() {
        int[] arr = {1,4,1,2};
        System.out.println(Arrays.toString(getConcatenation(arr)));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] resultArr = new int[2 * nums.length];
        int n = nums.length;

        for(int i = 0;i < nums.length;i++){
            resultArr[i] = nums[i];
            resultArr[i + n] = nums[i];
        }
       return resultArr;

    }
}
