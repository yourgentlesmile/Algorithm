import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020-09-04 7:21.
 */
public class T257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<String> cache = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        cache.add(root.val + "");
        if(root.left == null && root.right == null) {
            res.add(String.join("->", cache));
        }
        if(root.left != null) binaryTreePaths(root.left);
        if(root.right != null) binaryTreePaths(root.right);
        cache.remove(cache.size() - 1);
        return res;
    }
}
