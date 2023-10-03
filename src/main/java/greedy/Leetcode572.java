package greedy;

public class Leetcode572 {

    static TreeNode originSubRoot;

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        boolean res = false;

        if(root.val == subRoot.val) {
            res =  helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
        }

        return res || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public static boolean helper(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val == subRoot.val) {
            return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4, t1, t2);
        TreeNode t3 = new TreeNode(3, t4, t5);

        boolean res = Leetcode572.isSubtree(t3, t4);
        System.out.println(res);
    }
}
