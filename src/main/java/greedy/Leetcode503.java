package greedy;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode503 {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        int j = 0;

        while(j <= 1) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty()) {
                    int temp = stack.peek();
                    if(nums[i] > nums[temp]) {
                        res[temp] = i+1;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if(res[i] == -1) {
                    stack.push(i);
                }
            }
            j++;
            if(stack.isEmpty()) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        Leetcode503.nextGreaterElements(nums);
    }
}
