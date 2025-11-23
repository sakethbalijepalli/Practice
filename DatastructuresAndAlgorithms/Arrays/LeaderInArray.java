package DatastructuresAndAlgorithms.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {
    static void main() {
        int[] nums = {9,3,6,1,2,8};
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(findLeaders(nums));
        System.out.println(findLeadersEfficiently(arr));

    }

    // O(n^2) approach
    public static List<Integer> findLeaders(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int j;
            for(j = i + 1;j < nums.length;j++){
                if(nums[i] < nums[j]){
                    break;
                }
            }
            if(j == nums.length){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static List<Integer> findLeadersEfficiently(int[] arr){
       ArrayList<Integer> result = new ArrayList<>();
       int n = arr.length;

       int maxRight = arr[n-1];

       result.add(maxRight);

       for(int i = n - 2;i >= 0;i--){
           if(arr[i] > maxRight){
               maxRight = arr[i];
               result.add(maxRight);
           }
       }
        Collections.reverse(result);
       return result;
    }
}
