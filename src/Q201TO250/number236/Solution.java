package Q201TO250.number236;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 13:26
 * @description: TODO
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;

        if (root != null) {
            TreeNode leftSon = lowestCommonAncestor(root.left, p, q);
            TreeNode rightSon = lowestCommonAncestor(root.right, p, q);

            // 左右子树各占一个
            if (leftSon != null && rightSon != null) {
                return root;
            }
            // 右子树占两个
            else if (leftSon == null) {
                return rightSon;
            }
            // 左子树占两个
            else {
                return leftSon;
            }
        }
        else {
            return null;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
