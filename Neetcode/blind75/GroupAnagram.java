package Neetcode.blind75;

import java.util.*;

public class GroupAnagram {
    void main() {
        String[] str = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(str));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] arr = new int[26];

            for(char c : s.toCharArray()){
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
