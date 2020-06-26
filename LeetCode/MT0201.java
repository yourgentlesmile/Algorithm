import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class MT0201 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        ListNode prev = new ListNode(0);
        prev.next = p;
        while(p != null) {
            if(set.contains(p.val)) {
                prev.next = p.next;
                p = p.next;
            }else {
                set.add(p.val);
                p = p.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
