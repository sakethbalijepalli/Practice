package Neetcode.neetcode150.bitmanipulation;

import java.util.Arrays;

public class ReverseBits {

    void main() {
        System.out.println(reverseBits(21));
    }

    public long reverseBits(long n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            long bit = (n >> i) & 1;
            res += (bit << (31 - i));
        }
        return res;
    }
}
