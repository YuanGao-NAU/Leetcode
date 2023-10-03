package greedy;

public class Leetcode474 {

    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || m == 0 || n == 0) return 0;

        int[][][] dp = new int[strs.length+1][m+1][n+1];

        System.out.println(strs.length+1);
        System.out.println(m+1);
        System.out.println(n+1);

        for(int i = 1; i <= strs.length; i++) {
            for(int j = 1; j <= m; j ++) {
                for(int k = 1; k <= n; k++) {
                    int[] counts = getCounts(strs[i-1]);
                    if(counts[0] <= j && counts[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-counts[0]][k-counts[1]]+1);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] getCounts(String str) {
        int countOne = 0;
        int countZero = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }

        return new int[]{countZero, countOne};
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10","0","1"};
        int m = 1;
        int n = 1;
        Leetcode474 leetcode474 = new Leetcode474();
        System.out.println(leetcode474.findMaxForm(strs, m , n));
    }
}
