package DatastructuresAndAlgorithms.Arrays;

import java.util.ArrayList;
import java.util.List;

public class CreateSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subLists(arr));
    }

    public static List<List<Integer>> subLists(int[] arr){
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                List<Integer> resultList = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    resultList.add(arr[k]);
                }
                result.add(resultList);
            }
        }
        return result;
    }
}
