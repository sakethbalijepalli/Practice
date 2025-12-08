package LeetcodePractice.BiWeeklyContest171;

public class CompletePrime {

    void main() {
        System.out.println(completePrime(23));
    }

    public boolean completePrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (!isPrime(num)) {
            return false;
        }

        int tmp = num;
        int digits = 0;
        while (tmp > 0) {
            digits++;
            tmp /= 10;
        }

        int pow10 = 1;
        for (int k = 1; k < digits; k++) {
            pow10 *= 10;

            int prefix = num / pow10;
            int suffix = num % pow10;

            if (!isPrime(prefix) || !isPrime(suffix)) {
                return false;
            }
        }

        return true;
    }


    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
