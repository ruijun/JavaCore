package leetcode.codetop;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @autor rj-liang
 * @date 2021/8/19 12:32 上午
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if (stack1 != null) {
            stack1.push(val);
        }
    }

    public int pop() {
        if (stack1 == null || stack2 == null) {
            return -1;
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
