/**
 * https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 *
 * DFS + 记忆化搜索(避免相同点重复计算)
 */
public class T329 {
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        memo = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[0].length;j++) {
                int k = dfs(matrix, i, j, matrix[i][j]);
                System.out.println(k);
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
    public int dfs(int[][] m, int x, int y,int prev) {
        if(memo[x][y] != 0) return memo[x][y];
        int save = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        //UP
        if(x - 1 >= 0 && m[x - 1][y] > prev) {
            memo[x - 1][y] = Math.max(memo[x - 1][y],dfs(m, x - 1, y, m[x - 1][y]));
            save = Math.max(save,memo[x - 1][y]);
        }
        //DOWN
        if(x + 1 < m.length && m[x + 1][y] > prev) {
            memo[x + 1][y] = Math.max(memo[x + 1][y],dfs(m, x + 1, y, m[x + 1][y]));
            save = Math.max(save,memo[x + 1][y]);
        }
        //LEFT
        if(y - 1 >= 0 && m[x][y - 1] > prev) {
            memo[x][y - 1] = Math.max(memo[x][y - 1], dfs(m, x, y - 1, m[x][y - 1]));
            save = Math.max(memo[x][y - 1],save);
        }
        if(y + 1 < m[0].length && m[x][y + 1] > prev) {
            memo[x][y + 1] = Math.max(memo[x][y + 1], dfs(m, x, y + 1, m[x][y + 1]));
            save = Math.max(memo[x][y + 1],save);
        }
        memo[x][y] = 1 + save;
        return memo[x][y];
    }
}
