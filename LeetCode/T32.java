import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 栈
 */
public class T32 {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                int t = stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    max = Math.max(max, i - t + 1);
                }
            }
        }
        return max;
    }
}
