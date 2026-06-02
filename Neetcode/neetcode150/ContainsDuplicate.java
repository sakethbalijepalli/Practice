package Neetcode.neetcode150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    static void main() {
        int[] arr = {1,2,3,3};
        System.out.println(hasDuplicate(arr));
    }

    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
//        key as the number and the value as the count

        for (int num : nums) {
            if (map.contains(num)) {
                return true;
            }
            map.add(num);
        }
        return false;
    }
}
