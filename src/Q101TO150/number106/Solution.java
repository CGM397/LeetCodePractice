package Q101TO150.number106;

import java.util.Arrays;

/**
 * @author: Bright Chan
 * @date: 2020/9/25 22:39
 * @description: 深搜
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null
                || postorder.length < 1 || inorder.length < 1) return null;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                int[] leftInOrder = Arrays.copyOfRange(inorder, 0, i);
                int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, i);
                root.left = buildTree(leftInOrder, leftPostOrder);

                int[] rightInOrder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                int[] rightPostOrder = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                root.right = buildTree(rightInOrder, rightPostOrder);
                break;
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
}
