package HackerRank;

public class Staircase {
    static void main() {
        staircase(4);
    }

    public static void staircase(int n) {
        // Write your code here
        for (int i = 0; i < n; i++) {
            int spaces = n - (i + 1);
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }
}
