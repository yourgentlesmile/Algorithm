import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class T107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode barrier = new TreeNode(Integer.MIN_VALUE);
        queue.offer(barrier);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(queue.isEmpty()) break;
            if(cur == barrier) {
                res.add(cache);
                cache = new ArrayList<>();
                queue.offer(barrier);
                continue;
            }
            cache.add(cur.val);
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }
        res.add(cache);
        Collections.reverse(res);
        return res;
    }
}
