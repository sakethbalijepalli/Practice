package LeetcodePractice;

import java.util.Arrays;

public class RemoveElement {
    static void main() {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public static int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        int i = 0;
        if(nums.length == 1){
            if(nums[0] == val){
                return i;
            }else{
                return nums.length;
            }
        }
        if(nums.length != 0){
            while(i <= j){
                if(nums[i] != val){
                    i++;
                }else{
                    nums[i] = nums[j];
                    j--;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
