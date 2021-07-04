package shopee.practice04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/7/4 17:06
 * @description: 树
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] store = Arrays.stream(scanner.nextLine().split(" "))
                                            .mapToInt(Integer::parseInt).toArray();

        Node root = buildTree(store);
        dfs(root);
        boolean first = true;
        for (int one : res) {
            if (first) {
                first = false;
                System.out.print(one);
            }
            else {
                System.out.print(" " + one);
            }
        }
        System.out.println();
    }

    private static List<Integer> res = new ArrayList<>();

    private static void dfs(Node root) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

    private static Node buildTree(int[] store) {
        Node root = new Node(store[0]);
        if (store.length == 1) {
            return root;
        }

        int index = 1;
        while(index < store.length && store[index] < store[0]) {
            index++;
        }
        // 有左子树
        if (index - 1 > 0) {
            root.left = buildTree(Arrays.copyOfRange(store, 1, index));
        }
        // 有右子树
        if (index < store.length) {
            root.right = buildTree(Arrays.copyOfRange(store, index, store.length));
        }

        return root;
    }

    private static class Node {
        public int val;
        public Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }
}
