package greedy;

public class Leetcode72 {

    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) return 0;

        int m = word1.length();
        int n = word2.length();

        //dp数组dp[i][j]表示当word1在i，word2在j时二者相等，需要的编辑次数
        int[][] dp = new int[n+1][m+1];

        char c1, c2;

        for(int i = 0; i <= m; i++) {
            c1 = word1.charAt(i-1);
            for(int j = 0; j <= n; j++) {
                c2 = word2.charAt(j-1);
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            dp[i-1][j-1] + (c1 == c2 ? 0 : 1),
                            Math.min(dp[i-1][j]+1, dp[i][j-1]+1)
                    );
                }
            }
        }
        return dp[m][n];
    }
}
