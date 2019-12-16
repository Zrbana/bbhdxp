package Simple.daily.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class ImplStackWithQueue {


    private Queue<Integer> q1;
    private Queue<Integer> q2 ;
    private int top;
    /**
     * Initialize your data structure here.
     */
    public ImplStackWithQueue() {

        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

// Push element x onto stack.
            q1.add(x);
            top = x;
        }



    /**
     * Removes the element on top of the stack and returns that element.
     */
    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Get the top element.
     */
    public int top() {

        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return q1.isEmpty();
    }

}

