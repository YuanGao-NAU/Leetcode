package greedy;

public class Leetcode10 {

    boolean isMatch(String s, String p) {

        if(p.equals(".*")) return true;

        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        return isMatch(sChar, pChar, 0 ,0);
    }

    boolean isMatch(char[] s, char[] t, int i, int j) {
        if(s.length == i && t.length == j) return true;
        if(s.length == i) {
            int diff = t.length - j;
            if(diff % 2 != 0) return false;
            for(int k = j; k < t.length; k+=2) {
                if(t[k+1] != '*') return false;
            }
            return true;
        }

        if(t.length == j) return false;

//        char star = (j+1) < t.length ? t[j+1] : 'A';

        if(j+1 < t.length && t[j+1] == '*') {
            if(s[i] == t[j] || t[j] == '.') {
                        //尝试匹配多个字符                匹配0个字符
                return isMatch(s, t, i+1, j) || isMatch(s, t, i, j+2);
            } else {
                return isMatch(s, t, i, j+2);
            }
        } else {
            if(s[i] == t[j] || t[j] == '.') {
                return isMatch(s, t, i+1, j+1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode10 leetcode10 = new Leetcode10();
//        String s = "aab";
//        String t = "c*a*b";
//        String s = "mississippi";
//        String t = "mis*is*p*.";
        String s = "aaaaaaaaaaaaaaaaaaab";
        String t = "a*a*a*a*a*a*a*a*a*a*";
//        String s = "aaaaaaaab";
//        String t = "a*a*a*a*a*";
        System.out.println(leetcode10.isMatch(s, t));
    }
}
