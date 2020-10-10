/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * 设链表头到环入口点的距离为A，环中slow指针走过的距离为B，环中相交点到入口点的距离为C, fast指针在环中走过的圈数为N
 * 因为 fast指针走过的距离为 A + B + N * (B + C)
 * 因为 slow指针走过的距离为 A + B
 * 因为 fast指针走过的距离长度是slow指针的两倍
 * 两式连等可得 2 * (A + B) = A + B + N * (B + C)
 * A = (N - 1) * B + N * C
 * 通过添加一个C 再减去一个C，凑出平方差公式 进行因式分解
 * 最终化简得：A = C + (N - 1) * (B + C)
 * 此时可以知道，链表头到环入口点得距离(A)等于 指针相交点到入口点的距离(C)
 * 所以，只要让一个指针从链表头往后走(步长与slow指针保持一致)，同时slow指针继续往前走，这俩指针最终相遇的地方就是入口点
 */
public class T142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode faster = head;
        ListNode h = head;
        while(slow != null && faster != null) {
            slow = slow.next;
            if(faster.next != null) {
                faster = faster.next.next;
            }else {
                faster = null;
            }
            if(faster == slow && faster != null) {
                //找到了相遇点，开始寻找入口点
                while(h != slow) {
                    h = h.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
