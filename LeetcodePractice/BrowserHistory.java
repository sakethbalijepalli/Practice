package LeetcodePractice;

public class BrowserHistory {
    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */

    DoublyLinkedList head;
    DoublyLinkedList tail;
    DoublyLinkedList session;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyLinkedList curr = head;

        while (curr != null) {
            sb.append(curr.val).append(" <-> ");
            curr = curr.next;
        }

        sb.append("END");
        return sb.toString();
    }

    static void main() {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    public BrowserHistory(String homepage) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(homepage);
        this.head = this.tail = this.session = doublyLinkedList;
    }

    public void visit(String url) {
        DoublyLinkedList newNode = new DoublyLinkedList(url);

        session.next = null;
        tail = session;

        session.next = newNode;
        newNode.prev = session;

        session = tail = newNode;
    }

    public String back(int steps) {
        int count = 0;
        DoublyLinkedList curr = session != null ? session : tail;

        while(count < steps && curr.prev != null){
            curr = curr.prev;
            count++;
        }
        session = curr;
        return curr.val;
    }

    public String forward(int steps) {
        int count = 0;
        DoublyLinkedList curr = session != null ? session : head;
        while(count < steps && curr.next != null){
            curr = curr.next;
            count++;
        }
        session = curr;
        return curr.val;
    }
}

class DoublyLinkedList{
    String val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(String val){
        this.val = val;
        next = null;
        prev = null;
    }
}

