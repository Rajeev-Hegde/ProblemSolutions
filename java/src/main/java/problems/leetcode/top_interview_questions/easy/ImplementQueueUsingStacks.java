package problems.leetcode.top_interview_questions.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> values;
    Stack<Integer> temp;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        this.values = new Stack<>();
        this.temp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(values.isEmpty())
            values.push(x);
        else{
            while(!values.isEmpty()){
                temp.push(values.pop());
            }
            values.push(x);
            while(!temp.isEmpty()){
                values.push(temp.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return values.pop();
    }

    /** Get the front element. */
    public int peek() {
        return values.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return values.isEmpty();
    }
}
