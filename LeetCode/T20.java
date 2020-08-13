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
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if(c == ']') {
                char t = stack.pop();
                if(t != '[') return false;
            } else if(c == '}'){
                char t = stack.pop();
                if(t != '{') return false;
            }else if(c == ')') {
                char t = stack.pop();
                if(t != '(') return false;
            }else {
                stack.push(c);
            }
        }
        return stack.size() == 1;
    }

}
