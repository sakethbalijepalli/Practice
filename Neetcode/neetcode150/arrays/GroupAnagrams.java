package Neetcode.neetcode150.arrays;

import java.util.*;

public class GroupAnagrams {

    void main() {
        String[] str = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(str));
    }

    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int j = 0; j < str.length(); j++) {
                count[str.charAt(j) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int c : count){
                stringBuilder.append("#").append(c);
            }
            String key = stringBuilder.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
