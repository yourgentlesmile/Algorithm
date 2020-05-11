package offer;

import java.util.Stack;

public class QueueImplByStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private boolean mode = true;
    //false 代表头部在栈顶，true代表尾部在栈顶
    public QueueImplByStack() {

    }

    public void appendTail(int value) {
        if(mode) {
            s2.push(value);
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s2.push(value);
            mode = true;
        }
    }

    public int deleteHead() {
        int re;
        if(s1.isEmpty() && s2.isEmpty()) return -1;
        if(mode) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            re = s1.pop();
            mode = false;
        } else {
            re = s1.pop();
        }
        return re;
    }
    class BestAnswer {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2 ;
        public BestAnswer() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {


            stack1.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }

            if (stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
