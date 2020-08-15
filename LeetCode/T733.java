/**
 * https://leetcode-cn.com/problems/flood-fill/
 * 简单DFS
 */
public class T733 {
    int[][] step = new int[][]{{1, 0},{-1, 0},{0, -1},{0, 1}};
    int color;
    int nc;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = image[sr][sc];
        nc = newColor;
        if(color != nc) {
            dfs(image, sr, sc);
        }
        return image;
    }
    public void dfs(int [][] image, int x, int y) {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length) return ;
        if(image[x][y] == color) {
            image[x][y] = nc;
        }else {
            return;
        }
        for(int i = 0; i < 4;i++) {
            dfs(image, x + step[i][0], y + step[i][1]);
        }
    }
}
