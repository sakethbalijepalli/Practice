package Neetcode.neetcode150.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    void main() {
        NewNode node0 = new NewNode(3);
        NewNode node1 = new NewNode(7);
        NewNode node2 = new NewNode(4);
        NewNode node3 = new NewNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node0.random = null;

        node1.random = node3;

        node2.random = node0;

        node3.random = node1;

        NewNode head = node0;

        // Helper method to verify the setup
        printList(copyRandomList(head));
    }
    public NewNode copyRandomList(NewNode head) {
        if(head == null) return null;

        Map<NewNode,NewNode> map = new HashMap<>();
        NewNode curr = head;
        while (curr != null){
            map.put(curr,new NewNode(curr.val));
            curr = curr.next;
        }
        curr = head;

        while (curr != null){
            NewNode newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static void printList(NewNode head) {
        NewNode curr = head;
        while (curr != null) {
            String randomVal = (curr.random != null) ? String.valueOf(curr.random.val) : "null";
            System.out.println("Node val: " + curr.val + " | Random points to val: " + randomVal);
            curr = curr.next;
        }
    }
}

class NewNode {
    int val;
    NewNode next;
    NewNode random;

    public NewNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
