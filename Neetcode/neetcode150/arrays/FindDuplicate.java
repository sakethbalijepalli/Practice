package Neetcode.neetcode150.arrays;

import static java.lang.Math.abs;

public class FindDuplicate {

    void main() {
        System.out.println(findDuplicate(new int[]{3,2,2,2,4}));
    }

    public int findDuplicate(int[] nums) {

        for(int i = 0;i < nums.length;i++){
            nums[abs(nums[i]) - 1] *= -1;
            if(nums[abs(nums[i]) - 1] > 0){
                return Math.abs(nums[i]);
            }
        }
        return 0;
    }
}
