package Neetcode.blind75;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
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
