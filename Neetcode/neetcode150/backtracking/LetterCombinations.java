package Neetcode.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    void main() {
        System.out.println(letterCombinations("34"));;
    }

    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        int digit = digits.charAt(i) - '0';
        String chars = digitToChar[digit];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}
