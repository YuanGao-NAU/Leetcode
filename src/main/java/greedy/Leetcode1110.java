package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode1110 {

    List<TreeNode> res = new ArrayList<>();
    Set<Integer> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();

        for(int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        dfs(root);
        return res;
    }

    public boolean dfs(TreeNode root) {
        if(root == null) return false;

        boolean flag = false;

        flag = dfs(root.left) || dfs(root.right);

        if(set.contains(root.val)) {
            res.add(root.left);
            res.add(root.right);
            return true;
        }

        return flag;
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        Leetcode1110 leetcode1110 = new Leetcode1110();
        leetcode1110.delNodes(t1, new int[]{3, 5});
    }
}
