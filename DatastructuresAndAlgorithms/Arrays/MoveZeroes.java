package DatastructuresAndAlgorithms.Arrays;

import java.util.Arrays;

public class MoveZeroes {

    static void main() {
        int[] arr = {1, 0, 0, 4, 5, 6};
        System.out.println(Arrays.toString(swapZeroes(arr)));
        System.out.println(Arrays.toString(moveZeroes(arr)));
    }

    static int[] moveZeroes(int[] arr){
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != 0){
                arr[count] = arr[i];
                count++;
            }
        }
        for(int i = count;i <arr.length;i++){
            arr[i] = 0;
        }
        return arr;
    }

    static int[] swapZeroes(int[] arr){
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        return arr;
    }
}
