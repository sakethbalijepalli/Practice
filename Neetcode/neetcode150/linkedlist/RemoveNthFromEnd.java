package Neetcode.neetcode150.linkedlist;

import LeetcodePractice.Utils.ListNode;

public class RemoveNthFromEnd {
    void main() {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head,1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstPointer = head;
        ListNode curr = new ListNode(-1);
        curr.next = head;
        for(int i = 0;i < n;i++){
            firstPointer = firstPointer.next;
        }
        ListNode prev = curr;
        while (firstPointer != null){
            firstPointer = firstPointer.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return curr.next;
    }
}
