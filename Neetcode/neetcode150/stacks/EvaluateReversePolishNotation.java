package Neetcode.neetcode150.stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    void main() {
        System.out.println(evalRPN(new String[]{"1","2","+","3","*","4","-"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < tokens.length;i++){

            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-": {
                    // Order matters for subtraction! Pop the right operand first.
                    int right = Integer.parseInt(String.valueOf(stack.pop()));
                    int left = Integer.parseInt(String.valueOf(stack.pop()));
                    stack.push(Integer.valueOf(String.valueOf(left - right)));
                    break;
                }

                case "*":
                    stack.push(Integer.valueOf(String.valueOf(Integer.parseInt(String.valueOf(stack.pop())) * Integer.parseInt(String.valueOf(stack.pop())))));
                    break;

                case "/": {
                    // Order matters for division! Pop the right operand first.
                    int right = Integer.parseInt(String.valueOf(stack.pop()));
                    int left = Integer.parseInt(String.valueOf(stack.pop()));
                    stack.push(Integer.valueOf(String.valueOf(left / right)));
                    break;
                }

                default:
                    // If it's not an operator, it's a number operand. Push it to the stack.
                    stack.push(Integer.valueOf(String.valueOf(Integer.parseInt(tokens[i]))));
                    break;
            }
        }
        return stack.peek();
    }
}
