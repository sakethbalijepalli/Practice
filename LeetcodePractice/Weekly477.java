package LeetcodePractice;

public class Weekly477 {

    static void main() {
        System.out.println(sumAndMultiply(10203004));
    }

    public static long sumAndMultiply(int n) {
        long reversed = 0;
        long sum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0){
                reversed = (reversed * 10) + digit;
                sum += digit;
            }
            n /= 10;
        }
        long rev = 0;
        while (reversed > 0) {
            rev = rev * 10 + (reversed % 10);
            reversed /= 10;
        }
        return sum * rev;
    }

}
