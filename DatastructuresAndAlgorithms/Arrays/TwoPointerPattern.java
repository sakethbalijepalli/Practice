package DatastructuresAndAlgorithms.Arrays;

import java.util.HashSet;
import java.util.Set;

public class TwoPointerPattern {

    static void main() {
        int[] arr = {1, 2, 3, 1, 4, 5};
        System.out.println(findDuplicate(arr,3));
    }

    static String findDuplicate(int[] arr, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (window.contains(arr[i])) {
                return "Yes";
            }

            window.add(arr[i]);

            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }

        return "No";
    }


}
