import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/is-graph-bipartite
 *
 * 通过DFS 或者 BFS 对点逐一染色，边的两边的点要染成不同颜色
 * 比如A ------ B，A染成红色则B要染成黑色。而跟B相邻的要染成红色。
 * 这样的规则下如果能染色成功，则表示是一个二分图
 */
public class T785 {
    public int RED = 1;
    public int BLACK = -1;
    public boolean isBipartite(int[][] graph) {
        int[] point = new int[graph.length];
        Stack<Integer> stack = new Stack<>();
        for(int a = 0;a < graph.length;a++) {
            if(point[a] != 0) continue;
            stack.push(a);
            point[a] = RED;
            while(!stack.isEmpty()) {
                int c = stack.pop();
                for(int i : graph[c]) {
                    if(point[i] == 0) {
                        point[i] = -point[c];
                        stack.push(i);
                    }else if(point[i] != -point[c]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
