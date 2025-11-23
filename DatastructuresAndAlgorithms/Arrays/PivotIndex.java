package DatastructuresAndAlgorithms.Arrays;

/**
 * Find an index i such that sum(num[0...i-1]) == sum(num(i+1...n-1))
 */
public class PivotIndex {
    static void main() {
        int[] arr = {2,2,1,5,2,1,6,7,2,3,4};
        System.out.println(findPivot(arr));
    }

    public static int findPivot(int[] nums){
        int n = nums.length;
        int total = 0;

        for(int x : nums){
            total += x;
        }
        int left = 0;

        for(int i = 0;i < n;i++){
            int right = total - left - nums[i];
            if(left == right) return i;
        }
        return -1;
    }
}
