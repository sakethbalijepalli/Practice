package Neetcode.neetcode150;

import java.util.Arrays;

public class ValidAnagram {
    static void main() {
        System.out.println(isAnagram("racecar","carrace"));
    }

    public static boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        int[] arrs = new int[26];
//        int[] arrt = new int[26];
//
//        for(char c : s.toCharArray()){
//            arrs[c - 'a']++;
//        }
//        for(int i = 0;i < t.length();i++){
//            arrt[t.charAt(i) - 'a']++;
//        }
//        return Arrays.toString(arrs).equals(Arrays.toString(arrt)); This logic works too, but we are using two arrays.

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
