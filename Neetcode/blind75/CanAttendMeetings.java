package Neetcode.blind75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CanAttendMeetings {
    void main() {
        Interval interval = new Interval(0,30);
        Interval interval1 = new Interval(0,30);
//        Interval interval2 = new Interval(15,20);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval);
        intervals.add(interval1);
//        intervals.add(interval2);
        System.out.println(canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }
}
class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
