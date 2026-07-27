package Neetcode.blind75;

import java.util.*;

public class InsertInterval {
    void main() {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {4, 6}}, new int[]{2, 5})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        output.add(newInterval);
        while (i < n) {
            output.add(intervals[i]);
            i++;
        }

        return output.toArray(int[][]::new);
    }
}
