package Neetcode.blind75;

public class MissingNumber {

    void main() {
        System.out.println(missingNumber(new int[]{1,2,3}));
    }

    public int missingNumber(int[] nums) {
        //001
        //010
        //011
        //100
        //101
        int res = nums.length;
        // 2 ^ 0 ^ 0
        for(int i = 0;i < nums.length;i++){
            res = res ^ nums[i] ^ i;
        }
        return res;
    }
}
