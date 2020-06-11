import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 本题使用单调栈的方式即可解题
 * 基本思路：
 * 遇到比栈顶小的元素则直接入栈
 * 遇到比栈顶大的元素，则出栈并计算距离，之后再次判断栈顶元素与当前元素
 * 直到当前元素小于栈顶元素或者栈为空时，停止循环，将当前元素入栈
 * 只需扫描一遍数组，每个元素只入栈出栈一次
 * 时间复杂度O(N)
 */
public class T739 {
    public static int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return T;
        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < T.length;i++) {
            int t = T[i];
            while (!stack.isEmpty() && t > T[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }
}
