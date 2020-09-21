package Q501TO550.number538;

/**
 * @author: Bright Chan
 * @date: 2020/9/21 21:00
 * @description: 反向中序遍历：右，根，左
 */
public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
