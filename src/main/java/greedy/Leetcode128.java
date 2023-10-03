package greedy;

import java.util.*;

public class Leetcode128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int left = 0;
        int right = 0;
        int res = 0;

        while(!set.isEmpty()) {
            left = set.iterator().next();
            right = left+1;
            while(set.contains(left)) {
                set.remove(left);
                left--;
            }
            while(set.contains(right)) {
                set.remove(right);
                right++;
            }
            res = Math.max(right-left-1, res);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2};
        Leetcode128.longestConsecutive(nums);
    }
}
