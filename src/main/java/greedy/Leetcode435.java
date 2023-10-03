package greedy;

import java.util.Arrays;

public class Leetcode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)-> o2[0] - o1[0]);

        int removed = 0;
        int prev = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < prev) {
                removed++;
            } else {
                prev = intervals[i][1];
            }
        }

        return removed;
    }
}
