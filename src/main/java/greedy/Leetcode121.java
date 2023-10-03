package greedy;

public class Leetcode121 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            res = Math.max(prices[i]-min, res);
        }
        return res;
    }
}
