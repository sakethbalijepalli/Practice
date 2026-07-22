package Neetcode.neetcode150.arrays;

public class CharacterReplacement {
    void main() {
        System.out.println(characterReplacement("AAABABB",1));
    }

    // we are given a string and we can replace up to k chars to get a longest substring which contains only one distinct char;
    public int characterReplacement(String s, int k) {
        int L = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] arr = new int[26];
        for(int R = 0;R < s.length();R++){
            arr[s.charAt(R) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(R) - 'A']);
            if(R - L + 1 - maxFreq > k){
                arr[s.charAt(L) - 'A']--;
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
}
