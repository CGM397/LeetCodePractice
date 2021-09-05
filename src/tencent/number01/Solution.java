package tencent.number01;

/**
 * @author: Bright Chan
 * @date: 2021/9/5 20:01
 * @description: 剪枝
 */
public class Solution {

    public ListNode solve (ListNode[] a) {
        ListNode res = new ListNode(0), head = res;
        while (true) {
            int nullNum = 0;
            for (int i = 0; i < a.length; i++) {
                ListNode one = a[i];
                if (one != null) {
                    head.next = one;

                    head = head.next;
                    a[i] = one.next;
                }
                else {
                    nullNum++;
                }
            }
            if (nullNum >= a.length - 1) {
                break;
            }
        }

        return res.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
