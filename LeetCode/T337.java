import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 递归返回时，可以一次返回选与不选的结果，这样每个节点只访问一次，提高效率
 */
public class T337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
    class MyAnswer {
        Map<String,Integer> map = new HashMap<>();
        public int rob(TreeNode root) {
            return dfs(root,false);
        }
        public int dfs(TreeNode root, boolean preRob) {
            if(root == null) return 0;
            if(map.containsKey(root.toString() + preRob)) {
                return map.get(root.toString() + preRob);
            }
            int res = 0;
            if(preRob) {
                res = dfs(root.left, false) + dfs(root.right, false);
            }else {
                int s1 = dfs(root.left, false) + dfs(root.right, false);
                int s4 = dfs(root.left, true) + dfs(root.right, true) + root.val;
                res = Math.max(s1, s4);
            }
            map.put(root.toString() + preRob, res);
            return res;
        }
    }
}
