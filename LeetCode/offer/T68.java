package offer;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class T68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 两种情况：
         * 1、到了叶节点都没找到pq，直接返回null
         * 2、p，q谁先遇到就返回谁，因为继续走下去，后面的都是先找到的子节点
         */
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /**
         * 如果左右节点都没找到，则表示pq不在这颗子树上
         */
        if(left == right && left == null) return null;
        //如果左子树没找到，则表示两个节点都在右子树上，并且由于返回的一定是先找到的，所以直接返回找到的节点
        if(left == null) return right;
        //如果右子树没找到，则表示两个节点都在左子树上，并且由于返回的一定是先找到的，所以直接返回找到的节点
        if(right == null) return left;
        //左右子树都找到了节点，表示pq分布在左右子树上，所以公共祖先就是当前节点
        return root;
    }
}
