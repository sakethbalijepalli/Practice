package Neetcode.neetcode150.TwoPointers;

import java.util.Arrays;

public class TwoSum2 {
    void main() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j){
            int sum = numbers[i] + numbers[j];
            if(sum > target){
                j--;
            }else if (sum < target){
                i++;
            }else{
                return new int[]{i + 1,j + 1};
            }
        }
        return new int[]{};
    }
}
