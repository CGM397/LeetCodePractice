package Q501TO550.number530;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/10/12 9:04
 * @description: 树
 */
public class Solution {

    private List<Integer> store = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < store.size() - 1; i++) {
            int tmp = store.get(i + 1) - store.get(i);

            if (tmp < res) res = tmp;
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        store.add(root.val);
        dfs(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
