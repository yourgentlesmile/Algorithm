import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * 搜索二叉树，中序遍历就是一个递增序列
 */
public class T501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int counter = 0;
    int cur = -9999;
    int maxCount = 0;
    ArrayList<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        dfs(root);

        if(counter > maxCount) {
            maxCount = counter;
            list.clear();
            list.add(cur);
        }else if(counter == maxCount) {
            list.add(cur);
        }
        int[] s = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            s[i] = list.get(i);
        }
        return s;
    }
    public void dfs(TreeNode r) {
        if(r == null) return;
        dfs(r.left);
        if(r.val != cur) {
            if(counter > maxCount) {
                maxCount = counter;
                list.clear();
                list.add(cur);
            }else if(counter == maxCount) {
                list.add(cur);
            }
            counter = 1;
            cur = r.val;
        }else {
            counter++;
        }
        dfs(r.right);
    }
}
