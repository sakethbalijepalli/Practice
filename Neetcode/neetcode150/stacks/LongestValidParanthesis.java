package Neetcode.neetcode150.stacks;

import java.util.Stack;

public class LongestValidParanthesis {

    void main() {
        System.out.println(longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int len = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
              stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    len = i - stack.peek();
                    max = Math.max(max,len);
                }
            }
        }
        return max;
    }
}
