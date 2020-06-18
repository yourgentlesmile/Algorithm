import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 * 使用map来保存每一层的的node，同层的node。后面的node会把前面的node
 * 覆盖，不过没有关系，因为在覆盖前，前面node下面的所有节点都已处理完毕
 *
 * 所以最后只要返回level = 0的node就是root
 */
public class T1028 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode recoverFromPreorder(String S) {
        int len = S.length();
        Map<Integer, TreeNode> map = new HashMap<>();
        int i = 0;
        while (i < len) {
            int count = 0;
            while (S.charAt(i) == '-') {
                i++;
                count++;
            }
            int j = i;
            while (i < len && S.charAt(i) != '-') {
                i++;
            }
            int val = Integer.parseInt(S.substring(j, i));
            TreeNode node = new TreeNode(val);
            map.put(count, node);
            TreeNode parent = map.get(count - 1);
            if (parent != null) {
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }
        return map.get(0);
    }
}
