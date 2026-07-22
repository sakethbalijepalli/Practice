package Neetcode.neetcode150.arrays;

public class MinSubArraySum {
    void main() {
        System.out.println(minSubArrayLen(10,new int[]{2,1,5,1,5,3}));
    }

    // we have to return the minimal len of a subarray which has the target sum
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE, sum = 0, L = 0;

        for(int R = 0;R < nums.length;R++){
            sum += nums[R];
            if(sum >= target){
                while (sum >= target){
                    minLen = Math.min(minLen,R - L + 1);
                    sum -= nums[L];
                    L++;
                }
            }
        }
        if (minLen ==  Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }
}
