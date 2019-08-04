package problems.interviewbit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinStack {


    List<Integer> elementsData = new ArrayList<>();
    List<Integer> orderedData = new ArrayList<>();

    public void push(int x) {
        elementsData.add(x);
        if(orderedData.isEmpty()|| x<= orderedData.get(orderedData.size()-1))
            orderedData.add(x);
    }

    public void pop() {
        if(elementsData.size()>0) {
            Integer removedElement=elementsData.remove(elementsData.size() - 1);
            if(!this.orderedData.isEmpty() && removedElement.intValue() == this.orderedData.get(this.orderedData.size()-1))
                this.orderedData.remove(this.orderedData.size()-1);
        }
    }

    public int top() {
        return elementsData.size() > 0 ? elementsData.get(elementsData.size() - 1) : -1;
    }

    public int getMin() {
        if(this.orderedData.isEmpty())
            return -1;
        return this.orderedData.get(orderedData.size()-1);
    }


    public static void main(String[] args) {
        final MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }


    /** Implementation Using Stack class
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        //mIndex = -1;
    }
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int num = stack.pop();
            if(num == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
     **/
}
