package DatastructuresAndAlgorithms.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = head.next.next;

//        ListNode middle = ListNode.findMiddle(head);
//        boolean hasCycle = ListNode.hasCycle(head);
        ListNode reverseNode = ListNode.reverseList(head);

//        System.out.println(hasCycle);
//        System.out.println("Middle node value: " + middle.val);
        System.out.println("Reverse node value: " + reverseNode);
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

//    Floyd's cycle finding algorithm
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("Cycle detected");
                return true;
            }
        }
        System.out.println("Fast reached the end, so no cycle.");
        return false;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }


}

