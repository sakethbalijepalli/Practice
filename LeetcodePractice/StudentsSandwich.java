package LeetcodePractice;

import java.util.*;

public class StudentsSandwich {

    void main() {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students,sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int i = 0; i < len; i++) {
            sandwichStack.push(sandwiches[len - i - 1]);
            studentQueue.offer(students[i]);
        }

        int lastServed = 0;
        while (!studentQueue.isEmpty() && lastServed < studentQueue.size()) {
            if (sandwichStack.peek() == studentQueue.peek()) {
                sandwichStack.pop();
                studentQueue.poll();
                lastServed = 0;
            } else {
                studentQueue.offer(studentQueue.poll());
                lastServed++;
            }
        }

        return studentQueue.size();
    }

}
