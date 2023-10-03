package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matches {

    public void solution(int m) {

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i <= 11111; i++) {
            for(int j = 0; j <= 11111; j++) {
                int sum = i + j;
                int total = helper(i) + helper(j) + helper(sum);
                if(total == m-4) {
                    res.add(Arrays.asList(i, j, sum));
                }
            }
        }
        for(List<Integer> r : res) {
            System.out.println(r.get(0) + " + " + r.get(1) + " = " + r.get(2));
        }
    }

    public int helper(int x) {

        int[] cost = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        int res = 0;

        while(x/10 != 0) {
            res += cost[x%10];
            x = x/10;
        }
        res += cost[x];
        return res;
    }

    public static void main(String[] args) {
        Matches matches = new Matches();
        matches.solution(18);
    }
}
