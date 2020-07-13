public class T174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int saver = dungeon[dungeon.length - 1][dungeon[0].length - 1];
        dp[dungeon.length - 1][dungeon[0].length - 1] = Math.min(saver, 0);
        for(int i = dungeon.length - 1;i >= 0;i--) {
            for(int j = dungeon[0].length - 1;j >= 0; j--) {
                if(i == dp.length - 1 && j == dp[0].length - 1) continue;
                int down = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE;
                if(i + 1 < dungeon.length) {
                    down = dp[i + 1][j];
                }
                if(j + 1 < dungeon[0].length) {
                    right = dp[i][j + 1];
                }
                int tmp = Math.max(down, right) + dungeon[i][j];
                dp[i][j] = Math.min(tmp, 0);
            }
        }
        return (dp[0][0] > 0) ? 1 : -dp[0][0] + 1;
    }
}
