package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51 {

    public List<List<String>> solveNQueens(int n) {
        if(n <= 0) return null;
        List<List<String>>  res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        List<List<int[]>> intRes = new ArrayList<>();
        List<int[]> intTemp = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(".");
        }

        int[][] unavailable = new int[n][n];

        if(n == 1) {
            res.add(Arrays.asList("Q"));
            return res;
        }
        if(n <= 3) return res;

        dfs(n, intRes, intTemp, unavailable);

        for(List<int[]> list : intRes) {
            for(int[] array : list) {
                temp.add(sb.replace(array[1], array[1]+1, "Q").toString());
                sb.replace(array[1], array[1]+1, ".");
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
        }

        return res;
    }

    private void dfs(int n, List<List<int[]>> res, List<int[]> temp,  int[][] unavailable) {
        if(temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        int row = temp.size();
        for(int i = 0; i < n; i++) {
            if(unavailable[row][i] == 0) {
                updateUnavailableCells(unavailable, row, i, n, 1);
                temp.add(new int[]{row, i});
                dfs(n, res, temp, unavailable);
                temp.remove(temp.size()-1);
                updateUnavailableCells(unavailable, row, i, n, -1);
            }
        }
    }

    private void updateUnavailableCells(int[][] unavailable, int row, int col, int n, int value) {
        int[][] dirs = new int[][]{
                {-1, -1},       //左上
                {1, -1},        //左下
                {-1, 1},        //右上
                {1, 1}          //右下
        };

        for(int i = 0; i < n; i++) {
            unavailable[row][i] += value;
            unavailable[i][col] += value;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < dirs.length; j ++) {
                int x = row + dirs[j][0]*i;
                int y = col + dirs[j][1]*i;
                if(x >= 0 && x < n && y >= 0 && y < n) {
                    unavailable[x][y] += value;
                }
            }
        }
    }

    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        leetcode51.solveNQueens(5);
    }
}
