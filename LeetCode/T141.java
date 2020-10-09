/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针
 *
 */
public class T141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        while(slow != null && faster != null) {
            slow = slow.next;
            if(faster.next != null) {
                faster = faster.next.next;
            }else {
                faster = null;
            }
            if(faster == slow && faster != null) {
                return true;
            }
        }
        return false;
    }
}
