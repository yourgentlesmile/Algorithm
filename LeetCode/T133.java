import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 *
 */
public class T133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node c : node.neighbors) {
            Node deeper = cloneGraph(c);
            copy.neighbors.add(deeper);
        }
        // System.out.print(node.val);
        return copy;
    }
}
