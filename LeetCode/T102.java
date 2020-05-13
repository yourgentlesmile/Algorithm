import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class T102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<Integer> work = new ArrayList<>();
    List<List<Integer>> answer = new ArrayList<>();
    int barrier = -10000000;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        queue.add(root);
        queue.add(new TreeNode(barrier));
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.val == barrier) {
                if(!work.isEmpty()) answer.add(work);
                else work = new ArrayList<>();
                if(!queue.isEmpty()) {
                    queue.add(new TreeNode(barrier));
                }
            }else {
                work.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return answer;
    }
}
