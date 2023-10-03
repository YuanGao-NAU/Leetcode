package greedy;

import java.util.Arrays;
import java.util.Map;

public class Leetcode882 {

    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[] distances = new int[n];
        boolean[] book = new boolean[n];
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }

        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int d = edges[i][2]+1;
            map[x][y] = d;
            map[y][x] = d;
        }

        for(int i = 0; i < n; i++) {
            distances[i] = map[0][i];
        }
        book[0] = true;

        int shortest = Integer.MAX_VALUE;
        int id = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                if(!book[j] && map[0][j] != Integer.MAX_VALUE) {
                    if(map[0][j] < shortest) {
                        shortest = map[0][j];
                        id = j;
                    }
                }
            }

            book[id] = true;

            for(int j = 1; j < n; j++) {
                if(distances[j] > distances[id] + map[id][j]) {
                    distances[j] = distances[id]+ map[id][j];
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(distances[i] <= maxMoves) res++;
        }

        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            int c1 = Math.max(0, maxMoves-distances[x]);
            int c2 = Math.max(0, maxMoves-distances[y]);
            res += Math.min(edges[i][2], c1 + c2);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {0, 1, 10},
                {0, 2, 1},
                {1, 2, 2}
        };

        Leetcode882.reachableNodes(edges, 6, 3);
    }
}
