package offer;

public class BuildBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder,int p1, int p2, int[] inorder, int i1, int i2) {
        if(p1 > p2 || i1 > i2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        for (int i = i1; i <= i2; i++) {
            if(inorder[i] == root.val) {
                root.left = buildTree(preorder,p1 + 1, p1 + i - i1, inorder, i1, i - 1);
                root.right = buildTree(preorder, p1 + i - i1 + 1, p2, inorder, i + 1, i2);
                break;
            }
        }
        return root;
    }
}
