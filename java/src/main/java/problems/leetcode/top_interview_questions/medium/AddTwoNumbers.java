package problems.leetcode.top_interview_questions.medium;

import problems.ListNode;

/**
 *
 *
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=null;
        ListNode temp=res;
        int carry=0;
        if(l1==null&& l2==null)
            return null;
        while(l1!=null|| l2!=null){
            int num = carry;
            if(l1!=null){
                num+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                num+=l2.val;
                l2=l2.next;
            }
            ListNode newNode = new ListNode(num%10);
            if(temp==null){
                res=newNode;
                temp=newNode;
            }
            else{
                temp.next=newNode;
                temp=newNode;
            }
            carry= num/10;
        }

        if(carry!=0){
            temp.next= new ListNode(carry);
        }
        return res;
    }
}
