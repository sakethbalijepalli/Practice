package LeetcodePractice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    static void main() {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        int n = s.length();
        int i = 0;

        return sum;
    }
}
