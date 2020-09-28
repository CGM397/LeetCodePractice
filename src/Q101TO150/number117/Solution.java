package Q101TO150.number117;

/**
 * @author: Bright Chan
 * @date: 2020/9/28 9:07
 * @description: 广搜；深搜
 */
public class Solution {

    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }

    private int max = 0, count = 0;
    public Node mySlowMethod(Node root) {
        Node curNode, nextNode, tmp;
        getMaxDepth(root);

        for (int i = 0; i < max; i++) {
            curNode = null;
            for (int j = 1; j <= Math.pow(2, i); j++) {
                count = 0;
                tmp = dfs(root, 0, i, j);
                if (tmp == null) break;
                if (curNode == null) curNode = tmp;
                else {
                    nextNode = tmp;
                    curNode.next = nextNode;
                    curNode = nextNode;
                }

            }
        }
        return root;
    }

    private void getMaxDepth(Node root) {
        if (root == null) return;

        count++;
        if (count > max) max = count;

        getMaxDepth(root.left);
        getMaxDepth(root.right);
        count--;
    }

    private Node dfs(Node root, int depth, int maxDepth, int num) {
        if (root == null || count >= num) return null;

        if (depth == maxDepth) {
            count++;
            if (count == num) return root;
        }

        Node left = dfs(root.left, depth + 1, maxDepth, num);
        Node right = dfs(root.right, depth + 1, maxDepth, num);
        if (left != null) return left;
        return right;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};