package HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SherlockValidString {
    static void main() {
        System.out.println(isValid("aabbcd"));
    }

    public static String isValid(String s) {
        // 1. Character Frequency Count
        // char_counts: Maps character to its frequency (e.g., {'a': 2, 'b': 2, 'c': 1})
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // 2. Frequency of Frequencies Count
        // freq_counts: Maps frequency value to the count of characters with that frequency
        // (e.g., {2: 2, 1: 1} for "aabbc" -> 2 chars have frequency 2, 1 char has frequency 1)
        Map<Integer, Integer> freqCounts = new HashMap<>();
        for (int freq : charCounts.values()) {
            freqCounts.put(freq, freqCounts.getOrDefault(freq, 0) + 1);
        }

        // Get the unique frequency values (Set S)
        Set<Integer> uniqueFreqs = freqCounts.keySet();

        // --- Validity Check Logic ---

        // Case 1: All characters appear the same number of times (e.g., "aabbcc")
        if (uniqueFreqs.size() == 1) {
            return "YES";
        }

        // Case 2: More than two unique frequencies (e.g., "aaabbc")
        if (uniqueFreqs.size() > 2) {
            return "NO";
        }

        // Case 3: Exactly two unique frequencies (S.size() == 2)

        int[] freqs = new int[2];
        int i = 0;
        for (int freq : uniqueFreqs) {
            freqs[i++] = freq;
        }

        int f1 = freqs[0];
        int f2 = freqs[1];
        int c1 = freqCounts.get(f1);
        int c2 = freqCounts.get(f2);

        // Scenario A: One character has frequency 1 (e.g., "aabbc")
        // Check if one frequency is 1 AND only one character has that frequency (its count is 1)
        // If f1=1 and c1=1, removing that single char leaves all others at f2.
        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) {
            return "YES";
        }

        // Scenario B: One character has frequency k+1 (e.g., "aaabbbcccdddd")

        int f_low = Math.min(f1, f2);
        int f_high = Math.max(f1, f2);
        int c_high = freqCounts.get(f_high);

        // Check if the difference is 1 (f_high - f_low == 1)
        // AND only one character has the higher frequency (c_high == 1)
        if (f_high - f_low == 1 && c_high == 1) {
            // Removing one instance from the higher frequency group makes it match f_low.
            return "YES";
        }

        // If none of the valid conditions are met
        return "NO";
    }
}
