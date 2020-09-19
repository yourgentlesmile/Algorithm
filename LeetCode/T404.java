/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class T404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return res;
    }
    public void dfs(TreeNode r, boolean left) {
        if(r == null) return;
        if(r.left == null && r.right == null && left) res += r.val;
        dfs(r.left, true);
        dfs(r.right, false);
    }
}
