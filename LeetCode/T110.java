/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class T110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    boolean s = true;
    public boolean isBalanced(TreeNode root) {
        height(root, 1);
        return s;
    }
    public int height(TreeNode r, int dep) {
        if(r == null) return dep;
        if(!s) return dep;
        int left = height(r.left, 1);
        int right = height(r.right, 1);
        if(Math.abs(left - right) > 1) s = false;
        return Math.max(left,right) + 1;
    }
}
