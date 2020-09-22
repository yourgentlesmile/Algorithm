/**
 * https://leetcode-cn.com/problems/binary-tree-cameras/
 *
 *
 */
public class T968 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(null == root) return 0;
        return dfs(root) == 0 ? res + 1 : res;
    }
    public int dfs(TreeNode r) {
        /**
         * 状态定义
         * 0 此节点未被子女所观测
         * 1 此节点已安装摄像头
         * 2 此节点被子女观测
         */

        //当父节点是一个叶子节点的时候，他的子节点要假定为已被其子女观测，因为在此假定下这个子节点的状态就会变为此节点未被观测
        if(null == r) return 2;
        int left = dfs(r.left);
        int right = dfs(r.right);
        //如果有一个子节点是出于未被观测的状态，则当前节点就要放置摄像头，并且这个优先级是最高的，要首先判断
        if(left == 0 || right == 0) {
            res++;
            return 1;
        //如果子节点有任意一个安装了摄像头，则当前节点状态为被子女观测
        }else if(left == 1 || right == 1) {
            return 2;
        //如果子女都被他们的子女所观测，则当前节点处于未被观测的状态
        }else {
            return 0;
        }
    }
}
