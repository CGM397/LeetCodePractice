package Q251TO300.number257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/9/4 19:39
 * @description: 二叉树
 */
public class Solution {

    private List<String> res = new ArrayList<>();
    private Stack<Integer> one = new Stack<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            one.push(root.val);
            StringBuilder str = new StringBuilder();
            boolean first = true;
            for (Integer s : one) {
                if (first) first = false;
                else str.append("->");
                str.append(s);
            }
            res.add(str.toString());
            one.pop();
            return;
        }
        if (root.right != null) {
            one.push(root.val);
            dfs(root.right);
            one.pop();
        }
        if (root.left != null) {
            one.push(root.val);
            dfs(root.left);
            one.pop();
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
