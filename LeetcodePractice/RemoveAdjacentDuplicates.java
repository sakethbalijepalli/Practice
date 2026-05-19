package LeetcodePractice;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAdjacentDuplicates {
    void main() {
        System.out.println(removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
