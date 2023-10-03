package greedy;

import java.util.*;

public class Leetcode870 {

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[nums1.length];

        for(int i = 0;  i < nums1.length; i++) {
            set.add(nums1[i]);
            int temp = map.getOrDefault(nums1[i], 0) + 1;
            map.put(nums1[i], temp);
        }

        for(int i = 0 ; i < nums2.length; i++) {
            Integer temp = set.ceiling(nums2[i]+1);
            if(temp == null) {
                temp = set.ceiling(-1);
            }
            res[i] = temp;
            map.put(temp, map.get(temp)-1);
            if(map.get(temp) == 0) set.remove(temp);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        Leetcode870.advantageCount(nums1, nums2);

    }
}
