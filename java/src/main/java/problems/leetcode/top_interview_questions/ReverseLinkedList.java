package problems.leetcode.top_interview_questions;

import problems.ListNode;

public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while(head!=null){
            ListNode temp= head;
            head= head.next;
            temp.next=prev;
            prev=temp;
        }
        return prev;
    }

}
