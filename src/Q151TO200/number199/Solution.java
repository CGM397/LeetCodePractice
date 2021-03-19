package Q151TO200.number199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 10:18
 * @description: 二叉树
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);
        int layerNum = 1;

        List<Integer> res = new ArrayList<>();
        while (!store.isEmpty()) {
            List<TreeNode> layerNode = new ArrayList<>();
            for (int i = 0; i < layerNum; i++) layerNode.add(store.poll());
            res.add(layerNode.get(layerNum - 1).val);

            layerNum = 0;
            for (TreeNode cur : layerNode) {
                if (cur.left != null) {
                    store.offer(cur.left);
                    layerNum++;
                }
                if (cur.right != null) {
                    store.offer(cur.right);
                    layerNum++;
                }
            }
        }
        return res;
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
