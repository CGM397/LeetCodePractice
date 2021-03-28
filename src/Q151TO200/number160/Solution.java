package Q151TO200.number160;

/**
 * @author: Bright Chan
 * @date: 2021/3/27 15:39
 * @description: 链表
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail = headA;
        while (tail.next != null) tail = tail.next;

        tail.next = headB;

        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode tmp = headA;
                while (tmp != slow) {
                    tmp = tmp.next;
                    slow = slow.next;
                }
                tail.next = null;
                return slow;
            }
        }
        tail.next = null;
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
