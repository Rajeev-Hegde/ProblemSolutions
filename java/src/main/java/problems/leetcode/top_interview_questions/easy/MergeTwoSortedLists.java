package problems.leetcode.top_interview_questions.easy;

import problems.ListNode;

public class MergeTwoSortedLists {

    public ListNode addNode(ListNode res, ListNode node){
        res.next = new ListNode(node.val);
        return res.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head=new ListNode(-1);
        ListNode res= head;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val <= l2.val){
                    res=addNode(res, l1);
                    l1= l1.next;
                }
                else{
                    res=addNode(res, l2);
                    l2=l2.next;
                }
            }
            else if(l1!=null){
                res=addNode(res, l1);
                l1= l1.next;
            }
            else {
                res=addNode(res, l2);
                l2= l2.next;
            }
        }
        return head.next;
    }
}
