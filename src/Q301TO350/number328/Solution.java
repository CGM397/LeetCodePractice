package Q301TO350.number328;

/**
 * @author: Bright Chan
 * @date: 2020/11/13 10:48
 * @description: 双指针
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, evenHead = head.next;
        ListNode even = evenHead;
        // 奇偶要一起改，不然会改变原来链表元素的next值
        while (odd.next != null) {
            ListNode tmp = odd.next.next;
            odd.next = tmp;
            if (tmp != null) odd = tmp;

            if (even.next != null) {
                ListNode tmp2 = even.next.next;
                even.next = tmp2;
                even = tmp2;
            }
        }
        odd.next = evenHead;
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
