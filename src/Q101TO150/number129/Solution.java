package Q101TO150.number129;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/10/29 10:09
 * @description: 深搜
 */
public class Solution {

    Stack<Integer> store = new Stack<>();
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        store.add(root.val);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        if (root.left == null && root.right == null) {
            res += stringToInt();
        }
        store.pop();
    }

    private int stringToInt() {
        StringBuilder tmp = new StringBuilder();

        for (int i : store) {
            tmp.append(i);
        }
        return Integer.parseInt(tmp.toString());
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
