package LeetcodePractice.LeetCode75;

public class ReverseVowels {
    static void main() {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(s);

        while(left < right){
            if(!isVowel(s.charAt(left))){
                left++;
            }
            if(!isVowel(s.charAt(right))){
                right--;
            }
            if(isVowel(s.charAt(left)) && isVowel(s.charAt(right))){
                char temp = s.charAt(left);
                stringBuilder.setCharAt(left,s.charAt(right));
                stringBuilder.setCharAt(right,temp);
                left++;
                right--;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
