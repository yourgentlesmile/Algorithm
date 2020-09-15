import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * 回溯，也可以用状态压缩进一步优化
 */
public class T37 {
    Map<Integer, Set<Character>> map = new HashMap<>();
    Map<Integer, Set<Character>> r = new HashMap<>();
    Map<Integer, Set<Character>> c = new HashMap<>();
    int counter = 0;
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < board.length;i++) {
            r.put(i, new HashSet<>());
            for(int j = 0; j < board[0].length;j++) {
                Set<Character> col = c.getOrDefault(j, new HashSet<>());
                Set<Character> sub = map.getOrDefault((i / 3 * 3) + j / 3, new HashSet<>());
                Set<Character> row = r.get(i);
                if(board[i][j] == '.') counter++;
                if(board[i][j] != '.') {
                    col.add(board[i][j]);
                    sub.add(board[i][j]);
                    row.add(board[i][j]);
                    r.put(i ,row);
                    c.put(j, col);
                    map.put((i / 3 * 3) + j / 3, sub);
                }
            }
        }
        dfs(board, 0, 0);

    }
    public boolean dfs(char[][] b, int x, int y) {
        if(counter == 0)
            return true;
        if(x > b.length || y > b[0].length)
            return false;
        while(b[x][y] != '.') {
            y++;
            if(y >= b[0].length) {
                x++;
                y = 0;
            }
            if(x > b.length)
                return false;
        }

        int nextX = x;
        int nextY = y + 1;
        if(nextY >= b[0].length) {
            nextX++;
            nextY = 0;
        }
        for(int i = 1; i <= 9;i++) {
            Set<Character> col = c.getOrDefault(y, new HashSet<>());
            Set<Character> sub = map.getOrDefault((x / 3 * 3) + y / 3, new HashSet<>());
            Set<Character> row = r.get(x);
            char candidate = (char)(i + '0');
            if(!col.contains(candidate) && !sub.contains(candidate) && !row.contains(candidate)) {
                b[x][y] = candidate;
                col.add(candidate);
                sub.add(candidate);
                row.add(candidate);
                c.put(y, col);
                map.put((x / 3 * 3) + y / 3, sub);
                counter--;
                if(dfs(b, nextX, nextY)) {
                    return true;
                }
                b[x][y] = '.';
                col.remove(candidate);
                sub.remove(candidate);
                row.remove(candidate);
                counter++;
            }
        }
        return false;
    }
}
