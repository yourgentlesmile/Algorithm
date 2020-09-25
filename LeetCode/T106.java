import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * 递归构建
 *
 * 由于后续遍历从后往前看，先是根节点，然后是右子树的值，再是左子树的值
 * 因此在构建的时候，要先构建右子树，再构建左子树
 */
public class T106 {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    Map<Integer, Integer> map = new HashMap<>();
    int[] in;
    int[] post;
    int root;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        root = postorder.length - 1;
        int i = 0;
        for(int c : inorder) {
            map.put(c, i++);
        }
        return build(0, in.length - 1);
    }
    public TreeNode build(int left, int right) {
        if(left > right) return null;
        TreeNode treeNode = new TreeNode(post[root]);
        root--;
        int div = map.get(treeNode.val);
        //此处一定要注意，先构建右子树，原因见开头
        treeNode.right = build(div + 1, right);
        treeNode.left = build(left, div - 1);
        return treeNode;
    }
}
