import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 */
public class T1162 {
    public static int maxDistance(int[][] grid) {
        Queue<Integer> land = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    land.add((i << 8) + j);
                }
            }
        }
        if(land.isEmpty()) return -1;
        int[] op_x = {0, 0, 1, -1};
        int[] op_y = {1, -1, 0, 0};
        boolean hasOcean = false;
        int maxDis = -1;
        while (!land.isEmpty()) {
            int mark = land.poll();
            int x = mark >> 8;
            int y = mark & ((1 << 8) - 1);
            for (int i = 0; i < op_x.length; i++) {
                int newx = x + op_x[i];
                int newy = y + op_y[i];
                if(newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length || grid[newx][newy] != 0 ) {
                    continue;
                }
                grid[newx][newy] = grid[x][y] + 1;
                maxDis = grid[newx][newy];
                hasOcean = true;
                land.add((newx << 8) + newy);
            }
        }
        if(!hasOcean) return - 1;
        return maxDis - 1;
    }
    public static void main(String[] args) {
        int[][] s = new int[][]{{0,0,1,1,1},{0,1,1,0,0},{0,0,1,1,0},{1,0,0,0,0},{1,1,0,0,1}};
        System.out.println(maxDistance(s));
    }
}
