package Q201TO250.number232;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2021/3/5 12:14
 * @description: 栈
 */
public class MyQueue {
    private Stack<Integer> one, two;

    /** Initialize your data structure here. */
    public MyQueue() {
        one = new Stack<>();
        two = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        one.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!one.isEmpty()) {
            two.push(one.pop());
        }
        int res = 0;
        if (!two.isEmpty()) res = two.pop();

        while (!two.isEmpty()) {
            one.push(two.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while (!one.isEmpty()) {
            two.push(one.pop());
        }
        int res = 0;
        if (!two.isEmpty()) res = two.peek();

        while (!two.isEmpty()) {
            one.push(two.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return one.isEmpty();
    }
}
