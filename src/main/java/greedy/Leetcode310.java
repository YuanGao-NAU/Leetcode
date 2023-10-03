package greedy;

import java.util.*;

public class Leetcode310 {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        int[] degree = new int[n];

        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            List<Integer> temp = edgeMap.getOrDefault(x, new ArrayList<>());
            temp.add(y);
            edgeMap.put(x, temp);
            temp = edgeMap.getOrDefault(y, new ArrayList<>());
            temp.add(x);
            edgeMap.put(y, temp);
            degree[x]++;
            degree[y]++;
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            res.clear();
            while(size-- > 0) {
                int x = q.poll();
                res.add(x);
                for(int i : edgeMap.get(x)) {
                    degree[i]--;
                    if(degree[i] == 1) {
                        q.offer(i);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4}
        };

        Leetcode310.findMinHeightTrees(n, edges);
    }
}
