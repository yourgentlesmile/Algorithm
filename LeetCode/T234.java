/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 快慢指针先找到链表中点
 * 之后将后半部链表翻转
 * 最后进行比较，比较时的循环退出条件是后半段链表遍历完成
 * 因为，当链表个数为奇数个时，中点归属在左边链表，中点是不用参与比较的
 * 所以决定比较长度的是右半段链表
 */
public class T234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode re = null;
        ListNode nHalf = slow.next;
        while(nHalf != null) {
            ListNode tmp = nHalf.next;
            nHalf.next = re;
            re = nHalf;
            nHalf = tmp;
        }
        while(re != null) {
            if(head.val != re.val) return false;
            re = re.next;
            head = head.next;
        }
        return true;
    }
}
