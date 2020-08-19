/**
 * https://leetcode-cn.com/problems/minesweeper/
 * BFS
 */
public class T529 {
    int[][] direct = new int[][] {{-1, -1}, {-1, 0}, {-1, 1},{0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        bfs(board, click[0], click[1]);
        return board;
    }
    public void bfs(char[][] b, int x, int y) {
        int mine = countMine(b, x, y);
        if(mine > 0) {
            b[x][y] = (char)(mine + '0');
            return;
        }
        b[x][y] = 'B';
        for(int i = 0;i < direct.length;i++) {
            int m = x + direct[i][0];
            int n = y + direct[i][1];
            if(m >= 0 && m < b.length && n >= 0 && n < b[0].length) {
                if(b[m][n] == 'E') {
                    bfs(b, m, n);
                }
            }
        }

    }
    public int countMine(char[][] f, int x, int y) {
        int res = 0;
        for(int i = 0;i < direct.length;i++) {
            int a = x + direct[i][0];
            int b = y + direct[i][1];
            if(a >= 0 && a < f.length && b >= 0 && b < f[0].length) {
                if(f[a][b] == 'M') res++;
            }
        }
        return res;
    }
}
