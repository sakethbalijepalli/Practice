package Neetcode.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    void main() {
        System.out.println(combinationSum(new int[]{2,5,6,9},9));
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        List<Integer> arr = new ArrayList<>();
        checkCombination(nums,target,res,i,arr);
        return res;
    }

    private void checkCombination(int[] nums,int target,List<List<Integer>> res,int i,List<Integer> arr){
        if(nums.length == i || target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(arr));
            return;
        }
        target -= nums[i];
        arr.add(nums[i]);
        checkCombination(nums,target,res,i,arr);
        arr.removeLast();
        target += nums[i];
        checkCombination(nums,target,res,i + 1,arr);

    }
}
