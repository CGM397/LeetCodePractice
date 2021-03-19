package Q51TO100.number92;

/**
 * @author: Bright Chan
 * @date: 2021/3/18 9:14
 * @description: 链表
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null;
        ListNode start = head;
        for (int i = 0; i < left - 1; i++) {
            leftNode = start;
            start = start.next;
        }

        ListNode pre = start, cur = start.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        start.next = cur;
        if (leftNode != null) leftNode.next = pre;
        else return pre;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
