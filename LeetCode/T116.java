import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * 要求使用常数空间复杂度O(1)
 *
 * 层序遍历
 */
public class T116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    /**
     * 空间复杂度O(n)
     */
    public Node connect(Node root) {
        if(null == root) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node prev = null;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node tmp = q.poll();
                if(tmp.left != null) q.offer(tmp.left);
                if(tmp.right != null) q.offer(tmp.right);
                if(prev != null) {
                    prev.next = tmp;
                }
                prev = tmp;
                size--;
            }
            prev = null;
        }
        return root;
    }

    /**
     * 使用已存在的指针进行层序遍历，空间复杂度0(1)
     */
    public Node connectBest(Node root) {
        if(null == root) return null;;
        Node head = root;
        //保证最后一层不会进入遍历，因为最后一层的指针在上一层遍历的时候已经构建好了
        //这样可以少处理左右孩子为空的边界情况
        while(head.left != null) {
            Node c = head;
            while(c != null) {
                c.left.next = c.right;
                //孩子相邻节点的next可以通过被遍历节点的next指针来完成连接
                if(c.next != null) {
                    c.right.next = c.next.left;
                }
                c = c.next;
            }
            head = head.left;
        }
        return root;
    }
}
