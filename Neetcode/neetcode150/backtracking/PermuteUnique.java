package Neetcode.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    void main() {
        System.out.println(permuteUnique(new int[]{2,2}));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,resList,numList,arr);
        return resList;
    }

    private void dfs(int[] nums,int i,List<List<Integer>> resList,List<Integer> numList,boolean[] arr){
        if(i == nums.length){
            resList.add(new ArrayList<>(numList));
            return;
        }
        for(int j = 0;j < nums.length;j++){
            if(arr[j] || (j > 0 && nums[j] == nums[j-1] && !arr[j-1])) continue;
            if(!arr[j]){
                numList.add(nums[j]);
                arr[j] = true;
                dfs(nums, i + 1, resList, numList,arr);
                numList.removeLast();
                arr[j] = false;
            }
        }
    }
}
