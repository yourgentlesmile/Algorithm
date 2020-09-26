import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-stack-sequences/
 *
 */
public class T946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int ta = 0;
        Stack<Integer> stack = new Stack<>();
        for(int c : pushed) {
            stack.push(c);
            while(!stack.isEmpty() && ta < popped.length && popped[ta] == stack.peek()) {
                stack.pop();
                ta++;
            }
        }
        return ta == popped.length;
    }
}
