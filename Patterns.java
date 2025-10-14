public class Patterns {
    static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
    }

    public static void pattern1(int n){
        for (int row = 1; row <= 2 * n - 1; row++) {
            int stars = row <= n ? row : 2 * n - row;

            for (int col = 1; col <= stars; col++) {
                IO.print("* ");
            }
            IO.println();
        }
        System.out.println();
    }

    public static void pattern2(int n){
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern3(int n){
        for (int row = 1; row <= 2 * n - 1; row++) {
            int stars = row <= n ? row : 2 * n - row;

            int spacesToPrint = 2 * n - stars;
            for(int i = 0;i < spacesToPrint; i++){
                System.out.print(" ");
            }
            for (int col = 1; col <= stars; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern4(int n){
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern5(int n){
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n + 1 - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
