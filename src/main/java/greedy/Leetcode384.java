package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode384 {

    private int[] nums;

    public Leetcode384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;

    }

    public int[] shuffle() {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
