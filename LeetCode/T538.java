/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020-09-21 7:50.
 */
public class T538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    public int dfs(TreeNode r,int rightSum) {
        if(r == null) return rightSum;
        r.val += dfs(r.right, rightSum);
        return dfs(r.left, r.val);
    }
}
