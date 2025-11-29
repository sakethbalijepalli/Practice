package DatastructuresAndAlgorithms.LinkedList;

public class Node {
    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(Node.lengthOfTheLinkedList(head));
    }

    static int lengthOfTheLinkedList(Node head){
        int count = 0;
        Node curr = head;

        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
