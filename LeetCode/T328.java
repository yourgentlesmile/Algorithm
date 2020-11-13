/**
 * todo
 *
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class T328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode oddres = odd;
        ListNode evenres = even;
        ListNode point = head;
        int flip = 1;
        while(point != null) {
            if(flip > 0) {
                even.next = point;
                even = even.next;
            }else {
                odd.next = point;
                odd = odd.next;
            }
            flip *= -1;
            point = point.next;
        }
        if(evenres.next == null) return null;
        even.next = oddres.next;
        odd.next = null;
        return evenres.next;
    }
}
