package Q901TO950.number938;

/**
 * @author: Bright Chan
 * @date: 2021/4/27 17:16
 * @description: 深搜
 */
public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }

    private int res = 0;
    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        dfs(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        dfs(root.right, low, high);
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
