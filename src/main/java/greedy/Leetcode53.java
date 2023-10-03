package greedy;

public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
            if(dp[i] < dp[i-1]) {
                res = Math.max(res, dp[i-1]);
            }
        }
        return Math.max(res, dp[nums.length]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};
        Leetcode53 leetcode53 = new Leetcode53();
        leetcode53.maxSubArray(nums);
    }
}
