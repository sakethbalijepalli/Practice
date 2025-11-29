package DatastructuresAndAlgorithms.Arrays;

import java.util.Arrays;

public class RemoveElement {

    static void main() {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    static int removeElement(int[] nums,int val){
        int count = 0;
        int i = 0;
        int j = 0;
        int n =nums.length - 1;

        while(i <= n){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        for(int k = j; k < n;k++){
            nums[k] = 2;
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }
}
