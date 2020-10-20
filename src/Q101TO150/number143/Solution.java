package Q101TO150.number143;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Bright Chan
 * @date: 2020/10/20 9:07
 * @description: 链表
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> store = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            store.add(tmp);
            tmp = tmp.next;
        }

        ListNode end = head;
        for (int i = 0; i < store.size() / 2; i++) {
            ListNode one = store.get(i);
            ListNode two = store.get(store.size() - 1 - i);
            one.next = two;
            if (i + 1 < store.size() / 2) two.next = store.get(i + 1);
            end = two;
        }

        if (store.size() % 2 != 0) {
            end.next = store.get(store.size() / 2);
            end.next.next = null;
        }
        else {
            end.next = null;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
