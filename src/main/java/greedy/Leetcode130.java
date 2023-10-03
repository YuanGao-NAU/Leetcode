package greedy;

public class Leetcode130 {

    int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public void solve(char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
            if(board[i][board[0].length-1] == 'O') {
                dfs(board, visited, i, board[0].length-1);
            }
        }

        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                dfs(board, visited, 0, i);
            }
            if(board[board.length-1][i] == 'O') {
                dfs(board, visited, board.length-1, i);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col) {
        if(visited[row][col]) return;

        visited[row][col] = true;

        if(board[row][col] == 'O') {
            board[row][col] = 'Y';
        }

        for(int i = 0; i < 4; i++) {
            int x = row + dirs[i];
            int y = col + dirs[i+1];

            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if(board[x][y] == 'O') {
                    dfs(board, visited, x, y);
                }
            }
        }
    }
}
