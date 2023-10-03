package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode451 {

    public String frequencySort(String s) {
        char[] sArray = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for(char c : sArray) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        Queue<Character> queue = new PriorityQueue<>((c1, c2)->map.get(c2)-map.get(c1));

        for(char c : map.keySet()) {
            queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            char c = queue.poll();
            int count = map.get(c);
            while(count-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode451 leetcode451 = new Leetcode451();
        String s = "abcdd";
        System.out.println(leetcode451.frequencySort(s));
    }
}
