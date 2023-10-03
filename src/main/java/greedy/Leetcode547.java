package greedy;

import java.util.*;

public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {

        if (isConnected.length == 1) return 1;
        int rows = isConnected.length;
        int cols = isConnected[0].length;

        int[] visited = new int[rows];
        int res = 0;

        for(int i = 0; i < rows; i++) {
            if(visited[i] == 0) {
                dfs(isConnected, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        visited[i] = 1;
        for(int j = 0; j < visited.length; j++) {
            if(isConnected[i][j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        set.add(test1);
        set.add(test2);
        System.out.println(set.size());
    }
}
