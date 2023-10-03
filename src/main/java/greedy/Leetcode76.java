package greedy;

import java.util.*;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        if(s == null) return null;
        if(s.equals(t)) return s;

        char[] sArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> locs = new ArrayList<>();

        for(int i = 0; i < t.length(); i++) {
            int temp = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), temp+1);
        }

        for(int i = 0; i < sArray.length; i++) {
            if(map.containsKey(sArray[i])) {
                locs.add(i);
            }
        }

        if(locs.size() == 0) return "";

        int left = locs.get(0);
        int count = map.size();
        int resLength = s.length();
        String res = "";

        for(int i = left; i < sArray.length; i++) {
            if(map.containsKey(sArray[i])) {
                int temp = map.get(sArray[i])-1;
                map.put(sArray[i], temp);

                if(temp == 0) {
                    count--;
                }
                while(count <= 0) {
                    if(i-left+1 <= resLength) {
                        resLength = i-left+1;
                        res = s.substring(left, i + 1);
                    }
                    temp = map.get(sArray[left])+1;
                    if(temp > 0) {
                        count++;
                    }
                    map.put(sArray[left], temp);
                    if(locs.size() != 0) {
                        locs.remove(0);
                        if(locs.size() == 0) {
                            return res;
                        } else {
                            left = locs.get(0);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        String res = leetcode76.minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(res);
    }
}
