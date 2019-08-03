package problems.interviewbit.linkedlists;

import com.google.gson.Gson;

public class SwapListNodes {

    public ListNode swapPairs(ListNode A) {

        ListNode head = A;
        if(A.next!=null)
            head = A.next;
        ListNode prev=null;
        while(A!=null && A.next!=null){
            if(prev!=null)
               prev.next=A.next;
            ListNode nextNode=A.next;
            A.next=nextNode.next;
            nextNode.next=A;
            prev=A;
            A=A.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
//        A.next = new ListNode(2);
//        A.next.next = new ListNode(3);
//        A.next.next.next = new ListNode(4);
//        A.next.next.next.next=new ListNode(5);
        System.out.println(new Gson().toJson(new SwapListNodes().swapPairs(A)));
    }
}
