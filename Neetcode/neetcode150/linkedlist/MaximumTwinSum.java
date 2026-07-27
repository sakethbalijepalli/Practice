package Neetcode.neetcode150.linkedlist;


import LeetcodePractice.Utils.ListNode;

public class MaximumTwinSum {
    void main() {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pairSum(head));
    }

    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode rev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        while (slow != null){
            ListNode temp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = temp;
        }
        int max = Integer.MIN_VALUE;
        while (rev != null && head != null){
            int secondHalfVal = rev.val;
            int firstVal = head.val;
            max = Math.max(max,secondHalfVal + firstVal);
            rev = rev.next;
            head = head.next;
        }
        return max;
    }
}
