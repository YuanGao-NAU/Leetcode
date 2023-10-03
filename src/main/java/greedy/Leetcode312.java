package greedy;

public class Leetcode312 {

    public static int maxCoins(int[] nums) {
        return f(nums);
    }

    public static int f(int[] nums) {
        switch(nums.length) {
            case 1:
                return nums[0];
            case 2:
                if(nums[0] > nums[1]) {
                    return nums[0]*nums[1] + nums[0];
                } else {
                    return nums[0]*nums[1] + nums[1];
                }
            case 3:
                return nums[0]*nums[1]*nums[2] + f(new int []{nums[0], nums[2]});
            default:
                int loc = 0;
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < nums.length; i++) {
                    if(nums[i] < min) {
                        loc = i;
                        min = nums[i];
                    }
                }
                int[] newNums = new int[nums.length-1];
                int count = 0;
                for(int i = 0; i < nums.length; i++) {
                    if(i != loc) {
                        newNums[count++] = nums[i];
                    }
                }
                if(loc == 0) {
                    return nums[loc] * nums[loc+1] + f(newNums);
                } else if(loc == nums.length-1) {
                    return nums[loc] * nums[loc - 1] + f(newNums);
                } else {
                    return nums[loc-1]*nums[loc]*nums[loc+1] + f(newNums);
                }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(Leetcode312.maxCoins(nums));
    }
}
