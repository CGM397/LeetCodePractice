package Q101TO150.number109;

/**
 * @author: Bright Chan
 * @date: 2020/8/18 12:17
 * @description: AVL树，平衡的二叉搜索树
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = new TreeNode(head.val);
        TreeNode unbalancedNode, tmp, fatherNode;
        boolean flag;
        //构建AVL树
        while (head.next != null) {
            flag = false;
            root = insert(root, head.next.val);
            unbalancedNode = findUnbalancedNode(root);
            if (unbalancedNode == root) flag = true;
            if (unbalancedNode != null) {
                tmp = singleRightRotation(unbalancedNode);
                if (flag) {
                    root = tmp;
                }
                else {
                    fatherNode = findFatherNode(root, unbalancedNode.val);
                    fatherNode.right = tmp;
                }
            }
            head = head.next;
        }

        return root;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        else {
            if (root.val > val) {
                root.left = insert(root.left, val);
            }
            else if (root.val < val) {
                root.right = insert(root.right, val);
            }
        }
        return root;
    }

    private TreeNode findUnbalancedNode(TreeNode root) {
        if (root == null) return null;
        else {
            TreeNode tmp = findUnbalancedNode(root.right);
            if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
                return tmp;
            }
            else {
                if (tmp != null) return tmp;
                else return root;
            }
        }
    }

    private TreeNode singleRightRotation(TreeNode root) {
        TreeNode tmp = root.right;
        root.right = tmp.left;
        tmp.left = root;
        return tmp;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    private TreeNode findFatherNode(TreeNode root, int val) {
        if (root == null) return null;
        else {
            if (root.left.val == val || root.right.val == val) return root;

            if (root.val > val) return findFatherNode(root.left, val);
            else return findFatherNode(root.right, val);
        }
    }

    public TreeNode  niceSolution(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);

        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //找到链表的中点p，快慢指针
        while(q != null && q.next != null){
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        //将中点左边的链表分开
        pre.next = null;

        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);

        return root;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}