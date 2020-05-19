import java.util.PriorityQueue;
import java.util.Queue;

/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020/5/19 17:53.
 */
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for(ListNode a : lists) {
            if(a != null) heap.offer(a);
        }
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pointer.next = cur;
            pointer = cur;
            if(cur.next != null) {
                heap.offer(cur.next);
            }
        }
        pointer.next = null;
        return dummy.next;
    }
}
