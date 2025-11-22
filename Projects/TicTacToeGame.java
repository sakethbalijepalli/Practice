package Projects;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class TicTacToeGame {

    static String[] board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static String currentPlayer = "X";
    static String winner;
    static boolean gameRunning = true;
    static Scanner sc = new Scanner(System.in);
    static RandomGenerator randomGenerator = RandomGenerator.getDefault();

    public static void main(String[] args) {

        while (gameRunning) {
            printBoard(board);
            playerInput(board);
            checkWin();
            checkTie(board);
            rotatePlayer();
        }
        sc.close();
    }

    //printing the game board.
    static void printBoard(String[] board) {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    //Take player input.
    static void playerInput(String[] board) {

        System.out.print("Enter a number 1-9: ");
        int enteredNumber;
        if (currentPlayer.equals("O")) {
            enteredNumber = setRandomGenerator();
        } else {
            enteredNumber = sc.nextInt();
        }

        if (enteredNumber >= 1 && enteredNumber <= 9 && board[enteredNumber - 1].equals(String.valueOf(enteredNumber))) {
            board[enteredNumber - 1] = currentPlayer;
        } else {
            System.out.println("A player already took that spot");
        }
    }

    // switch the player
    static void rotatePlayer() {
        System.out.println(currentPlayer + "'s turn is over.");
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }

        System.out.println("Now it is " + currentPlayer + "'s turn to play");

    }

    static boolean checkRows(String[] board) {
        if (board[0].equals(board[1]) && board[1].equals(board[2])) {
            winner = board[0];
            return true;
        } else if (board[3].equals(board[4]) && board[4].equals(board[5])) {
            winner = board[3];
            return true;
        } else if (board[6].equals(board[7]) && board[7].equals(board[8])) {
            winner = board[6];
            return true;
        }
        return false;
    }

    static boolean checkColumns(String[] board) {
        if (board[0].equals(board[3]) && board[3].equals(board[6])) {
            winner = board[0];
            return true;
        } else if (board[1].equals(board[4]) && board[4].equals(board[7])) {
            winner = board[1];
            return true;
        } else if (board[2].equals(board[5]) && board[5].equals(board[8])) {
            winner = board[2];
            return true;
        }
        return false;
    }

    static boolean checkDiagonal(String[] board) {
        if (board[0].equals(board[4]) && board[4].equals(board[8])) {
            winner = board[0];
            return true;
        } else if (board[2].equals(board[4]) && board[4].equals(board[6])) {
            winner = board[2];
            return true;
        }
        return false;
    }

    //Check for win or tie
    static void checkTie(String[] board) {
        boolean hasEmpty = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(String.valueOf(i + 1))) {
                hasEmpty = true;
                break;
            }
        }
        if (!hasEmpty) {
            printBoard(board);
            System.out.println("It is a tie!!!");
            gameRunning = false;
        }
    }

    static void checkWin() {
        if (checkDiagonal(board) || checkRows(board) || checkColumns(board)) {
            System.out.println("Yayyyy the Winner is " + winner);
            gameRunning = false;
        }
    }

    static int setRandomGenerator() {
        int choice;

        while (true) {
            choice = randomGenerator.nextInt(1, 10);
            if (board[choice - 1].equals(String.valueOf(choice))) {
                System.out.println("O has chosen the spot " + choice);
                return choice;
            }
        }

    }
}
