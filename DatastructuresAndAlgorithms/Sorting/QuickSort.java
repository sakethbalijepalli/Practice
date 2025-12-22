package DatastructuresAndAlgorithms.Sorting;

import java.util.Arrays;

public class QuickSort {

    void main() {
        int[] arr = {3,5,7,2,1,3};
        System.out.println(Arrays.toString(quickSort(arr,0,arr.length - 1)));
    }

    public int[] quickSort(int[] arr, int start,int end){
        if(end - start + 1 <= 1){
            return arr;
        }
        int pivot = arr[end];
        int left = start;

        for(int i = start; i < arr.length - 1;i++){
            if(arr[i] < pivot){
                int tmp = arr[left];
                arr[left] = arr[i];
                arr[i] = tmp;
                left++;
            }
        }
        arr[end] = arr[left];
        arr[left] = pivot;


        quickSort(arr, start, left - 1);

        quickSort(arr, left + 1, end);

        return arr;
    }
}
