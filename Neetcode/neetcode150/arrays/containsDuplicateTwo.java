package Neetcode.neetcode150.arrays;

import java.util.HashSet;

public class containsDuplicateTwo {
    void main() {
        System.out.println(closeDuplicatesBruteForce(2,new int[]{1,2,3,2,3,3}));
        System.out.println(containsDuplicateUsingSlidingWindow(2,new int[]{1,2,3,2,3,3}));
    }

    public boolean closeDuplicatesBruteForce(int k,int[] nums){

        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < Math.min(i + k,nums.length);j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateUsingSlidingWindow(int k,int[] nums){
        HashSet<Integer> window = new HashSet<>();
        int L = 0;
        for(int R = 0;R < nums.length;R++){
            if(R - L + 1 > k){
                window.remove(nums[L]);
                L += 1;
            }
            if(window.contains(nums[R])){
                return true;
            }
            window.add(nums[R]);
        }
        return false;
    }
}
