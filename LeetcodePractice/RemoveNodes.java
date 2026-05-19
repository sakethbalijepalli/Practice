package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

public class RemoveNodes {

    void main() {
        int[] values = {1,2,3,6,4,5,6};
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        ListNode head = dummy.next;
        System.out.println(removeElements(head,6));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
