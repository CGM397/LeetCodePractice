package Q51TO100.number61;

/**
 * @author: Bright Chan
 * @date: 2020/9/5 10:25
 * @description: 链表
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        for (int i = 0; i < k % count; i++) {
            head = rotateOne(head);
        }
        return head;
    }

    private ListNode rotateOne(ListNode head) {
        ListNode tmp = head, store = new ListNode(0);
        while(tmp.next != null){
            if (tmp.next.next == null) {
                store = new ListNode(tmp.next.val);
                tmp.next = null;
                break;
            }
            tmp = tmp.next;
        }
        store.next = head;
        return store;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
