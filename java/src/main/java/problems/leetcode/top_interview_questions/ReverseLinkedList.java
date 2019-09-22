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


    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
