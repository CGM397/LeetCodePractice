package Q101TO150.number113;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2020/9/26 17:00
 * @description: 深搜
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> oneRes = new Stack<>();
    private int count = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;

        count += root.val;
        oneRes.push(root.val);

        if (count == sum) {
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(oneRes));
            }
        }

        if (root.right != null) {
            dfs(root.right, sum);
        }
        if (root.left != null) {
            dfs(root.left, sum);
        }

        count -= root.val;
        oneRes.pop();
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
