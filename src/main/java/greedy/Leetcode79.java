package greedy;

public class Leetcode79 {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return false;
        if(board == null || board.length == 0) return false;

        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        boolean[][] visited = new boolean[board.length][board[0].length];

        char[] c = word.toCharArray();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                if(dfs(board, c, 0, new int[]{i, j}, dirs, visited)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] c, int pos, int[] loc, int[] dirs, boolean[][] visited) {
        if(pos == c.length-1) {
            if(board[loc[0]][loc[1]] == c[pos]) return true;
            else return false;
        }

        if(board[loc[0]][loc[1]] != c[pos]) {
            return false;
        }

        boolean result = false;

        for(int i = 0; i < 4; i++) {
            int x = loc[0] + dirs[i];
            int y = loc[1] + dirs[i+1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                visited[x][y] = true;
                result = result || dfs(board, c, pos+1, new int[]{x, y}, dirs, visited);
                visited[x][y] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        char[][] board = new char[][]{{'a'}};
        String word = "ABCCED";

        StringBuilder sb = new StringBuilder();


        Leetcode79 leetcode79 = new Leetcode79();
        System.out.println(leetcode79.exist(board, word));
    }
}
