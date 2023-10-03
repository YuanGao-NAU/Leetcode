package greedy;

public class Leetcode530 {

    TreeNode pre = null;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root == null) return res;

        getMinimumDifference(root.left);

        if(pre != null) {
            System.out.println(pre.val + ", " + root.val);
            res = Math.min(res, Math.abs(root.val - pre.val));
        }
        pre = root;

        getMinimumDifference(root.right);

        return res;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, t3);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t4 = new TreeNode(4, t2, t6);

        Leetcode530 leetcode530 = new Leetcode530();
        leetcode530.getMinimumDifference(t4);
    }
}
