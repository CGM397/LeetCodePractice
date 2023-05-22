package Q1051TO1100.number1080;

/**
 * @author: Solution
 * @date: 2023/5/22 22:16
 * @description: sufficientSubset
 */
public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean haveSufficient = checkSufficientLeaf(root, 0, limit);
        return haveSufficient ? root : null;
    }

    public boolean checkSufficientLeaf(TreeNode node, int sum, int limit) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }
        boolean haveSufficientLeft = checkSufficientLeaf(node.left, sum + node.val, limit);
        boolean haveSufficientRight = checkSufficientLeaf(node.right, sum + node.val, limit);
        if (!haveSufficientLeft) {
            node.left = null;
        }
        if (!haveSufficientRight) {
            node.right = null;
        }
        return haveSufficientLeft || haveSufficientRight;
    }
    public class TreeNode {
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
