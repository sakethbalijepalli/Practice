package Neetcode.neetcode150.linkedlist;

import LeetcodePractice.Utils.ListNode;

public class MergeTwoSortedLists {

    static void main() {
        LeetcodePractice.Utils.ListNode listNode = new LeetcodePractice.Utils.ListNode(1);
        listNode.next = new LeetcodePractice.Utils.ListNode(2);
        listNode.next.next = new LeetcodePractice.Utils.ListNode(4);

        LeetcodePractice.Utils.ListNode listNode1 = new LeetcodePractice.Utils.ListNode(1);
        listNode1.next = new LeetcodePractice.Utils.ListNode(3);
        listNode1.next.next = new LeetcodePractice.Utils.ListNode(5);
        System.out.println(mergeLists(listNode,listNode1));
    }


    public static LeetcodePractice.Utils.ListNode mergeLists(LeetcodePractice.Utils.ListNode l1, LeetcodePractice.Utils.ListNode l2){
        LeetcodePractice.Utils.ListNode dummy = new LeetcodePractice.Utils.ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        dummy = dummy.next;
        return dummy;
    }
}
