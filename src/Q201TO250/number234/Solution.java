package Q201TO250.number234;

/**
 * @author: Bright Chan
 * @date: 2020/10/23 10:42
 * @description: 快慢指针；反转链表
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = head, last = head;

        while (true) {
            // 奇数个数的时候，last节点可以正好走到最后
            if (last.next == null) break;
            // 偶数个数的时候，last节点走不到最后一个数
            else if (last.next.next == null) {
                last = last.next;
                break;
            }
            else {
                mid = mid.next;
                last = last.next.next;
            }
        }

        ListNode newHead = mid.next;
        mid.next = null;

        // 反转后半个链表
        if (newHead != null) {
            ListNode p = newHead, q = newHead.next, r;
            newHead.next = null;
            while (q != null) {
                r = q.next;
                q.next = p;
                p = q;
                q = r;
            }
        }

        while (head != null && last != null) {
            if (head.val != last.val) {
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
