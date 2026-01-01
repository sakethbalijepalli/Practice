package LeetcodePractice;

public class MajorityElement {
    void main() {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }


    public int majorityElement(int[] nums) {
        int counter = 1;
        int majorityElement = nums[0];

        for(int i = 1;i < nums.length;i++){
            if(counter == 0){
                majorityElement = nums[i];
                counter = 1;
            }else if(majorityElement == nums[i]){
                counter++;
            }else{
                counter--;
            }
        }
        return majorityElement;
    }
}

