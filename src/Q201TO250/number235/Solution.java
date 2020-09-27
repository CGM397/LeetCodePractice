package Q201TO250.number235;

/**
 * @author: Bright Chan
 * @date: 2020/9/27 10:59
 * @description: 深搜；遍历
 */
public class Solution {

    /**
     * 我们从根节点开始遍历；
     * 如果当前节点的值大于 p 和 q 的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
     * 如果当前节点的值小于 p 和 q 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
     * 如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。
     * 此时，p 和 q 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
     * @param root 根节点
     * @param p p
     * @param q q
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    private int maxDepth = 0, depth = 0;
    private TreeNode res = null;
    public TreeNode myMethod(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val > q.val ? q : p, p.val > q.val ? p : q);
        return res;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;

        depth++;
        boolean hasP = isHasElement(root, p), hasQ = isHasElement(root, q);
        if (hasP && hasQ) {
            if (maxDepth < depth) {
                res = new TreeNode(root.val);
                maxDepth = depth;
            }
        }
        dfs(root.right, p, q);
        dfs(root.left, p, q);
        depth--;
    }

    private boolean isHasElement(TreeNode root, TreeNode p) {
        if (root == null) return false;

        if (root.val == p.val) return true;

        return isHasElement(root.left, p) || isHasElement(root.right, p);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
