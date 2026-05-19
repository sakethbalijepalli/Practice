package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

public class RemoveNthNodeFromLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0){
            right = right.next;
            n -= 1;
        }

        while(right != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
