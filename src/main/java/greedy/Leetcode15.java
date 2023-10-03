package greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int k = 0;
        int  i = 1;
        int j = nums.length-1;

        for(k = 0; k < nums.length-2; k++) {
            if(k > 0 && nums[k] == nums[k-1]) continue;
            i = k+1;
            j = nums.length-1;
            while(i < j) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    i++;
                    while(i < j && nums[i] == nums[i-1]) {
                        i++;
                    }
                } else if(sum > 0) {
                    j--;
                    while(i < j && nums[j] == nums[j+1]) {
                        j--;
                    }
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i-1]) {
                        i++;
                    }
                    while(i < j && nums[j] == nums[j+1]) {
                        j--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};


        Leetcode15.threeSum(nums);
    }
}
