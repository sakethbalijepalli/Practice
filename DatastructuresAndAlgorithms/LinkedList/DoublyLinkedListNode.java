package DatastructuresAndAlgorithms.LinkedList;

public class DoublyLinkedListNode {

    public int val;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "DoublyLinkedListNode{" +
                "val=" + val +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}