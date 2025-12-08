package DatastructuresAndAlgorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {

    void main() {
        int[] arr = {2,3,1,4,6};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public int[] insertionSort(int[] arr){

        for(int i = 1;i < arr.length;i++){
            int j = i - 1;
            while(j >=0 && arr[j + 1] <= arr[j]){
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j -=1;
            }
        }
        return arr;
    }
}
