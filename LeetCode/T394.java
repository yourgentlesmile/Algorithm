import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string
 * 关键在于，在发现子结构的时候先把当时组合好的结果字符串入栈
 * 子结构弹出的时候就将目前所存的字符串根据从操作数栈弹出来的数字进行循环
 * 之后加上弹出的字符串就是结果
 *
 */
public class T394 {
    public String decodeString(String ll) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> n = new Stack<>();
        Stack<String> s = new Stack<>();
        for (char c : ll.toCharArray()) {
            if(c == '[') {
                n.push(num);
                s.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if(c == ']') {
                int i = n.pop();
                String last = s.pop();
                StringBuilder tmp = new StringBuilder();
                for(int j = 0;j < i;j++) {
                    tmp.append(res.toString());
                }
                res = new StringBuilder(last + tmp);
            }else if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }else res.append(c);
        }
        return res.toString();
    }
}
