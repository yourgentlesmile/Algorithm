/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * DFS BFS 均可
 * 从边界的O开始扩散并修改为其他字符，最后一次遍历，将没有被修改的O替换为X
 * 修改为的其他字符替换为O
 */
public class T130 {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        for(int i = 0;i < board.length;i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for(int i = 0;i < board[0].length;i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == 'k') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][] m, int x,int y) {
        int[][] direction = new int[][] {{1, 0},{0, 1},{-1, 0},{0, -1}};
        if(x < 0 || x >= m.length || y < 0 || y >= m[0].length) return ;
        if(m[x][y] == 'X' || m[x][y] == 'k') return;
        if(m[x][y] == 'O') m[x][y] = 'k';
        for(int i = 0;i < 4;i++) {
            dfs(m, x + direction[i][0], y + direction[i][1]);
        }
    }
}
