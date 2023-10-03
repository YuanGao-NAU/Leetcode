package greedy;

import java.util.ArrayList;
import java.util.List;

public class BipartiteMaxMatch {

    private int e[][] = new int[101][101];
    private int match[] = new int[101];
    private boolean book[] = new boolean[101];

    int n, m;

    public boolean dfs(int u) {
        int i;
        for(i = 1; i <= n; i++) {
            if(book[i] && e[u][i] == 1) {
                book[i] = true;
                if(match[i] == 0 || dfs(match[i])) {
                    match[i] = u;
                    match[u] = i;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
