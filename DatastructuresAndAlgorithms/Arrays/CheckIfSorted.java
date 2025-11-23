package DatastructuresAndAlgorithms.Arrays;

public class CheckIfSorted {

    static void main() {
        int[] arr = { 10, 20, 30, 40, 50 };

        System.out.println(isSorted(arr));
        System.out.println(checkIfSorted(arr));
    }

    public static boolean checkSorted(int[] arr,int n){
        if (n == 1 || n == 0)
            return true;

        return arr[n - 1] >= arr[n - 2] && checkSorted(arr, n - 1);
    }

    public static boolean isSorted(int[] arr) {

        return checkSorted(arr, arr.length);
    }

    public static boolean checkIfSorted(int[] arr){
        for(int i = 1;i < arr.length;i++){
            if(arr[i] < arr[i - 1]){
                return false;
            }
        }
        return true;
    }
}
