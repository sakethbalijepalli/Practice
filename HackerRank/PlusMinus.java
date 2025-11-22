package HackerRank;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    static void main() {
        plusMinus(Arrays.asList(1, 1, 0, -1, -1));
    }

    public static void plusMinus(List<Integer> arr) {

        double posCount = 0;
        double negCount = 0;
        double zeroCount = 0;
        int n = arr.size();

        for (Integer integer : arr) {
            if (integer > 0) {
                posCount++;
            } else if (integer == 0) {
                zeroCount++;
            } else {
                negCount++;
            }
        }
        double posCountDouble = posCount / n;
        double negCountDouble = negCount / n;
        double zeroCountDouble = zeroCount / n;
        System.out.printf("%.6f\n", posCountDouble);
        System.out.printf("%.6f\n", negCountDouble);
        System.out.printf("%.6f", zeroCountDouble);

    }
}
