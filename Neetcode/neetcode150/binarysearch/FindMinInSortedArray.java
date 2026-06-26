package Neetcode.neetcode150.binarysearch;

public class FindMinInSortedArray {

    void main() {
        System.out.println(findMin(new int[]{3,4,1,2}));
    }

    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while(L < R){
            int mid = L + (R - L) / 2;

            if(nums[mid] > nums[R]){
                L = mid + 1;
            }else{
                R = mid;
            }
        }
        return nums[R];
    }

}
