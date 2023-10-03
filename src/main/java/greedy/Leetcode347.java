package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[] res = new int[k];

        Queue<Integer> queue = new PriorityQueue<>((o1, o2)->map.get(o2)-map.get(o1));

        for(int num : map.keySet()) {
            queue.offer(num);
        }

        for(int i = 0; i < k; i++) {
            if(!queue.isEmpty()) {
                res[i] = queue.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Leetcode347 leetcode347 = new Leetcode347();
        int[] res = leetcode347.topKFrequent(nums, k);
        for(int i = 0; i < k; i++) {
            System.out.print(res[i]);
            System.out.println('\t');
        }
    }
}
