package Q51TO100.number82;

/**
 * @author: Bright Chan
 * @date: 2020/11/5 11:39
 * @description: 链表，双指针
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        pre.next = head;
        ListNode cur = head, next = head.next;

        while (next != null) {
            if (cur.val == next.val) {
                while (next != null && next.val == cur.val) next = next.next;
                pre.next = next;
                cur = next;
                if (next != null) next = next.next;
            }
            else {
                pre = cur;
                cur = next;
                next = next.next;
            }
        }

        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
