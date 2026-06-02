package Neetcode.neetcode150;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentElements {

    static void main() {
        System.out.println(Arrays.toString(topKFrequentElements(new int[]{7, 7}, 2)));
    }

    public static int[] topKFrequentElements(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet()
                .stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue())) // Sort by value descending
                .limit(k)
                .map(Map.Entry::getKey)                                 // Extract just the keys
                .mapToInt(Integer::intValue)
                .toArray();                                              // Collect safely into the list
    }
}
