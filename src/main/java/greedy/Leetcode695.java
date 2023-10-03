package greedy;

import java.util.Stack;

public class Leetcode695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int currentArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j ++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    stack.push(new int[]{i, j});
                    while(!stack.isEmpty()) {
                        currentArea++;
                        int[] loc = stack.pop();
                        for(int k = 0; k < 4; k++) {
                            int x = loc[0] + dirs[k];
                            int y = loc[1] + dirs[k+1];
                            if(x >= 0 && x < rows && y >= 0 && y < cols) {
                                if(grid[x][y] == 1) {
                                    grid[x][y] = 0;
                                    stack.push(new int[]{x, y});
                                }
                            }
                        }
                    }
                    max = Math.max(max, currentArea);
                    currentArea = 0;
                }
            }
        }
        return max;
    }
}
