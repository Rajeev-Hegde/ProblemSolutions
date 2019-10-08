package problems.leetcode.top_interview_questions.easy;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            char ch= s.charAt(i);
            if(isClosingCharacter(ch)){
                if(stack.isEmpty())
                    return false;
                char prevChar= stack.pop();
                if(getOpeningCharacter(ch)!=prevChar)
                    return false;
            }
            else
                stack.push(s.charAt(i));
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
    public char getOpeningCharacter(char ch){
        switch(ch){
            case '}': return '{';
            case ')': return '(';
            case ']': return '[';
        }
        return '~';
    }

    public boolean isClosingCharacter(char ch){
        return ch== ')'|| ch == '}' || ch== ']';
    }


    public static void main(String[] args) {
        new ValidParenthesis().isValid("()[]{}");
    }
}
