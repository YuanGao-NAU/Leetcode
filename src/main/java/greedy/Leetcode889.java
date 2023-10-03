package greedy;

public class Leetcode889 {

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 1) return new TreeNode(preorder[0]);

        return helper(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }

    public static TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if(preStart > preEnd) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);

        int leftLen = 0;
        for(int i = postStart; i <= postEnd; i++) {
            leftLen++;
            if(preorder[preStart+1] == postorder[i]) {
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(preorder, postorder, preStart+1, preStart+leftLen, postStart, postStart+leftLen-1);
        root.right = helper(preorder, postorder, preStart+leftLen+1, preEnd, postStart+leftLen, postEnd-1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

//        int[] preorder = {1,2,4,5,3,6,7};
//        int[] postorder = {4,5,2,6,7,3,1};

        int[] preorder = {1,2,4,5,3};
        int[] postorder = {4,5,2,3,1};

        Leetcode889.constructFromPrePost(preorder, postorder);
    }
}
