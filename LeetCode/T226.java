/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class T226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode s = root.left;
        root.left = root.right;
        root.right = s;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
