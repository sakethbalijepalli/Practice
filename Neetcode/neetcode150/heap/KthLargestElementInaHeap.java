package Neetcode.neetcode150.heap;

import java.util.PriorityQueue;


public class KthLargestElementInaHeap {
    private PriorityQueue<Integer> minHeap;
    private int k;

    static void main() {
        KthLargestElementInaHeap kthLargest = new KthLargestElementInaHeap(3, new int[]{1, 2, 3, 3});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(7));
        System.out.println(kthLargest.add(8));
    }

    public KthLargestElementInaHeap(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}