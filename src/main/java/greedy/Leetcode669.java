package greedy;

public class Leetcode669 {

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if(root.val < low) {
            root = root.right;
        }

        if(root != null && root.val > high) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1, t0, t2);

        Leetcode669.trimBST(t1, 1, 2);
    }
}
