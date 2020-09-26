import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 */
public class T113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> cache = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root,int e) {
        if(root == null) return res;
        cache.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == e) {
            res.add(new ArrayList<>(cache));
        }
        if(root.left != null) pathSum(root.left, e);
        if(root.right != null) pathSum(root.right, e);
        cache.remove(cache.size() - 1);
        sum -= root.val;
        return res;
    }
}
