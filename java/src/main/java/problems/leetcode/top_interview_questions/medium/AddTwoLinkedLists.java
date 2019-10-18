package problems.leetcode.top_interview_questions.medium;

import problems.ListNode;

import java.util.Stack;

/**
 * IMPORTANT
 */
public class AddTwoLinkedLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        ListNode temp1= l1, temp2= l2;
        while(temp1!=null){
            stack1.push(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            stack2.push(temp2.val);
            temp2 = temp2.next;
        }

        int carry=0;
        ListNode res= null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int num= stack1.pop() + stack2.pop() + carry;
            res=attachNode(res,num);
            carry = num/10;
        }

        if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                int num = stack1.pop()+carry;
                res=attachNode(res,num);
                carry = num/10;
            }
        }
        else{
            while(!stack2.isEmpty()){
                int num = stack2.pop()+carry;
                res=attachNode(res,num);
                carry = num/10;
            }
        }

        if(carry==1){
            ListNode node = new ListNode(1);
            node.next= res;
            return node;
        }
        else return res;
    }

    private ListNode attachNode(ListNode res, int num){
        ListNode node = new ListNode(num%10);
        node.next= res;
        res=node;
        return res;
    }
}
