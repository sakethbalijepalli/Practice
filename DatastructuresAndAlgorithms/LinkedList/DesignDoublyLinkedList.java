package DatastructuresAndAlgorithms.LinkedList;

public class DesignDoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyLinkedListNode curr = head;

        while (curr != null) {
            sb.append(curr.val).append(" <-> ");
            curr = curr.next;
        }

        sb.append("END");
        return sb.toString();
    }

    void main() {
        DesignDoublyLinkedList list = new DesignDoublyLinkedList();

        list.addAtHead(10);
        list.addAtHead(5);
        list.addAtTail(20);
        list.addAtTail(30);

        list.addAtIndex(2, 15);
        list.deleteAtIndex(4);
        System.out.println(list);
    }

    public DesignDoublyLinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        DoublyLinkedListNode curr = head;
        int current = 0;

        while (curr != null && current < index) {
            curr = curr.next;
            current++;
        }

        if (curr == null) {
            return -1;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);

        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void addAtTail(int val) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);

        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;

        if (head == null) {
            head = newNode;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        DoublyLinkedListNode curr = head;
        int current = 0;

        while (curr != null && current < index) {
            curr = curr.next;
            current++;
        }
        if (current != index) {
            return;
        }
        if (curr == null) {
            addAtTail(val);
            return;
        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        DoublyLinkedListNode prev = curr.prev;

        newNode.next = curr;
        newNode.prev = prev;
        curr.prev = newNode;
        if (prev != null) {
            prev.next = newNode;
        } else {
            head = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }

        DoublyLinkedListNode curr = head;
        int current = 0;
        while (curr != null && current < index) {
            curr = curr.next;
            current++;
        }
        if (curr == null || current != index) {
            return;
        }

        DoublyLinkedListNode prevNode = curr.prev;
        DoublyLinkedListNode nextNode = curr.next;

        if (prevNode == null && nextNode == null) {
            head = null;
            tail = null;
            return;
        }
        if (prevNode == null) {
            head = nextNode;
            nextNode.prev = null;
            return;
        }
        if (nextNode == null) {
            tail = prevNode;
            prevNode.next = null;
            return;
        }

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

}
