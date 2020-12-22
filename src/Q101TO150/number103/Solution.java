package Q101TO150.number103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Bright Chan
 * @date: 2020/12/22 13:05
 * @description: 广度优先遍历
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);

        int nodeNumInLayer = 1;
        boolean left = true;
        while (!store.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            List<Integer> oneLayerRes = new ArrayList<>();
            for (int i = 0; i < nodeNumInLayer; i++) tmp.add(store.poll());
            nodeNumInLayer = 0;
            for (TreeNode one : tmp) {
                if (one.left != null) {
                    store.offer(one.left);
                    nodeNumInLayer++;
                }
                if (one.right != null) {
                    store.offer(one.right);
                    nodeNumInLayer++;
                }
            }
            if (left) {
                for (TreeNode one : tmp) {
                    oneLayerRes.add(one.val);
                }
                left = false;
            }
            else {
                for (int i = tmp.size() - 1; i >= 0; i--) {
                    oneLayerRes.add(tmp.get(i).val);
                }
                left = true;
            }
            res.add(oneLayerRes);


        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
