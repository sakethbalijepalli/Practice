package LeetcodePractice;

import java.util.Arrays;

public class ReplaceWithGreatestElement {

    static void main() {
        System.out.println(Arrays.toString(replaceElements(new int[]{2, 4, 5, 3, 1, 2})));
    }

    public static int[] replaceElements(int[] arr) {
        //2,4,5,3,1,2 --------> 5,5,3,2,2,-1

        int maxNumber = -1;
        for(int i = arr.length - 1;i >= 0;i--){
            int temp = arr[i];// ith index is at 2 now and we are storing the value in temp to lose the element.
            arr[i] = maxNumber;
            maxNumber = Math.max(temp, arr[i]);// max  = 2
        }
        return arr;
    }
}
// i = 5 , j = 4 max 2
// i = 4 , j = 3 max 3
// i = 3 , j = 2 max 3
// i = 2 , j = 1 max 3
// i = 1 , j = 0 max 3
