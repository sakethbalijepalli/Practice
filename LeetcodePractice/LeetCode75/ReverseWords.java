package LeetcodePractice.LeetCode75;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ReverseWords {
    static void main() {
        System.out.println(reverseWords("  hello world  "));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        int n = arr.length - 1;
        for(int i = n;i >= 0;i--){
            stringBuilder.append(arr[i]);
            if(i > 0)
            {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
