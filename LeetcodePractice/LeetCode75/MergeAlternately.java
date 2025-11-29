package LeetcodePractice.LeetCode75;

public class MergeAlternately {

    static void main() {
        System.out.println(mergeAlternately("abc","pqr"));
    }
    public static String mergeAlternately(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        StringBuilder s = new StringBuilder(n + m);

        int i = 0;
        while (i < n || i < m) {
            if (i < n) {
                s.append(word1.charAt(i));
            }
            if (i < m) {
                s.append(word2.charAt(i));
            }
            i++;
        }
//
//        if(word1.length() == word2.length()){
//            for(int i = 0;i < word1.length();i++){
//               s.append(word1.charAt(i)).append(word2.charAt(i));
//            }
//        }else if(word1.length() < word2.length()){
//            for(int i = 0;i < word1.length();i++){
//                s.append(word1.charAt(i)).append(word2.charAt(i));
//            }
//            s.append(word2, word1.length(), word2.length());
//        }else{
//            for(int i = 0;i < word2.length();i++){
//                s.append(word1.charAt(i)).append(word2.charAt(i));
//            }
//            s.append(word1, word2.length(), word1.length());
//        }
        return s.toString();
    }
}
