package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode646 {

    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int removed = 0;
        int prev = pairs[0][1];
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] <= prev) {
                removed++;
            } else {
                prev = pairs[i][1];
            }
        }

        return pairs.length - removed;
    }
}
