package greedy;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {

    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return list;
        findPaths(root, false);
        return list;
    }

    public void findPaths(TreeNode root, boolean nullLeft) {
        if(root == null) {
            if (nullLeft) {
                list.add(sb.toString().replaceFirst("->", ""));
            }
            return;
        }

        sb.append("->" + root.val);
        boolean flag = root.left == null;
        findPaths(root.left, false);
        findPaths(root.right, flag);
        sb.setLength(sb.length()- 2 - String.valueOf(root.val).length());
    }
}
