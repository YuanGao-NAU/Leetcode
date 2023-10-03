package greedy;

public class Leetcode504 {

    public static String convertToBase7(int num) {
        if(num == 0) return ""+0;

        boolean flag = false;

        if(num < 0) {
            num = -num;
            flag = true;
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append(num%7);
            num /= 7;
        } while(num != 0);

        return flag ? "-" + sb.reverse() : sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Leetcode504.convertToBase7(56*56));
    }
}
