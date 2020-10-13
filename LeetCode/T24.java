/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 */
public class T24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode h = dummy;
        while(head != null) {
            ListNode l = head;
            ListNode r = head.next;
            if(r != null) {
                head = r.next;
                dummy.next = swap(l, r);
            }else {
                dummy.next = l;
                head = null;
            }
            dummy = l;
        }
        dummy.next = null;
        return h.next;
    }
    public ListNode swap(ListNode l, ListNode r) {
        r.next = l;
        return r;
    }
}
