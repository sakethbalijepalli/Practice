package HackerRank;

import java.util.List;

public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {

        int count = 0;
        int max = 0;

        for (int c : candles) {
            if (c > max) {
                max = c;
                count = 1;
            } else if (c == max) {
                count++;
            }
        }
        return count;
    }
}
