package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

public class ReverseBetween {

    void main() {
        int[] values = {1,2,3,4,5};
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        ListNode head = dummy.next;
        System.out.println(reverseBetween(head,2,4));
    }


//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode curr = head;
//        ListNode prev = null;
//        ListNode dummy = new ListNode(-1);
//        ListNode current = dummy;
//        int count  = 1;
//
//        while(curr != null){
//            if(count == left && count < right){
//                prev = reverse(curr,prev,count);
//            }else{
//                current.next =;
//                current = current.next;
//            }
//            curr = curr.next;
//            count++;
//        }
//        return prev;
//    }
//
//    public ListNode reverse(ListNode curr,ListNode prev,int count){
//        while(curr != null){
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//
//        }
//        return prev;
//    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
       if(head == null || left == right) return head;

       ListNode dummy = new ListNode(0);
       dummy.next = head;

        ListNode before = dummy;
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode sub_start = before.next;

        ListNode prev = null;
        ListNode curr = sub_start;
        int i = left;
        while (i <= right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }

        before.next = prev;
        sub_start.next = curr;

       return dummy.next;
    }


//    1 -> 2 -> 3 -> 4 -> 5 -> 6 i want to reverse between 3 and 4 so the resulting list would be 1 -> 2 -> 4 -> 3 -> 5 -> 6
}
