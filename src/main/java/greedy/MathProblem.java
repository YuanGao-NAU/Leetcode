package greedy;

import java.util.ArrayList;
import java.util.List;

public class MathProblem {

    public List<List<Integer>> solution() {
        boolean[] visited = new boolean[10];
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(visited, temp, res);

        for(List<Integer> r : res) {
            for(int num : r) {
                System.out.print(num);
                System.out.print('\t');
            }
            System.out.println();
        }
        return res;
    }

    private void dfs(boolean[] visited, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == 9) {
            int addA = temp.get(0)*100 + temp.get(1)*10 + temp.get(2);
            int addB = temp.get(3)*100 + temp.get(4)*10 + temp.get(5);
            int sum = temp.get(6)*100 + temp.get(7)*10 + temp.get(8);
            if(addA + addB == sum) {
                res.add(new ArrayList<>(temp));
            }
        }

        for(int i = 1; i <= 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(i);
                dfs(visited, temp, res);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        MathProblem mathProblem = new MathProblem();
        mathProblem.solution();
    }
}
