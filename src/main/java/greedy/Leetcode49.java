package greedy;

import java.util.*;

public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] ch  = str.toCharArray();
            Arrays.sort(ch);

            List<String> temp = map.getOrDefault(Arrays.toString(ch), new ArrayList<>());
            temp.add(str);
            map.put(Arrays.toString(ch), temp);
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v)-> res.add(v));
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";

    }
}
