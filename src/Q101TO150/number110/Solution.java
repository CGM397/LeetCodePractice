package Q101TO150.number110;

/**
 * @author: Bright Chan
 * @date: 2020/8/17 10:34
 * @description: 判断是否是平衡二叉树
 */
public class Solution {

    private int maxHeight = 0;
    private int height = 0;
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (!res || root == null) return;

        int leftHeight = 0, rightHeight = 0;
        if (root.left != null) {
            maxHeight = height = 0;
            getMaxHeight(root.left);
            leftHeight = maxHeight + 1;
        }
        if (root.right != null) {
            maxHeight = height = 0;
            getMaxHeight(root.right);
            rightHeight = maxHeight + 1;
        }
        if (Math.abs(rightHeight - leftHeight) > 1) {
            res = false;
            return;
        }

        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
    }

    private void getMaxHeight(TreeNode root) {
        if (root.left != null) {
            height++;
            if (height > maxHeight) maxHeight = height;
            getMaxHeight(root.left);
            height--;
        }
        if (root.right != null) {
            height++;
            if (height > maxHeight) maxHeight = height;
            getMaxHeight(root.right);
            height--;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
