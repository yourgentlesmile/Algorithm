import java.util.*;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * DFS
 */
public class Demo {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    LinkedList<Integer> cache = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }
    public void dfs(TreeNode root, int remain) {
        cache.add(root.val);
        if(root.left == null && root.right == null) {
            if(remain - root.val == 0) {
                res.add(new ArrayList<>(cache));
                cache.removeLast();
                return;
            }
        }
        if(root.left != null) {
            dfs(root.left, remain - root.val);
        }
        if(root.right != null) dfs(root.right, remain - root.val);
        cache.removeLast();
    }
}
