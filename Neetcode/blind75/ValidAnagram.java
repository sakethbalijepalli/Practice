package Neetcode.blind75;

import java.util.Arrays;

public class ValidAnagram {
    void main() {
        System.out.println(isAnagram("racecar","carrace"));
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arrs = new int[26];
        int[] arrt = new int[26];

        for(char c : s.toCharArray()){
            arrs[c - 'a']++;
        }
        for(int i = 0;i < t.length();i++){
            arrt[t.charAt(i) - 'a']++;
        }
        return Arrays.toString(arrs).equals(Arrays.toString(arrt));
    }
}
