package LeetcodePractice;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveKDigits {

    void main() {
        System.out.println(removeKdigits("100",1));
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }

        while (k > 0) {
            stack.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
