package Neetcode.neetcode150.linkedlist;

import LeetcodePractice.Utils.ListNode;

import java.util.LinkedList;

public class ReorderList {
    void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
    }

    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        ListNode rev = null;
        while (l2 != null && l2.next != null){
            l2 = l2.next.next;
            l1 = l1.next;
        }
        ListNode secondHalf = l1.next;
        l1.next = null;
        while (secondHalf != null){
            ListNode temp = secondHalf.next;
            secondHalf.next = rev;
            rev = secondHalf;
            secondHalf = temp;
        }
        l1 = head;
        while (l1 != null && rev != null){
            ListNode nextL1 = l1.next;
            ListNode nextL2 = rev.next;
            l1.next = rev;
            rev.next = nextL1;
            l1 = nextL1;
            rev = nextL2;
        }
    }
}
