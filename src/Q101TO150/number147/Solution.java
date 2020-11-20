package Q101TO150.number147;

/**
 * @author: Bright Chan
 * @date: 2020/11/20 18:30
 * @description: 插入排序
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sortedHead = head, unsortedHead = head.next;
        sortedHead.next = null;

        while (unsortedHead != null) {
            ListNode cur = sortedHead, pre = null;

            while (cur != null && cur != unsortedHead) {
                if (unsortedHead.val <= cur.val) {
                    ListNode tmp = new ListNode(unsortedHead.val);
                    if (pre == null) {
                        tmp.next = cur;
                        sortedHead = tmp;
                    }
                    else {
                        pre.next = tmp;
                        tmp.next = cur;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            if (cur == null || cur == unsortedHead) {
                ListNode tmp = new ListNode(unsortedHead.val);
                pre.next = tmp;
                tmp.next = cur;
            }

            unsortedHead = unsortedHead.next;
        }


        return sortedHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
