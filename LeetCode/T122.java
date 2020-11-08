/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * 贪心算法，直接累加所有正收益区间即为答案
 */
public class T122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
