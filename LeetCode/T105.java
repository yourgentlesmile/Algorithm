/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class T105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
        if(p1 > p2 || i1 > i2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        int mark = 0;
        for(int i = i1;i <= i2;i++) {
            if(root.val == inorder[i]) mark = i;
        }
        int overNum = mark - i1;
        root.left = build(preorder, inorder, p1 + 1, p1 + overNum, i1, mark - 1);
        // 0 + 1, 0 + 1;
        root.right = build(preorder, inorder, p1 + overNum + 1, p2, mark + 1, i2);
        return root;
    }
}
