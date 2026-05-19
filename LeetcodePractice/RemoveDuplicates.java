package LeetcodePractice;

public class RemoveDuplicates {

    void main() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int k = 1;
        int i = 0;

        while(i < nums.length && j < nums.length){
            if(nums[i] != nums[j]){
                nums[k] = nums[j];
                k++;
            }
            i++;
            j++;
        }
        return k;
    }
}
