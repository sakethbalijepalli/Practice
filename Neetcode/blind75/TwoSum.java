package Neetcode.blind75;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    void main() {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 4, 5, 6}, 7)));
    }

//    3,4,5,6, target = 7
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(diff,i);
        }
        return new int[0];
    }
}
