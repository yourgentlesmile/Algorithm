/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class T2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l1_pointer = l1;
        ListNode l2_pointer = l2;
        ListNode root = new ListNode(0);
        ListNode result_pointer = root;
        int flag = 0;
        while (l1_pointer != null || l2_pointer != null) {
            int left = l1_pointer == null ? 0 : l1_pointer.val;
            int right = l2_pointer == null ? 0 : l2_pointer.val;
            result_pointer.next = new ListNode((left + right + flag) % 10);
            flag = (left + right + flag) >= 10 ? 1 : 0;
            result_pointer = result_pointer.next;
            if(l1_pointer != null) l1_pointer = l1_pointer.next;
            if(l2_pointer != null) l2_pointer = l2_pointer.next;
        }
        if(flag != 0 ){
            result_pointer.next = new ListNode(1);
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        ListNode listNode = addTwoNumbers(a, d);
        System.out.println(listNode);
    }
}
