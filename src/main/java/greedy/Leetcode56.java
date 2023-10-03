package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)-> {
            if(o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start, end});

        int[][] res = new int[list.size()][];
        res = list.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {2,3},
                {4,5},
                {6,7},
                {8,9},
                {1,10}
        };

        Leetcode56.merge(intervals);
    }
}
