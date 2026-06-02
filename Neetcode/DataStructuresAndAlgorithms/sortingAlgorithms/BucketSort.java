package Neetcode.DataStructuresAndAlgorithms.sortingAlgorithms;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BucketSort {
    static void main() {
        bucketSort(new int[]{1});
    }

    public static void bucketSort(int[] arr){
        // arr -> 2 1 2 0 0 2
        // counts 2 1 3
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int[] counts = new int[set.size()];
        if(arr.length == 1){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            counts[num] += 1;
        }

        int n = 0;
        for(int i = 0;i < counts.length;i++){
            for(int j = 0;j < counts[i];j++){
                arr[n] = i;
                n++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
