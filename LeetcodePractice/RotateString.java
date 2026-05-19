package LeetcodePractice;

public class RotateString {
    void main() {
        rotateString("abcd","cdab");
    }

    public boolean rotateString(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int n = s1.length();
        String rotated = s1;

        for(int i = 0;i < n;i++){
            rotated = rotated.substring(1) + rotated.charAt(0);

            if(rotated.equals(s2)){
                return true;
            }
        }
        return false;
    }
}
