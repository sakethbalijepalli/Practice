package LeetcodePractice.LeetCode75;

public class GCDStrings {
    static void main() {
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX","TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        String concatenatedString1 = str1 + str2;
        String concatenatedString2 = str2 + str1;
        if(!concatenatedString2.equals(concatenatedString1)){
            return "";
        }
        int length = findGCD(str1.length(),str2.length());

        return str1.substring(0,length);
    }
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
