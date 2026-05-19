package LeetcodePractice;

import java.util.Arrays;

public class TwoSum2 {
    void main() {
        int[] arr = {-1,0};

        System.out.println(Arrays.toString(twoSum(arr, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0){
            return new int[0];
        }
        int[] result = new int[2];

        int l = 0;
        int r = numbers.length - 1;

        while(l < r){
            int sum = numbers[l] + numbers[r];

            if(sum < target){
                l++;
            }else if (sum > target){
                r--;
            }else{
                break;
            }
        }
        result[0] = l + 1;
        result[1] = r + 1;
        return result;
    }
}
