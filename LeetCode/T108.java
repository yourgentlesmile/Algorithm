/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 由于是有序数组，且要高度平衡，只要取数组中点作为根节点进行递归构建就可以了
 *
 */
public class T108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    public TreeNode build(int[] a, int l,int r) {
        if(l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = build(a, l, mid - 1);
        root.right = build(a, mid + 1, r);
        return root;
    }
}
