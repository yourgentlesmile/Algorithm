import java.util.*;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 */
public class T297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        List<Integer> res = new ArrayList();
        Deque<TreeNode> queue = new LinkedList<>();
        res.add(root.val);
        res.add(root.left == null ? null : root.left.val);
        res.add(root.right == null ? null : root.right.val);
        if(root.left != null) queue.offer(root.left);
        if(root.right != null) queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode c = queue.poll();
            res.add(c.left == null ? null : c.left.val);
            res.add(c.right == null ? null : c.right.val);
            if(c.left != null) queue.offer(c.left);
            if(c.right != null) queue.offer(c.right);
        }
        Object[] objects = res.toArray();
        int i = objects.length - 1;
        for (; i >= 0; i--) {
            if(objects[i] != null)
                break;
        }
        return Arrays.toString(Arrays.copyOf(objects,i + 1));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("[]")) return null;
        int counter = 3;
        String[] list = data.substring(1,data.length() - 1).split(",");
        TreeNode root = new TreeNode(getNumber(list[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        switch(list.length) {
            case 1: {
                return root;
            }
            case 2:{
                root.left = getNumber(list[1]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[1]));
                return root;
            }
            case 3: {
                root.left = getNumber(list[1]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[1]));
                root.right = getNumber(list[2]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[2]));
                return root;
            }
        }
        root.left = getNumber(list[1]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[1]));
        root.right = getNumber(list[2]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[2]));
        if(root.left != null) queue.offer(root.left);
        if(root.right != null) queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode c = queue.poll();
            int tmp = counter++;
            if(tmp < list.length) {
                c.left = getNumber(list[tmp]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[tmp]));
            }
            tmp = counter++;
            if(tmp < list.length) {
                c.right = getNumber(list[tmp]) == Integer.MAX_VALUE ? null : new TreeNode(getNumber(list[tmp]));
            }
            if(c.left != null) queue.offer(c.left);
            if(c.right != null) queue.offer(c.right);
        }
        return root;
    }
    public int getNumber(String s) {
        if("null".equals(s.trim())) return Integer.MAX_VALUE;
        else return Integer.valueOf(s.trim());
    }
    /*
        public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
     */
}
