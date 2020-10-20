import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * 使用双端队列，先将所有节点放入队列中，再从队列两端取节点进行组合
 * 需要注意取完头的时候队列为空(奇数个节点)
 * 以及最后节点的next置空避免出现环
 */
public class T143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if(head == null) return ;
        Deque<ListNode> d = new LinkedList<>();
        while(head != null) {
            d.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while(!d.isEmpty()) {
            ListNode left = d.pollFirst();
            if(d.isEmpty()) {
                dummy.next = left;
                left.next = null;
                break;
            } else {
                left.next = d.pollLast();
                left.next.next = null;
                dummy.next = left;
                dummy = left.next;
            }
        }
    }
}
