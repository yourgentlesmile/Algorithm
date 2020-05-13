import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class T20 {
    public boolean isValid(String s) {
        char mode = '-';
        Stack<Character> stack = new Stack<>();
        char[] a = s.toCharArray();
        for(char i : a) {
            if(i == '(' || i == '[' || i == '{') {
                stack.push(i);
                if(i == '(') {
                    mode = (char)(i + 1);
                }else mode = (char)(i + 2);
            }
            else if((i == '}' || i == ']' || i == ')') && (mode == i || mode == '-')) {
                if(stack.isEmpty()) return false;
                stack.pop();
                if(stack.isEmpty()) mode = '-';
                else if(stack.peek() == '(') {
                    mode = (char) (stack.peek() + 1);
                }else mode = (char)(stack.peek() + 2);
            }else return false;
        }
        return stack.isEmpty();
    }
    public boolean bestAnswer(String s) {
        if(s == null || s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        return stack.empty();
    }

}
