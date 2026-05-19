package LeetcodePractice;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    void main() {
        int[] arr = {1,0,1,1};
        System.out.println(containsNearbyDuplicate(arr,1));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0;i < nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);

            if(set.size() > k){
                set.remove(nums[i - k]);
            }

        }
        return false;
    }
}
