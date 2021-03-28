package Q101TO150.number114;

/**
 * @author: Bright Chan
 * @date: 2021/3/26 18:49
 * @description: 树
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        getRes(root);
    }

    private TreeNode getRes(TreeNode root) {
        if (root.left == null && root.right == null) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if (left != null) {
            root.right = left;
            TreeNode tmp = getRes(left);
            tmp.right = right;
            tmp.left = null;
            if (right == null) {
                return tmp;
            }
            else {
                return getRes(right);
            }
        }
        else {
            root.right = right;
            return getRes(right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
