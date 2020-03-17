package java7.daily.learning.pract;

import java.util.Stack;

/**
 * @ClassName Queue
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/17 22:45
 */

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//思路：栈1用来做入队列
    //栈2用来出队列，当栈2为空时，栈1全部出栈到栈2再出栈
public class Queue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        if(stack1.empty() &&  stack2.empty()){
            throw new RuntimeException("Queue is empty");
        }
        if(stack2.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
