package Neetcode.neetcode150.linkedlist;

import LeetcodePractice.Utils.ListNode;

public class AddTwoNumbers {
    void main() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);

        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        System.out.println(addTwoNumbers(node1,node));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 => 9 -> 9 -> 9 where 1 is one's place and 3 is in hundred's place,
        // l2 => 1 -> 1 -> 1 same as l1;
        ListNode sum = new ListNode(-1);
        int carry = 0;
        ListNode curr = sum;
        while (l1 != null || l2 != null){
            int l1Val = l1 != null ? l1.val : 0; // 9
            int l2Val = l2 != null ? l2.val : 0; // 1
            int sumOfDigits = l1Val + l2Val + carry; // we get 10
            carry = sumOfDigits / 10; // if the sum is 10, we get carry as 1
            int digit = sumOfDigits % 10; // digit will be 0
            curr.next = new ListNode(digit);

            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return sum.next;
    }
}
