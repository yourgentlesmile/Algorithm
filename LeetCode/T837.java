/**
 * https://leetcode-cn.com/problems/new-21-game/
 * 动态规划，反序求解
 *
 * 以 21,17,10为例：
 * 最大的数字和为26，所以DP数组长度为27
 * 当数字和为16时，只剩一次抽取机会，所以在1-10中，只有5个数字加上16是小于21的，另外5个加上则大于21
 * 所以，16这个数字的前提下，不超过21的概率为 17不超过21的概率 + 18不超过21的概率、、、、、、
 * 因此是(1+1+1+1+1+0+0+0+0+0) / 10
 * 那15 则要看 16不超过21的概率 + 17不超过21的概率、、、、、
 * 用S来保存最开始临界数字时符合要求的案例和
 * S = S - DP[26] + DP[16]
 * 即 S = S - DP[I + W] + DP[I]
 * 因此是DP[15] = S / W
 */
public class T837 {
    public static void main(String[] args) {
        System.out.println(new21Game(21,17,10));
    }
    // 21 17 10
    public static double new21Game(int N, int K, int W) {
        double w = W;
        double[] dp = new double[N + W];
        double s = 0.0;
        for(int i = K;i < N + W;i++) {
            dp[i] = i <= N ? 1 : 0;
            s += dp[i];
        }
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = s / w;
            s = s - dp[i + W] + dp[i];
        }
        return dp[0];
    }
}
