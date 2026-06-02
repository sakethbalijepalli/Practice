package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

public class ReverseLinkedList {

    void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseListRecursion(head));
        System.out.println(reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
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
    // 1 -> 2 -> 3 -> 4 -> 5 -> Null
    // curr.next.next = null;
    public static ListNode reverseListRecursion(ListNode head) {
        if(head == null) return null;

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListRecursion(head.next);
            head.next.next = head;
        }

        head.next = null;
        return newHead;
    }
}
