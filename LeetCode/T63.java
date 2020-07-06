/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * dp[i][j] = dp[i - 1][j] +dp[i][j - 1]
 */
public class T63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid[0].length;
        int l = obstacleGrid.length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[l - 1][w - 1] == 1) return 0;
        for(int i = 0;i < l; i++) {
            for(int j = 0;j < w;j++) {
                if(i == 0 && j == 0) continue;
                int ans = 0;
                if(i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) ans += dp[i - 1][j];
                if(j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) ans += dp[i][j - 1];
                dp[i][j] = ans;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
