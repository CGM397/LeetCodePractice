package Q501TO550.number501;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/9/24 18:55
 * @description: 深搜
 */
public class Solution {

    private int maxNum = 0, count = 0, preVal = 0;
    private boolean first = true;
    private List<Integer> store = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        dfs(root);
        if (count > maxNum) {
            return new int[]{preVal};
        }
        else if (count == maxNum) {
            store.add(preVal);
        }

        int[] res = new int[store.size()];
        for (int i = 0; i < store.size(); i++) {
            res[i] = store.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (first) {
            preVal = root.val;
            count = 1;
            first = false;
        }
        else {
            if (preVal != root.val) {
                if (count > maxNum) {
                    maxNum = count;
                    store.clear();
                    store.add(preVal);
                }
                else if (count == maxNum) {
                    store.add(preVal);
                }

                preVal = root.val;
                count = 1;
            }
            else {
                count++;
            }
        }

        dfs(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
