package greedy;

public class Leetcode326 {

    public static boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n <= 2) return false;

        if(n % 3 != 0) return false;

        while(n >= 3) {
            int mod = n % 3;
            if(mod != 0) return false;
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(Leetcode326.isPowerOfThree(45));
    }
}
