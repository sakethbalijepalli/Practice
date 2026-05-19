package LeetcodePractice;

import LeetcodePractice.Utils.ListNode;

import java.util.List;

public class RotateList {
    ListNode node;

    static void main() {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int[] values = {1, 2, 3, 4, 5};

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        ListNode head = dummy.next;
        rotatePractice(head,2);
        System.out.println(reverse(head));
        rotateRight(head,2);


    }


    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null){
            tail = tail.next;
            len += 1;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        ListNode curr = head;
        for(int i = 0;i < len - k - 1;i++){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next; // temp pointed to 2 through 5
            curr.next = prev; // pointed 1 to null;
            prev = curr; // prev is 1 -> null
            curr = temp;//
        }
        return prev;
    }

    public static ListNode rotatePractice(ListNode head,int k){
        // if k is the same size as head's length or k is zero, we dont need to rotate we can just return that will be handled by k mod len
        // if k > len then mod will just give us the difference.
        // if k < len then just rotate the list
        // if head is empty/null just return the head.
        // if head has a len 1 then just return head.
        // we find the tail first.
        // find the k elements to be rotated by using len - k - 1;
        // and rotate the list
        ListNode tail = head;
        int length = 1; // min len
        while(tail.next != null){
            tail = tail.next;
            length += 1;
        }
        k = k % length;
        if(k == 0){
            return head;
        }
        ListNode kthElement = head;
        for(int i = 0;i < length - k - 1;i++){
            kthElement = kthElement.next; // if the list has 5 elements and k is 2, loop will stop at the 3rd element.
        }
        ListNode newHead = kthElement.next; // 4->5
        ListNode prev = null;
        ListNode curr = newHead;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        kthElement.next = null; // 1->2->3-> null
        tail.next.next = head;
        return tail;
    }



























}

