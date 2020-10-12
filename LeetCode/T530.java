/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * 在搜索二叉树中，中序遍历出来的数据是有序的，相邻数字的差值是最小的，所以通过中序遍历可以解决问题
 */
public class T530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int minimum = Integer.MAX_VALUE;
    int prev = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minimum;
    }
    public void dfs(TreeNode r) {
        if(null == r) return;
        dfs(r.left);
        if(prev == -1) {
            prev = r.val;
        }else {
            minimum = Math.min(minimum, r.val - prev);
            prev = r.val;
        }
        dfs(r.right);
    }
}
