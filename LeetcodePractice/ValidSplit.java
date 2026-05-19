package LeetcodePractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSplit {
    void main() {
        System.out.println(minimumIndex(Arrays.asList(2,1,3,1,1,1,7,1,2,1)));

    }

    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        int dominantElement = -1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) * 2 > n) {
                dominantElement = num;
            }
        }

        int totalFreq = map.get(dominantElement);
        int freq1 = 0;

        for (int i = 0; i <= n - 2; i++) {
            if (nums.get(i) == dominantElement) {
                freq1++;
            }
            int freq2 = totalFreq - freq1;

            if (freq1 * 2 > (i + 1) && freq2 * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;
    }
}
