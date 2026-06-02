package DatastructuresAndAlgorithms.Stack;

import java.util.Stack;

public class BaseBallGame {
    static void main() {
        System.out.println(calPoints(new String[]{"1","2","+","C","5","D"}));
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                }
                case "D" -> stack.push(2 * stack.peek());
                case "C" -> stack.pop();
                default -> stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}
