import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * 中序莫里斯遍历可以达到O(1)的空间复杂度
 *
 * 而单纯中序则要O(n)的空间复杂度
 */
public class T99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> c = new ArrayList<>();
        dfs(root, c);
        TreeNode r = null;
        TreeNode x = null;
        for(int i=0;i<c.size()-1;++i) {
            if(c.get(i).val>c.get(i+1).val) {
                r = c.get(i+1);
                if(x==null) {
                    x = c.get(i);
                }
            }
        }

        if(r != null && x != null) {
            int tmp = r.val;
            r.val = x.val;
            x.val = tmp;
        }
    }
    public void dfs(TreeNode root, ArrayList<TreeNode> list) {
        if(root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
