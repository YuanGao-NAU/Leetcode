package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;

        boolean[] visited = new boolean[n];
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, visited, temp, res);

        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res) {

        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int j = 0; j < nums.length; j++) {
            if(!visited[j]) {
                visited[j] = true;
                temp.add(nums[j]);
                dfs(nums, visited, temp, res);
                visited[j] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Leetcode46 leetcode46 = new Leetcode46();
        leetcode46.permute(nums);
    }
}
