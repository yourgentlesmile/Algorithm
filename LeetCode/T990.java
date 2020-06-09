/**
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 该题目通过使用并查集来进行解题
 * 由于等号是具有传递性的，所以等号连接的变量一定属于同一个集合当中
 *
 * 当构建好了等号的集合时，只需要判断不等号连接的两个变量是否属于同一个集合
 * 如果属于同一个集合，则表示出现了语义矛盾，因为等和不等不能属于同一个集合
 *
 * parent[x] = parent[parent[x]]
 * 代表使用了隔代路径压缩(将父亲节点的父亲节点设置为自己的父节点)，可以减少查询根节点的查询次数
 *
 */
public class T990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '=') {
                int x = chars[0] - 'a';
                int y = chars[3] - 'a';
                unionFind.union(x, y);
            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if(chars[1] == '!') {
                int x = chars[0] - 'a';
                int y = chars[3] - 'a';
                if(unionFind.isConn(x, y)) return false;
            }
        }
        return true;
    }
    class UnionFind {
        private int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int l, int r) {
            int rootl = find(l);
            int rootr = find(r);
            parent[rootl] = rootr;
        }
        public boolean isConn(int x, int y) {
            return find(x) == find(y);
        }
    }
}
