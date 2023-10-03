package greedy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;

        if(s.length() <= 1) return s.length();

        char[] sArray = s.toCharArray();

        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;

        for(int i = 0; i < sArray.length; i++) {
            int temp = map.getOrDefault(sArray[i], 0);
            if(temp >= 1) {
                while(sArray[left] != sArray[i]) {
                    map.remove(sArray[left]);
                    left++;
                }
                left++;
            } else {
                map.put(sArray[i], temp+1);
            }
            res = Math.max(res, i-left+1);
        }

        return res;
    }

    public static void main(String[] args) {
//        String s1 = "abcabcbb";
//        String s2 = "bbbbb";
//        String s3 = "pwwkew";
        String s4 = "tmmzuxt";
//        System.out.println(Leetcode3.lengthOfLongestSubstring(s1));
//        System.out.println(Leetcode3.lengthOfLongestSubstring(s2));
//        System.out.println(Leetcode3.lengthOfLongestSubstring(s3));
        System.out.println(Leetcode3.lengthOfLongestSubstring(s4));
    }
}
