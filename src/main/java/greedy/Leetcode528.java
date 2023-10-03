package greedy;

import java.util.Arrays;
import java.util.Random;

public class Leetcode528 {

    private int[] nums;

    private int length;

    public Leetcode528(int[] w) {
        length = Arrays.stream(w).sum();
        nums = new int[length];
        int j = 0;
        for(int i = 0; i < w.length; i++) {
            int count = w[i];
            while(count > 0) {
                nums[j++] = i;
                count--;
            }
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int randInt = r.nextInt(length);
        return nums[randInt];
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        Leetcode528 leetcode528 = new Leetcode528(nums);

    }
}
