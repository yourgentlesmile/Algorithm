/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 维护一个全局最大和
 * 然后开始计算节点，他有三种选择
 * 自身 + 左节点
 * 自身 + 右节点
 * 只选自身
 *
 * 比较三者中的最大值进行返回。
 * 在更新最大和的时候，是要考虑自身作为root的
 *
 * 所以需要比较 自身 + 左节点 + 右节点这种情况
 */
public class T124 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root) {
        if(root == null) return 0;
        //获取左子树最大值
        int leftMax = Math.max(0, dfs(root.left));
        //获取右子树最大值
        int rightMax = Math.max(0, dfs(root.right));
        //以自身作为root的情况
        int total = leftMax + rightMax + root.val;
        int real = root.val + Math.max(leftMax, rightMax);

        res = Math.max(res, Math.max(total, real));
        //返回给root，选取子树或者不选取子树
        return Math.max(real, root.val);
    }
}
