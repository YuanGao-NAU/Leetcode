package greedy;

public class Leetcode67 {

    public static String addBinary(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();

        int i = c1.length-1;
        int j = c2.length-1;

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        while(i >= 0 || j >= 0) {
            int x = i >= 0 ? c1[i]-'0' : 0;
            int y = j >= 0 ? c2[j]-'0' : 0;

            int sum = x + y + flag;
            flag = 0;
            if(sum >= 2) {
                sum = sum - 2;
                flag = 1;
            }
            sb.append(sum);
            i --;
            j --;
        }

        if(flag == 1) sb.append(flag);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Leetcode67.addBinary("1010", "1011"));
    }
}
