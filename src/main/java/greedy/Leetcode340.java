package greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode340 {

    public int solution(String s, int k) {
        if(k == 0) return 0;
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();

        char[] sArray = s.toCharArray();

        int left = 0;
        int right = 0;
        int res = 0;
        int temp = 0;

        for(right = 0; right < sArray.length; right++) {
            temp = map.getOrDefault(sArray[right], 0);
            map.put(sArray[right], temp+1);
            if(map.size() == k) {
                res = Math.max(right-left+1, res);
            }

            while(map.size() > k) {
                temp = map.get(sArray[left]);
                if(temp-1 == 0) {
                    map.remove(sArray[left]);
                } else {
                    map.put(sArray[left], temp-1);
                }
                left++;
            }
        }

        return Math.max(res, right-left);
    }

    public static void main(String[] args) {
        Leetcode340 leetcode340 = new Leetcode340();
        int res = leetcode340.solution("ecebbbbba", 2);
        System.out.println(res);
    }
}
