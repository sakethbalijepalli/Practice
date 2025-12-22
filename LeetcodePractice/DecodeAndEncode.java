package LeetcodePractice;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecodeAndEncode {

    void main() {
        List<String> list = new ArrayList<>(Arrays.asList("neet", "code", "love", "you"));
        System.out.println(encode(list));
        System.out.println(decode("4#neet4#code4#love3#you"));
    }

    public String encode(List<String> strs) {
        char hash = '#';
        StringBuilder concatenatedString = new StringBuilder();

        for(String s : strs){
            concatenatedString.append(s.length()).append(hash).append(s);
            System.out.println(concatenatedString);
        }
        byte[] encoded = concatenatedString.toString().getBytes();
        return new String(encoded,StandardCharsets.UTF_8);
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++;

            int len = Integer.parseInt(s.substring(i, j));
            j++;

            result.add(s.substring(j, j + len));
            i = j + len;
        }
        return result;
    }
}
