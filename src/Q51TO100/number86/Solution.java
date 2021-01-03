package Q51TO100.number86;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Bright Chan
 * @date: 2021/1/3 10:29
 * @description: 模拟
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        Queue<Integer> lessThan = new LinkedList<>();
        Queue<Integer> moreThan = new LinkedList<>();

        while (head != null) {
            if (head.val < x) lessThan.offer(head.val);
            else moreThan.offer(head.val);
            head = head.next;
        }

        ListNode res = new ListNode(0);
        ListNode tmp = res;

        while (!lessThan.isEmpty()) {
            tmp.next = new ListNode(lessThan.poll());
            tmp = tmp.next;
        }
        while (!moreThan.isEmpty()) {
            tmp.next = new ListNode(moreThan.poll());
            tmp = tmp.next;
        }
        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
