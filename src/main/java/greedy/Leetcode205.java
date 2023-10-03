package greedy;

import java.util.*;

public class Leetcode205 {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> map1 = new HashMap<>();
        Map<Character, List<Integer>> map2 = new HashMap<>();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            List<Integer> list = map1.getOrDefault(sArray[i], new ArrayList<>());
            list.add(i);
            map1.put(sArray[i], list);
            list = map2.getOrDefault(tArray[i], new ArrayList<>());
            list.add(i);
            map2.put(tArray[i], list);
        }

        for(int i = 0; i < s.length(); i++) {
            List<Integer> list1 = map1.get(s.charAt(i));
            List<Integer> list2 = map2.get(t.charAt(i));
            if(!list1.equals(list2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        Leetcode205.isIsomorphic(s, t);
    }
}
