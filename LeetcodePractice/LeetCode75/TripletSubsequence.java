package LeetcodePractice.LeetCode75;


public class TripletSubsequence {

    static void main() {
        int[] arr = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(arr));
    }


    public static boolean increasingTriplet(int[] nums) {

        if(nums == null || nums.length < 3){
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        boolean isGreater = false;

        for(int i = 0;i < nums.length;i++){
            if(nums[i] <= a){
                a = nums[i];
            }else if(nums[i] < b){
                b = nums[i];
            }else{
                return true;
            }
        }
        return isGreater;
    }
}
