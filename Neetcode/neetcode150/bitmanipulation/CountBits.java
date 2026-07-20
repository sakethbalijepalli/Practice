package Neetcode.neetcode150.bitmanipulation;

import java.util.Arrays;

public class CountBits {

    void main() {
        System.out.println(Arrays.toString(countBits(4)));
    }

    public int[] countBits(int n) {
        int count = 0;
        int[] arr = new int[n + 1];
        for(int i = 0;i <= n;i++){
            count = 0;
            int temp = i;
            for (int j = 0; j < 32; j++) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp = temp >> 1;
            }
            arr[i] = count;
        }
        return arr;
    }
}
