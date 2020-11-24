/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class T222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int sum = 0;

    /**
     * 未使用到完全二叉树的性质
     */
    public int countNodes(TreeNode root) {
        count(root);
        return sum;
    }
    public void count(TreeNode r) {
        if(r == null) return;
        sum += 1;
        count(r.left);
        count(r.right);
    }

    /**
     * 官方使用到了性质
     * @param root
     * @return
     */
    public int bestAnswer(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
