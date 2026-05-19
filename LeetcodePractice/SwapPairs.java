package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

public class SwapPairs {


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            ListNode nextPair = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = nextPair;
            prev.next = second;

            prev = curr;
            curr = nextPair;
        }
        return dummy.next;
    }
}
