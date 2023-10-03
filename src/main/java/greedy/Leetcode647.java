package greedy;

public class Leetcode647 {

    public static int countSubstrings(String s) {

        int len = s.length();
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        int count = 0;

        for(int i = 0; i < len; i++) {
            int j = i;
            int k = i;
            while(j >= 0 && c[j] == c[i]) {
                dp[i][j] = true;
                dp[j][i] = true;
                j--;
            }

            while(k < c.length && c[k] == c[i]) {
                dp[i][k] = true;
                dp[k][i] = true;
                k++;
            }

            while(j >= 0 && k < c.length && c[k] == c[j]) {
                dp[k][j] = true;
                dp[j][k] = true;
                j--;
                k++;

            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                count += dp[i][j] ? 1: 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aba";
        Leetcode647.countSubstrings(s);
    }
}
