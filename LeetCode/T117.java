import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 */
public class T117 {
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
    }

    /**
     * 空间复杂度O(n)
     */
    public Node connect(Node root) {
        if(null == root) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Node tmp = null;
            while(size > 0) {
                if(null == tmp) {
                    tmp = q.poll();
                }else {
                    tmp.next = q.poll();
                    tmp = tmp.next;
                }
                if(null != tmp.left) q.offer(tmp.left);
                if(null != tmp.right) q.offer(tmp.right);
                size--;
            }
        }
        return root;
    }

    /**
     * 空间复杂度O(1)
     * 由于在当前层的时候是可以通过已存在的next指针进行下一层的遍历的
     * 所以不需要额外的队列来进行节点的存储，根节点由于没有后继节点，所以可以认为next指针已经构建完成
     */
    Node last = null;
    Node nextStart = null;
    public Node connect1(Node root) {
        if(null == root) return root;
        Node s = root;
        while(s != null) {
            last = null;
            nextStart = null;
            for(Node i = s; i != null;i = i.next) {
                if(null != i.left) {
                    handler(i.left);
                }
                if(null != i.right) {
                    handler(i.right);
                }
            }
            s = nextStart;
        }
        return root;
    }
    public void handler(Node r) {
        if(last != null) {
            last.next = r;
        }
        if(nextStart == null) {
            nextStart = r;
        }
        last = r;
    }
}
