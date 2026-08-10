package Neetcode.neetcode150.arrays;

public class PushZeroes {
    void main() {
        pushZerosToEnd(new int[]{1,2,0,4,3,0,5,0});
    }

    void pushZerosToEnd(int[] arr) {
        // code here
        int i = 0;
        for(int j = 0;j < arr.length;j++){
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
    }
}
