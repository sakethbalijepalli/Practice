package Neetcode.neetcode150.stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
    void main() {
        System.out.println(largestRectangleArea(new int[]{7,1,7,2,2,4}));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();

        for(int i = 0;i < heights.length;i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]){
                Pair prevPair = stack.pop();
                maxArea = Math.max(maxArea, prevPair.height * (i - prevPair.index));
                start = prevPair.index;
            }
            stack.push(new Pair(start,heights[i]));
        }

        for (Pair pair : stack) {
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
        }
        return maxArea;
    }


    class Pair{
        int index;
        int height;

        public Pair(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
}
