package HackerRank;

import java.util.Arrays;

public class FunnyString {

    static void main() {
        System.out.println(funnyString("yrzxrxskrtlpwpmtpxvowrxrpxq"));
    }

    public static String funnyString(String s) {
        int n = s.length();
        int[] diffArr = new int[n - 1];
        int[] diffArr1 = new int[n - 1];

        for(int i = 1;i < s.length();i++){
            diffArr[i - 1] = Math.abs(s.charAt(i) - s.charAt(i - 1));
            diffArr1[i - 1] = Math.abs(s.charAt(n - i) - s.charAt(n - 1 - i));
        }
        String diffArrString = Arrays.toString(diffArr);
        String diffArrString1 = Arrays.toString(diffArr1);

        if(diffArrString.equals(diffArrString1)){
            return "Funny";
        }else{
            return "Not Funny";
        }
    }
}
