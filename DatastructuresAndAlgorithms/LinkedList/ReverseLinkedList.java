package DatastructuresAndAlgorithms.LinkedList;

public class ReverseLinkedList {
    static ListNode tail;

    static void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseLinkedList(reverseLinkedListUsingRecursion(head)));
    }

    static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    static ListNode reverseLinkedListUsingRecursion(ListNode head){
        if(head == null) return null;

        ListNode newHead = head;
        if(head.next != null) {
            newHead = reverseLinkedListUsingRecursion(head.next);
            head.next.next = head;
        }
        head.next = null;
        System.out.println(newHead);
        return newHead;
    }
}
