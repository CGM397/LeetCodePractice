package Q101TO150.number107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Bright Chan
 * @date: 2021/3/6 22:42
 * @description: 广搜
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        while (!queue.isEmpty()) {
            List<Integer> store = new ArrayList<>();
            int len = num;
            num = 0;
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                store.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    num++;
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    num++;
                }
            }
            res.add(store);
        }
        List<List<Integer>> realRes = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            realRes.add(res.get(i));
        }
        return realRes;
    }

    public static class TreeNode {
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
