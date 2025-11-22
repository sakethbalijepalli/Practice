package LeetcodePractice;

import java.util.Arrays;

public class IsAnagram {

    void main(String[] args) {
        System.out.println(isAnagram("racecar", "carrace"));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}
