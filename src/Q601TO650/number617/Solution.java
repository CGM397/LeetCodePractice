package Q601TO650.number617;

/**
 * @author: Bright Chan
 * @date: 2020/9/23 9:08
 * @description: 深搜
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            dfs(t1, t2);
        }
        else if (t1 == null) return t2;
        else return t1;

        return t1;
    }

    private void dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return;

        if (t1.left != null) {
            if (t2.left != null) {
                t1.left.val += t2.left.val;
                dfs(t1.left, t2.left);
            }
        }
        else {
            if (t2.left != null) t1.left = t2.left;
        }

        if (t1.right != null) {
            if (t2.right != null) {
                t1.right.val += t2.right.val;
                dfs(t1.right, t2.right);
            }
        }
        else {
            if (t2.right != null) t1.right = t2.right;
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
