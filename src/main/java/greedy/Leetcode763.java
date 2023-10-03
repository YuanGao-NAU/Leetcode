package greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode763 {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return null;
        if(s.length() == 1) return Arrays.asList(1);

        char[] c = s.toCharArray();
        int[] map = new int[26];
        for(int i = 0; i < c.length; i++) {
            map[c[i]-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int curMaxLoc = 0;
        for(int i = 0; i < c.length; i++) {
            curMaxLoc = Math.max(map[c[i]-'a'], curMaxLoc);
            if(curMaxLoc == i) {
                res.add(i-left+1);
                left = i+1;
                curMaxLoc = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode763 leetcode763 = new Leetcode763();
        String s = "ababcbacadefegdehijhklij";
        String s1 = "eccbbbbdec";
        List<Integer> list = leetcode763.partitionLabels(s);
        System.out.println(list);
    }
}
