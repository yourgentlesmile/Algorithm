import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii
 */
public class T445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<ListNode> a = new Stack<>();
        Stack<ListNode> b = new Stack<>();
        ListNode l = l1;
        ListNode r = l2;
        while (l != null || r != null) {
            if (l != null) {
                a.push(l);
                l = l.next;
            }
            if (r != null) {
                b.push(r);
                r = r.next;
            }
        }
        ListNode dummy = null;
        ListNode empty = new ListNode(0);
        int p = 0;
        while (!a.isEmpty() || !b.isEmpty()) {
            ListNode q;
            ListNode w;
            if (!a.isEmpty()) {
                q = a.pop();
            } else {
                q = empty;
            }
            if (!b.isEmpty()) {
                w = b.pop();
            } else {
                w = empty;
            }
            int cur = (q.val + w.val + p) % 10;
            p = (q.val + w.val + p) / 10;
            ListNode c = new ListNode(cur);
            c.next = dummy;
            dummy = c;
        }
        if (p != 0) {
            ListNode k = new ListNode(p);
            k.next = dummy;
            dummy = k;
        }
        return dummy;
    }
    public ListNode shorterAnswer(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}
