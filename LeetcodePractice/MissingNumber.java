package LeetcodePractice;

public class MissingNumber {

    void main() {
        int[] arr = {0,1};
        System.out.println(missingNumber(arr));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfN = n * (n + 1) / 2;
        int sum = 0;

        for(int i : nums){
            sum += i;
        }
        return sumOfN - sum;
    }
}
