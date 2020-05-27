/**
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 每相加元素总和达到 sum / 3时重新统计，只要统计到三段符合要求即表示成立
 */
public class T1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int c : A) {
            sum += c;
        }
        if(sum % 3 != 0) return false;
        int subSum = 0;
        int ans = 0;
        for (int value : A) {
            subSum += value;
            if (subSum == sum / 3) {
                ans++;
                subSum = 0;
            }
            if (ans == 3) return true;
        }
        return false;
    }
}
