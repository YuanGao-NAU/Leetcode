package greedy;

import java.util.ArrayList;
import java.util.List;

public class Leetcode241 {

    public List<Integer> diffWaysToCompute(String expression) {
        if(expression == null || expression.length() == 0) return null;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < expression.length(); i++) {
            if(
                    expression.charAt(i) == '+' ||
                            expression.charAt(i) == '-' ||
                            expression.charAt(i) == '*'
            ) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                for(int l : left) {
                    for(int r : right) {
                        if(expression.charAt(i) == '+') {
                            res.add(l + r);
                        } else if(expression.charAt(i) == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }

        if(res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}
