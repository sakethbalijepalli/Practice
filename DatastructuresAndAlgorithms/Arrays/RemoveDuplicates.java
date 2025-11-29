package DatastructuresAndAlgorithms.Arrays;

public class RemoveDuplicates {

    static void main() {
        int[] arr = {1,1,1,2,2,3,3};
        System.out.println(removeDuplicates(arr));
        System.out.println(removeDuplicatesForLoop(arr));

    }

    static int removeDuplicates(int[] arr){
        int k = 1;
        int i = 1;
        int j = 0;
        int n = arr.length;

        while (i < n){
            if(arr[i] == arr[j]){
                i++;
            }else{
                j++; k++;
                arr[j] = arr[i];
            }
        }
        return k;
    }

    static int removeDuplicatesForLoop(int[] arr){
        if (arr.length == 0) return 0;

        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1;
    }
}
