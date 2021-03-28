package Q151TO200.number155;

import java.util.Stack;

/**
 * @author: Bright Chan
 * @date: 2021/3/27 15:28
 * @description: 栈
 */
public class MinStack {

    private Stack<Integer> store;

    private Stack<Integer> minStore;

    public MinStack() {
        this.store  = new Stack<>();
        this.minStore = new Stack<>();
    }

    public void push(int val) {
        store.push(val);
        if (minStore.isEmpty() || minStore.peek() >= val) {
            minStore.push(val);
        }
    }

    public void pop() {
        int res = store.pop();
        if (res == minStore.peek()) {
            minStore.pop();
        }
    }

    public int top() {
        return store.peek();
    }

    public int getMin() {
        if (minStore.isEmpty()) return 0;
        return minStore.peek();
    }
}
