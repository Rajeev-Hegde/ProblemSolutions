package problems.interviewbit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {

    public int evalRPN(ArrayList<String> A) {

        Stack<Integer> numbersStack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {

            String val = A.get(i);
            if(val.matches("-?[0-9]+"))
                numbersStack.push(Integer.valueOf(val));
            else {
                int num2 = numbersStack.pop();
                int num1 = numbersStack.pop();
                switch (val) {

                    case "/":
                        numbersStack.push(num1 / num2);
                        break;
                    case "*":
                        numbersStack.push(num1 * num2);
                        break;
                    case "-":
                        numbersStack.push(num1 - num2);
                        break;
                    case "+":
                        numbersStack.push(num1 + num2);
                        break;
                }
            }
        }
        return numbersStack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList("-2", "1", "+", "3", "*"))));
        System.out.println(new EvaluateExpression().evalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"))));
    }
}
