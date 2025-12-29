package LeetcodePractice;

public class ValidWord {
    void main() {
        System.out.println(isValid("234Adas"));
    }

    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!Character.isLetterOrDigit(c)) {
                return false;
            }

            if (Character.isLetter(c)) {
                if (vowels.indexOf(c) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }
}
