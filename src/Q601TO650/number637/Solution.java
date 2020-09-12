package Q601TO650.number637;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/9/12 10:05
 * @description: 二叉树
 */
public class Solution {

    private List<Double> res = new ArrayList<>();
    private List<Long> storeVal = new ArrayList<>();
    private List<Double> storeNum = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(0, root);
        for (int i = 0; i < storeNum.size(); i++) {
            res.add((storeVal.get(i) / storeNum.get(i)));
        }
        return res;
    }

    private void dfs(int pos, TreeNode root) {
        if (root == null) return;

        if (storeVal.size() <= pos) {
            storeVal.add(pos, (long) root.val);
            storeNum.add(pos, 1.0);
        }
        else {
            storeVal.set(pos, (storeVal.get(pos) + root.val));
            storeNum.set(pos, (storeNum.get(pos) + 1.0));
        }

        dfs(pos + 1, root.left);
        dfs(pos + 1, root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
