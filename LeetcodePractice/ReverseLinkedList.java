package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

public class ReverseLinkedList {

    void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
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
}
