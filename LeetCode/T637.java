import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 * 层序遍历
 */
public class T637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        double sum = 0;
        int nums = 0;
        TreeNode barrier = null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i < size;i++) {
                TreeNode c = queue.poll();
                sum += c.val;
                nums++;
                if(c.left != null) queue.offer(c.left);
                if(c.right != null) queue.offer(c.right);
            }
            res.add(sum / nums);
            sum = 0;
            nums = 0;
        }
        return res;
    }
}
