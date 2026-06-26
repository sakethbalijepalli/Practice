package Neetcode.neetcode150.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {

    static void main() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        String res = encode(stringList);
        List<String> result = decode(res);
        System.out.println(result);
    }

    public static String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String s){
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int j = i;
            while (s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            j++;
            res.add(s.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
