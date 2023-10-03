package greedy;

import java.util.*;

public class Leetcode210 {

    public static int[] findOrder(int numCourses, int[][] p) {
        if(numCourses == 1) return new int[]{0};

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int[] degree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < p.length; i++) {
            List<Integer> temp = map.getOrDefault(p[i][1], new ArrayList<>());
            temp.add(p[i][0]);
            map.put(p[i][1], temp);
            degree[p[i][0]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int i = q.poll();
            res.add(i);
            if(map.containsKey(i)) {
                for(int j : map.get(i)) {
                    degree[j]--;
                    if(degree[j] == 0) {
                        q.offer(j);
                    }
                }
            }
        }
        return res.size() == numCourses ? res.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    public static void main(String[] args) {
        int[][] p = new int[][] {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        List<int[]> list = new ArrayList<>();
        int[][] res = new int[list.size()][];
        res = list.toArray(res);

        Leetcode210.findOrder(4, p);
    }
}
