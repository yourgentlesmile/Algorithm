import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * 两种解法：
 * 1、通过栈实现，遇到#就POP
 * 2、双指针，从尾部开始遍历
 */
public class T844 {
    public boolean backspaceCompare(String S, String T) {
        return extract(S).equals(extract(T));
    }
    public String extract(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c != '#') {
                stack.push(c);
            }else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        String left = null;
        if(stack.size() == 0) left = "";
        else {
            int index = stack.size();
            char[] a = new char[index];
            index--;
            while(index >= 0) {
                a[index--] = stack.pop();
            }
            left = new String(a);
        }
        return left;
    }
}
