package greedy;

import java.util.*;

public class Leetcode417 {

    int[] dirs = {-1, 0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] canMovePacific = new boolean[rows][cols];
        boolean[][] canMoveAtlantic = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < rows; i++) {
            dfs(heights, canMovePacific, i, 0);
            dfs(heights, canMoveAtlantic, i, cols-1);
        }

        for(int i = 0; i < cols; i++) {
            dfs(heights, canMovePacific, 0, i);
            dfs(heights, canMoveAtlantic, rows-1, i);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(canMovePacific[i][j] && canMoveAtlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] canMove, int i, int j) {

        if(canMove[i][j]) return;

        int rows = heights.length;
        int cols = heights[0].length;
        canMove[i][j] = true;

        for(int k = 0; k < 4; k++) {
            int x = i + dirs[k];
            int y = j + dirs[k+1];

            if(x >= 0 && x < rows && y >= 0 && y < cols) {
                if(heights[x][y] >= heights[i][j]) {
                    dfs(heights, canMove, x, y);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        Leetcode417 leetcode417 = new Leetcode417();

        List<List<Integer>> res = leetcode417.pacificAtlantic(heights);
        for(List<Integer> list : res) {
            System.out.print(list.get(0) + ", " + list.get(1) + "\n");
        }
        System.out.println();
    }
}
