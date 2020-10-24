import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/video-stitching/
 *
 * DP
 * 模式和零钱兑换1没有区别
 */
public class T1024 {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 10);
        dp[0] = 0;
        for(int i = 1;i <= T;i++) {
            for(int[] clip : clips) {
                if(clip[0] <= i && clip[1] >= i) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 10 ? -1 : dp[T];
    }
}
