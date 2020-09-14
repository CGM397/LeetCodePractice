package Q51TO100.number94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/9/14 14:27
 * @description: 深搜
 */
public class Solution {

    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        // 左
        if (root.left != null) dfs(root.left);
        // 根
        res.add(root.val);
        // 右
        if (root.right != null) dfs(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
