package problems.leetcode.top_interview_questions.easy;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public String removeDuplicates(String S) {
        Stack<Character> charStack=new Stack<>();
        for (int i=0; i<S.length(); i++){
            char ch=S.charAt(i);
            if(!charStack.empty()){
                if(ch == charStack.peek()){
                    charStack.pop();
                }
                else{
                    charStack.push(ch);
                }

            }
            else{
                charStack.push(ch);
            }

        }
        StringBuilder sb=new StringBuilder();
        for (char item: charStack) {
            sb.append(item);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String st= "abbaca";
        System.out.println(new RemoveAdjacentDuplicates().removeDuplicates(st));
    }
}
