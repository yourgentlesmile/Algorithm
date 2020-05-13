/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class T19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode cur = null;
        for(int i = 0; i < n; i++) {
            front = front.next;
        }
        while(front != null) {
            front = front.next;
            cur = cur == null ? head : cur.next;
        }
        if(cur == null) return head.next;
        cur.next = cur.next.next;
        return head;
    }
}
