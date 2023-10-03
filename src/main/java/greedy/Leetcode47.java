package greedy;

import java.util.*;

public class Leetcode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        dfs(nums, visited, temp, res);

        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {

            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            temp.add(nums[i]);
            dfs(nums, visited, temp, res);
            visited[i] = false;
            temp.remove(temp.size()-1);

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Leetcode47 leetcode47 = new Leetcode47();
        leetcode47.permuteUnique(nums);
    }
}
