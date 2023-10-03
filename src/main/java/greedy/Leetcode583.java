package greedy;

import java.util.Arrays;

public class Leetcode583 {

    int[][] cache;

    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0) return 0;

        cache = new int[word1.length()][word2.length()];

        for(int i = 0; i < word1.length(); i++) {
            Arrays.fill(cache[i], Integer.MIN_VALUE);
        }

        int commonLength = dfs(word1, word2, 0, 0);
        return word1.length() + word2.length() - 2*commonLength;
    }

    private int dfs(String word1, String word2, int i, int j ) {
        if(i == word1.length() || j == word2.length()) {
            return 0;
        }

        if(cache[i][j] != Integer.MIN_VALUE) {
            return cache[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            cache[i][j] = 1+dfs(word1, word2, i+1, j+1);
            return cache[i][j];
        } else {
            cache[i][j] = Math.max(dfs(word1, word2, i, j+1), dfs(word1, word2, i+1, j));
            return cache[i][j];
        }
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        Leetcode583 leetcode583 = new Leetcode583();
        int res = leetcode583.minDistance(s1, s2);
        System.out.println(res);
    }
}
