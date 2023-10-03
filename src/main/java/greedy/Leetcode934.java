package greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode934 {

    private int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    break;
                }
            }
            if(!queue.isEmpty()) break;
        }

        for(int[] loc : queue) {
            System.out.println(loc[0] + ", " + loc[1]);
        }

        int res = 0;
        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while(size > 0) {
                size--;
                int[] loc = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int x = loc[0] + dirs[i];
                    int y = loc[1] + dirs[i+1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                        if(grid[x][y] == 2) {
                            continue;
                        } else if(grid[x][y] == 1) {
                            return res;
                        }
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
        }

        return 0;
    }

    private void dfs(int[][] grid, int row, int col, Queue<int[]> queue) {
        if(grid[row][col] == 2) return;

        if(grid[row][col] == 0) {
            grid[row][col] = 2;
            queue.offer(new int[]{row, col});
            return;
        }

        grid[row][col] = 2;

        for(int i = 0; i < 4; i++) {
            int x = row + dirs[i];
            int y = col + dirs[i+1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                dfs(grid, x, y, queue);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode934 leetcode934 = new Leetcode934();

        int[][] grid = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };

        System.out.println(leetcode934.shortestBridge(grid));
    }
}
