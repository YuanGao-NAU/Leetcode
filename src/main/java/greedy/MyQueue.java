package greedy;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        if(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        } else if(!stack1.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return -1;
    }

    public int peek()  {
        if(!stack2.isEmpty()) {
            return stack2.peek();
        } else if(!stack1.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
        return -1;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.pop();
        myQueue.push(5);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
    }
}