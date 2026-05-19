package LeetcodePractice;

public class IsSubSequence {

    void main() {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){
            return false;
        }

        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
