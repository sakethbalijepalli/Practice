package LeetcodePractice;

public class Encode {

    static void main() {
        String s = "aaaabbbccc";
        System.out.println(encode(s));
    }


    public static String encode(String input){
        if(input == null || input.isEmpty()){
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        int counter = 1;
        char[] arr = input.toCharArray();
        char prevChar = arr[0];

        for(int i = 1;i < arr.length;i++){
            if(arr[i] == prevChar){
                counter++;
            }else{
                sb.append(counter).append(prevChar);
                counter = 1;
                prevChar = arr[i];
            }
        }
        sb.append(counter).append(prevChar);
        return sb.toString();
    }
}
