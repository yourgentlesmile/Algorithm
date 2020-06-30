package offer;

import java.util.Stack;

public class QueueImplByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2 ;
    public QueueImplByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty() && stack2.isEmpty()) return -1;
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }else {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
