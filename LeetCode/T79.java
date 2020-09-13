/**
 * https://leetcode-cn.com/problems/word-search/
 *
 * 枚举起始点，DFS
 */
public class T79 {
    boolean[][] vis;
    int[][] ac = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(board[i][j] == word.charAt(0) && bfs(board, word.toCharArray(), 1, i, j)) return true;
            }
        }
        return false;
    }
    public boolean bfs(char[][] board, char[] t, int index, int x ,int y) {
        if(index == t.length) return true;
        vis[x][y] = true;
        for(int i = 0;i < ac.length;i++) {
            if(x + ac[i][0] >= 0 &&
            x + ac[i][0] < board.length &&
            y + ac[i][1] >= 0 &&
            y + ac[i][1] < board[0].length &&
            board[x + ac[i][0]][y + ac[i][1]] == t[index] &&
            !vis[x + ac[i][0]][y + ac[i][1]]) {
                if(bfs(board, t, index + 1, x + ac[i][0], y + ac[i][1])) return true;
            }
        }
        //由于需要枚举起始点，上一个起始点遍历过的状态需要回退供下一次DFS使用
        vis[x][y] = false;
        return false;
    }
}
