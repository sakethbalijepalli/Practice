package LeetcodePractice;

import java.util.Arrays;

public class MinStepsForAnagram {
    static void main() {
      String s = "anagram", t = "mangaar";
        System.out.println(minSteps(s,t));
    }

    public static int minSteps(String s, String t) {

        int count = 0;
        int[] charCount = new int[26];

        for(int i = 0;i < s.length();i++){
            charCount[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < t.length();i++){
            charCount[t.charAt(i) - 'a']--;
        }
        System.out.println(Arrays.toString(charCount));
        for (int j : charCount) {
            if (j > 0) {
                count += j;
            }
        }

        return count;
    }
}
