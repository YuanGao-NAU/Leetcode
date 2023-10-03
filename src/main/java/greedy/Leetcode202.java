package greedy;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int cur = squareSum(n);
        if(cur == 1) return true;

        while(cur != 1) {
            if(set.contains(cur)) {
                return false;
            }
            set.add(cur);
            cur = squareSum(cur);
        }
        return true;
    }

    public int squareSum(int n) {
        int sum = 0;

        while(n != 0) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Leetcode202 leetcode202 = new Leetcode202();
        leetcode202.isHappy(2);
    }
}
