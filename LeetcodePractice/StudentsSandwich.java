package LeetcodePractice;

import DatastructuresAndAlgorithms.Queues.DoubleEndedQueue;

import java.util.*;
import java.util.stream.Collectors;

public class StudentsSandwich {

    void main() {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students,sandwiches));
        System.out.println(arrayLogic(students,sandwiches));
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
            if (Objects.equals(sandwichStack.peek(), studentQueue.peek())) {
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

    public int arrayLogic(int[] students, int[] sandwiches) {
        int count0 = 0;
        int count1 = 0;

        for (int student : students) {
            if (student == 0) count0++;
            else count1++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (count0 > 0) {
                    count0--;
                } else {
                    // Game Over: Top sandwich is 0, but no students want 0
                    return count1;
                }
            } else { // sandwich is 1
                if (count1 > 0) {
                    count1--;
                } else {
                    // Game Over: Top sandwich is 1, but no students want 1
                    return count0;
                }
            }
        }
        // If we get here, everyone ate!
        return 0;
    }
}
