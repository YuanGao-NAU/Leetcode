package greedy;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int stackTop;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        stackTop = x;
        if(queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    public int pop() {
        int res = 0;
        if(!queue1.isEmpty()) {
            while(!queue1.isEmpty()) {
                res = queue1.peek();
                if(queue1.size() > 1) {
                    stackTop = res;
                    queue2.offer(res);
                }
                queue1.poll();
            }
        } else {
            while(!queue2.isEmpty()) {
                res = queue2.peek();
                if(queue2.size() > 1) {
                    stackTop = res;
                    queue1.offer(res);
                }
                queue2.poll();
            }
        }
        return res;
    }

    public int top() {
        return stackTop;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
    }
}
