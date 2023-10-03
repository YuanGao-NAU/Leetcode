package greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        int size = 0;

        while(size < k) {
            q.offer(nums[size]);
            size++;
        }

        for(int i = size; i < nums.length; i++) {
            int res = q.peek();
            if(nums[i] > res) {
                q.poll();
                q.offer(nums[i]);
            }
        }

        return q.peek();
    }
}
