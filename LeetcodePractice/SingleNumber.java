package LeetcodePractice;

public class SingleNumber {
    void main() {
        int[] arr = {1};
        System.out.println(singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = num ^ result;
        }
        return result;
    }
}
