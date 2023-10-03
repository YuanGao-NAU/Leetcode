package greedy;

public class Leetcode343 {

    public int integerBreak(int n) {

        if(n <= 1) return 0;
        if(n == 2) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i], i), dp[j] * dp[i-j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        leetcode343.integerBreak(10);
    }
}
