public class Patterns {
    static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
        pattern9(5);
        pattern10(5);
        pattern11(5);
        pattern12(5);
        pattern13(5);
        pattern14(5);
        pattern15(5);
        pattern16(5);
        pattern17(5);
        pattern18(5);
    }

    public static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n + 1 - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern4(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int stars = row <= n ? row : 2 * n - row;

            for (int col = 1; col <= stars; col++) {
                IO.print("* ");
            }
            IO.println();
        }
        System.out.println();
    }

    public static void pattern5(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int stars = row <= n ? row : 2 * n - row;

            int spacesToPrint = n - stars;
            for (int i = 0; i < spacesToPrint; i++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= stars; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            int space = n - row;
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern7(int n) {
        for (int row = 0; row < n; row++) {

            for (int i = 0; i < row; i++) {
                System.out.print("  ");
            }
            for (int col = 0; col < n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern8(int n) {
        for (int row = 1; row <= n; row++) {
            int space = n - row;
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern9(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row == 1 || row == n || col == 1 || col == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern10(int n) {
        for (int row = 1; row <= n; row++) {
            int space = row - 1;
            for (int i = 0; i <= space; i++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= n + 1 - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern11(int n) {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern12(int n) {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n + 1 - row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern13(int n) {
        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(row);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern14(int n) {
        for (int row = 1; row <= n; row++) {
            char myChar = 'A';

            for (int col = 0; col < row; col++) {
                System.out.print(myChar);
                myChar++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern15(int n) {
        char myChar = 'A';
        for (int row = 1; row <= n; row++) {

            for (int col = 0; col < row; col++) {
                System.out.print(myChar);
            }
            System.out.println();
            myChar++;
        }
        System.out.println();
    }

    public static void pattern16(int n) {
        char myChar = 'E';
        char anotherChar = 'E';
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                if (row == col) {
                    System.out.print((myChar));
                } else {
                    System.out.print((char) (anotherChar - 1 + col));
                }
            }
            anotherChar--;
            System.out.println();
        }
        System.out.println();
    }

//    public static void pattern16(int n) {
//        for (int row = 1; row <= n; row++) {
//            // Starting character shifts backward each row
//            char myChar = (char) ('E' - row);
//
//            for (int col = 1; col <= row; col++) {
//                System.out.print(myChar + " ");
//                myChar++; // move forward alphabetically
//            }
//
//            System.out.println();
//        }
//    }

    public static void pattern17(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int t = (row <= n) ? row : (2 * n - row);

            int stars = n + 1 - t;

            for (int i = 0; i < t; i++) System.out.print(" ");

            for (int s = 0; s < stars; s++) System.out.print("* ");

            System.out.println();
        }
        System.out.println();
    }

    public static void pattern18(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int t = (row <= n) ? row : (2 * n - row);

            int stars = 2 * n + 1 - t;

            for (int i = 0; i < t; i++) System.out.print(" ");

            for (int s = 0; s < stars; s++) System.out.print("* ");

            System.out.println();
        }
        System.out.println();
    }

}
