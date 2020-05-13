import java.util.Stack;

/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020/5/13 20:12.
 */
public class T25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        reverseKGroup(a, 2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = dummy;
        ListNode cur = dummy;
        do {
            for(int i = 0;i < k;i++) {
                front = front.next;
                if(front == null) return dummy.next;
            }
            ListNode[] tmp = reverse(cur, front);
            cur.next = tmp[0];
            cur = tmp[1];
            front = cur;
        } while(front != null);
        return dummy.next;
    }
    public static ListNode[] reverse(ListNode start, ListNode end) {
        ListNode after = end.next;
        Stack<ListNode> stack = new Stack<>();
        while(start.next != after) {
            stack.push(start.next);
            start = start.next;
        }
        ListNode head = stack.pop();
        ListNode top = head;
        while(!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        head.next = after;
        return new ListNode[]{top, head};
    }
}
