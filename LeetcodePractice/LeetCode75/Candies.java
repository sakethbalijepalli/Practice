package LeetcodePractice.LeetCode75;

import java.util.ArrayList;
import java.util.List;

public class Candies {

    static void main() {
        int[] arr = {2,3,5,1,3};
        int n = 3;
        System.out.println(kidsWithCandiesEfficient(arr,3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            boolean isGreatest = true;

            for (int j = 0; j < candies.length; j++) {
                if (i != j) {
                    if (candies[i] + extraCandies < candies[j]) {
                        isGreatest = false;
                        break;
                    }
                }
            }
            result.add(isGreatest);
        }

        return result;
    }

    public static List<Boolean> kidsWithCandiesEfficient(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int highest = Integer.MIN_VALUE;
        for(int i : candies){
            highest = Math.max(i,highest);
        }
        for (int candy : candies) {
            result.add(candy + extraCandies >= highest);
        }

        return result;
    }

}
