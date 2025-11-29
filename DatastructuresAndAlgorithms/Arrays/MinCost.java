package DatastructuresAndAlgorithms.Arrays;

public class MinCost {

    static void main() {
        int[] arr = {4 ,3 ,2,4,8,7};
        System.out.println(minCost(arr));
    }

    static int minCost(int[] arr){
        int min = arr[0];

        for(int i = 1;i < arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return (arr.length - 1) * min;
    }
}
