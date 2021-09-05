package tencent.number04;

import java.util.Scanner;

/**
 * @author: Bright Chan
 * @date: 2021/9/5 21:06
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), l = scanner.nextInt(), r = scanner.nextInt();
        ListNode head = new ListNode(-1), tail = new ListNode(-1), first = new ListNode(n);
        head.right = first;
        first.left = head;
        first.right = tail;
        tail.left = first;

        while (true) {
            boolean hasOps = false;
            ListNode tmp = head.right;
            while (tmp != tail) {
                if (tmp.val > 1) {
                    ListNode one = new ListNode(tmp.val / 2);
                    ListNode two = new ListNode(tmp.val % 2);
                    ListNode three = new ListNode(tmp.val / 2);

                    ListNode pre = tmp.left;
                    ListNode next = tmp.right;

                    pre.right = one;
                    one.left = pre;

                    one.right = two;
                    two.left = one;

                    two.right = three;
                    three.left = two;

                    three.right = next;
                    next.left = three;

                    tmp = three;
                    hasOps = true;
                }
                tmp = tmp.right;
            }

            if (!hasOps) {
                break;
            }
        }

        ListNode tmp = head.right;
        int index = 1;
        while (index < l) {
            index++;
            tmp = tmp.right;
        }

        int count = 0;
        while (index <= r) {
            if (tmp.val == 1) count++;

            index++;
            tmp = tmp.right;
        }

        System.out.println(count);
    }

    public static class ListNode {
        int val;
        ListNode left = null, right = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
