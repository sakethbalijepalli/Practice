package DatastructuresAndAlgorithms.Sorting;

import java.util.Arrays;

public class MergeSort {

    void main() {
        int[] arr = {3,4,2,1,6,5};
        System.out.println(Arrays.toString(mergeSort(arr,0,5)));
    }

    public int[] mergeSort(int[] arr,int start,int end){
        if(end - start + 1 <= 1){
            return arr;
        }

        int mid = (start + end) / 2;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid + 1,end);

        merge(arr,start,mid,end);
        return arr;
    }


    public void merge(int[] arr, int left, int mid, int right) {

        int length1 = mid - left + 1;
        int length2 = right - mid;

        int[] L = new int[length1];
        int[] R = new int[length2];

        for(int i = 0;i < length1;i++){
            L[i] = arr[left + i];
        }

        for(int i = 0;i < length2;i++){
            R[i] = arr[mid + 1 + i] ;
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i < length1 && j < length2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < length1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < length2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
