package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        char[] cs = s.toCharArray();
        stack.push(cs[0]);

        for(int i = 1; i < cs.length; i++) {
            if(!stack.isEmpty()) {
                char c1 = stack.peek();
                if (cs[i] == map.get(c1)) {
                    stack.pop();
                } else {
                    stack.push(cs[i]);
                }
            } else {
                stack.push(cs[i]);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(Leetcode20.isValid("()"));
        System.out.println(Leetcode20.isValid("()[]{}"));
        System.out.println(Leetcode20.isValid("(]"));
    }
}
