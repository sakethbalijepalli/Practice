package Neetcode.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    void main() {
        System.out.println(subsets(new int[]{1,2,3}));;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        List<Integer> arr = new ArrayList<>();
        addSubsets(nums,res,i,arr);
        return res;
    }

    private void addSubsets(int[] nums,List<List<Integer>> res,int i,List<Integer> arr){
        if(i == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        addSubsets(nums,res,i + 1,arr);
        arr.removeLast();
        addSubsets(nums,res,i + 1,arr);
    }
}
