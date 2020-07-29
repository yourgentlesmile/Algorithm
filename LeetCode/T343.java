import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/integer-break/
 *
 * 记忆化DP
 * 数学方法：当拆分的数字为3的时候，乘积最大
 * https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
 * 例如：13 -> 3 * 3 * 3 * 3 * 1
 */
public class T343 {
    Map<Integer,Integer> memo = new HashMap<>();
    {
        memo.put(1,1);
    }
    public int integerBreak(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        int max = 0;
        for(int i = 1;i <= (n % 2 == 0 ? n / 2 : (n / 2 + 1)) ;i++) {
            int sub = integerBreak(n - i);
            sub = Math.max(sub, n -i);
            memo.put(n - i, sub);
            max = Math.max(max,i * sub);
        }
        return max;
    }
    public int mathSolution(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
