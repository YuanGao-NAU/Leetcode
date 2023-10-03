package greedy;

import java.util.Arrays;

public class Leetcode462 {

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums[nums.length/2];

        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - mid);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,6,5,8,7};
        Leetcode462.minMoves2(nums);
    }
}
