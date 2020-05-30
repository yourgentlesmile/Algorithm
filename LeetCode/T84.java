import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 单调栈
 */
public class T84 {
    public static void main(String[] args) {
        int[] s = new int[]{2,1,5,6,2,3};
    }
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        int[] newArr = new int[heights.length + 2];
        System.arraycopy(heights,0, newArr,1,heights.length);
        int length = heights.length + 2;
        heights = newArr;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);//插入哨兵
        int max = 0;
        for (int i = 1; i < length; i++) {
            while (heights[stack.peek()] > heights[i]) {
                int c = stack.pop();
                int len = 0;
                max = Math.max(max, heights[c] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max;
    }
}
