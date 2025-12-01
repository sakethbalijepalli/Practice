package LeetcodePractice.LeetCode75;

public class StringCompression {

    static void main() {
        char[] c = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(c));
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int read = 0;

        while (read < n) {
            char currentChar = chars[read];
            int start = read;

            while (read < n && chars[read] == currentChar) {
                read++;
            }

            int count = read - start;

            chars[write++] = currentChar;

            if (count > 1) {
                String num = Integer.toString(count);
                for (int i = 0; i < num.length(); i++) {
                    chars[write++] = num.charAt(i);
                }
            }
        }


        return write;
    }

}
