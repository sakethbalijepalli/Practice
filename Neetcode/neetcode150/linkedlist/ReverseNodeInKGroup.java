package Neetcode.neetcode150.linkedlist;

import LeetcodePractice.Utils.ListNode;

public class ReverseNodeInKGroup {
    void main() {
        int[] values = {1,2,3,4};
        ListNode head = createList(values);

        System.out.print("Original List: ");
        ListNode reverse = reverseKGroup(head,3);
        printList(reverse);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int group = 0;
        while (cur != null && group < k) {
            cur = cur.next;
            group++;
        }

        if (group == k) {
            cur = reverseKGroup(cur, k);
            while (group-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
