package Neetcode.neetcode150.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static void main() {
        System.out.println(Arrays.toString(twoSum(new int[]{4, 5, 6}, 10)));;
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        // 7 - 3 = 4 -> it exists in the map then we return
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i],i);
        }
        return new int[]{0,0};
    }
}
