package DatastructuresAndAlgorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {

    void main() {
        int[] arr = {2,3,1,4,6};
        insertionRecursive(arr,arr.length);
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

    public static void insertionRecursive(int[] arr, int n){
        if(n <= 1){
            return ; // because a single element is already sorted.
        }
        insertionRecursive(arr,n - 1); //[5,2,4,1] here we get to the call stack of first element => 5
//        insertionRecursive(arr,3)
//        insertionRecursive(arr,2)
//        insertionRecursive(arr,1)
//        insertionRecursive(arr,0)
        int last = arr[n - 1];
        int j = n - 2;
        // Shift elements of arr[0..i-1] that are greater than 'last'
        // to one position ahead of their current position
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
}
