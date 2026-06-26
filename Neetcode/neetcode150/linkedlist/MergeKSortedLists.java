package Neetcode.neetcode150.linkedlist;

import LeetcodePractice.Utils.ListNode;

public class MergeKSortedLists {

    void main() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(6);

        ListNode[] arr = new ListNode[]{node,node1,node2};

        System.out.println(mergeKLists(arr));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
           lists[i] = merge(lists[i] , lists[i - 1]);
        }
        return lists[lists.length - 1];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}
