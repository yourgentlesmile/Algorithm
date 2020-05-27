/**
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * 滑动窗口
 * 先计算前N个，然后左边不断退出窗口，右边的数字不断加入窗口，维护一个最大分数即可
 */
public class T1423 {
    public int maxScore(int[] cardPoints, int k) {
        if(cardPoints == null || cardPoints.length == 0) return -1;
        int maxScore = 0;
        for(int i = 0;i < k;i++) {
            maxScore += cardPoints[i];
        }
        int cur = maxScore;
        int m = k - 1;
        int p = k - 1;
        for(int i = cardPoints.length - 1;i >= cardPoints.length - k; i--) {
            cur = cur - cardPoints[p--] + cardPoints[i];
            maxScore = Math.max(cur,maxScore);
        }
        return maxScore;
    }
}
