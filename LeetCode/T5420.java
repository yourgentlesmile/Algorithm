/**
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * 此题也可以使用单调栈的方式进行求解
 */
public class T5420 {
    public int[] finalPrices(int[] prices) {
        for(int i = 0;i < prices.length;i++) {
            int cur = prices[i];
            int cut = -1;
            for(int j  = i + 1; j < prices.length;j++) {
                if(prices[j] <= cur) {
                    cut = prices[j];
                    break;
                }
            }
            prices[i] = cur - (cut == -1 ? 0 : cut);
        }
        return prices;
    }
}
