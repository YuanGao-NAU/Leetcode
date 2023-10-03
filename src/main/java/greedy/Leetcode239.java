package greedy;

import java.util.*;

public class Leetcode239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length;
        int m = n-k+1;
        int[] ans = new int[m];

        for(int i = 0; i < n; i++) {
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]) {
                d.pollLast();
            }

            d.offerLast(i);

            if(i >= k-1) {
                while (!d.isEmpty() && d.peekFirst() <= i - k) {
                    d.pollFirst();
                }
                ans[i-k+1] = nums[d.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Leetcode239.maxSlidingWindow(nums, 3);

        Deque<Integer> deque = new ArrayDeque<>();
    }
}
