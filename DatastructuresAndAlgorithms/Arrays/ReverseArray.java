package DatastructuresAndAlgorithms.Arrays;

import java.util.Arrays;

public class ReverseArray {

    static void main() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(reverse(arr)));
    }

    static int[] reverse(int[] arr){
        int j = arr.length - 1;
        int i = 0;

        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}
