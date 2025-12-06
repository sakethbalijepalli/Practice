package DatastructuresAndAlgorithms.Queues;

public class DoubleEndedQueue {
    int val;
    DoubleEndedQueue next;
    DoubleEndedQueue prev;

    public DoubleEndedQueue(int val){
        this.val = val;
        next = null;
        prev = null;
    }
}
