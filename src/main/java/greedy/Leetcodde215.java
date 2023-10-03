package greedy;

import java.util.Arrays;

public class Leetcodde215 {
    public int findKthLargest(int[] nums, int k) {
        nums = Arrays.stream(nums).boxed().sorted((o1, o2)->o2-o1).mapToInt(p->p).toArray();
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = a.clone();
    }

}
