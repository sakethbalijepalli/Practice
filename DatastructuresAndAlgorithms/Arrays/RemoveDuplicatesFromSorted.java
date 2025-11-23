package DatastructuresAndAlgorithms.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class RemoveDuplicatesFromSorted {
    static void main() {
        int[] arr = {1,2,2,2,2,3,4,4,4,5,5};
//        System.out.println(removeDuplicates(arr));
        System.out.println(removeDuplicate(arr));
    }

    static HashSet<Integer> removeDuplicates(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        return set;
    }

    static List<Integer> removeDuplicate(int[] arr){
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for(int i = 1;i < arr.length;i++){
            if(arr[i - 1] != arr[i]){
                result.add(arr[i]);
            }
        }
        return result;
    }
}
