package greedy;

import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {

    public static List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        List<List<Integer>> list = new ArrayList<>();

        int left = 0;
        int pre = nums[0]-1;
        List<Integer> temp = new ArrayList<>();


        for(int i = 0; i < nums.length; i++){
            if(nums[i] - pre == 1) {
                temp.add(nums[i]);
            } else {
                list.add(new ArrayList(temp));
                temp.clear();
                temp.add(nums[i]);
            }
            pre = nums[i];
        }
        list.add(new ArrayList<>(temp));

        for(List<Integer> l : list) {
            int start = l.get(0);
            int end = l.get(l.size()-1);

            if(start == end) {
                res.add("" + start);
            } else {
                res.add(start + "->" + end);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        Leetcode228.summaryRanges(nums);
    }
}
