package DatastructuresAndAlgorithms.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1;

    public MyStack() {
        this.q1 = new LinkedList<>();
    }

    void main() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        Queue<Integer> elementsPopped = new LinkedList<>();
        int size = q1.size();
        if(!empty()){
            for(int i = 0; i < size - 1;i++){
                elementsPopped.offer(q1.poll());
            }
        }

        Integer poppedElement = q1.poll();
        q1 = elementsPopped;
        return poppedElement.intValue();
    }

    public int top() {
        Queue<Integer> elementsPopped = new LinkedList<>();
        int size = q1.size();
        if(!empty()){
            for(int i = 0; i < size - 1;i++){
                elementsPopped.offer(q1.poll());
            }
        }

        Integer peekedElement = q1.peek();
        elementsPopped.offer(peekedElement);
        q1 = elementsPopped;
        return peekedElement.intValue();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
