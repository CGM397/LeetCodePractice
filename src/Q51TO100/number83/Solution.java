package Q51TO100.number83;

/**
 * @author: Bright Chan
 * @date: 2020/11/5 11:53
 * @description: 链表，双指针
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode cur = head, next = head.next;

        while (next != null) {
            if (cur.val == next.val) {
                while (next != null && next.val == cur.val) next = next.next;
                cur.next = next;
                cur = next;
                if (next != null) next = next.next;
            }
            else {
                cur = next;
                next = next.next;
            }
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
