package Neetcode.neetcode150.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {

    void main() {
        int[][] arr = new int[][]{{0,2},{2,2},{2,0}};
        System.out.println(Arrays.deepToString(kClosest(arr, 2)));
    }


    public int[][] kClosest(int[][] points, int k) {
        // sqrt((x1 - x2)^2 + (y1 - y2)^2))
        // [0,2] [2,0] [2,2]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        // Loop over each point in the points array
        for (int[] point : points) {
            maxHeap.offer(point);

            // If our heap gets larger than k, we remove the element with the largest distance
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Build the final result array from the remaining k elements in the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
