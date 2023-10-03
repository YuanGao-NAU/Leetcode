package greedy;

public class Leetcode415 {

    public static String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();

        int i = ch1.length-1;
        int j = ch2.length-1;

        boolean flag = false;

        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0) {
            int x = i >= 0 ? ch1[i]-'0' : 0;
            int y = j >= 0 ? ch2[j]-'0' : 0;

            int sum = x+y + (flag?1:0);
            flag = false;
            if(sum >= 10) {
                sum -= 10;
                flag = true;
            }
            sb.append(sum);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";

        System.out.println(Leetcode415.addStrings(num1, num2));
    }
}
