/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class T19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 这是找到待删除节点的前一个节点
     */
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
    /**
     * 这是直接找到当前节点，但是通过一个变量记录上一个节点
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode res = head;
        for(;n > 0;n--) {
            fast = fast.next;
        }
        ListNode prev = null;
        while(fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev != null) {
            prev.next = slow.next;
            return res;
        } else {
            return slow.next;
        }
    }
}
