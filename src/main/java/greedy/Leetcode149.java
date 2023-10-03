package greedy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode149 {

    public static int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();

        double k = 0;
        int res = 1;
        for(int j = 0; j < points.length-1; j++) {
            for (int i = j+1; i < points.length; i++) {
                int count = 0;
                if (points[j][0] == points[i][0]) {
                    count = map.getOrDefault(Double.MAX_VALUE, 1) + 1;
                    map.put(Double.MAX_VALUE, count);
                    res = Math.max(count, res);
                } else if (points[j][1] == points[i][1]) {
                    count = map.getOrDefault(0.0, 1) + 1;
                    map.put(0.0, count);
                    res = Math.max(count, res);
                } else {
                    k = (points[j][1] - points[i][1]) / 1.0 / (points[j][0] - points[i][0]);
                    count = map.getOrDefault(k, 1) + 1;
                    map.put(k, count);
                    res = Math.max(count, res);
                }
            }
            map.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1,1},
                {2,2},
                {3,3}
        };
        Leetcode149.maxPoints(points);
    }
}
