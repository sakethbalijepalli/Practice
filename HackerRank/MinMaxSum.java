package HackerRank;

import java.util.Arrays;
import java.util.List;

public class MinMaxSum {
    static void main() {
        miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
    }

    public static void miniMaxSum(List<Integer> arr) {
        long totalSum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            totalSum += x;
            if (x < min) min = x;
            if (x > max) max = x;
        }

        long minSum = totalSum - max;
        long maxSum = totalSum - min;

        System.out.println(minSum + " " + maxSum);
    }

}
