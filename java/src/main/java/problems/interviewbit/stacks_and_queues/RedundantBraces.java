package problems.interviewbit.stacks_and_queues;

import java.util.Stack;

public class RedundantBraces {

    public int braces(String A) {
        Stack<Character> stack= new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);
            boolean validExpression= false;
            if(currentChar == ')'){
                if(stack.empty() || stack.peek()=='(')
                    return 1;
                while(stack.peek()!='('){
                    if(String.valueOf(stack.peek()).matches("[+\\-*/]"))
                        validExpression=true;
                    stack.pop();
                }
                if(!validExpression)
                    return 1;
                stack.pop();
            }
            else
                stack.push(currentChar);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new RedundantBraces().braces("((a+(a+b)))"));
    }
}
