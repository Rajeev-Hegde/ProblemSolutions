package problems.interviewbit.linkedlists;

import com.google.gson.Gson;

public class ReorderList {

    public ListNode reorderList(ListNode A) {
        ListNode iterator;
        ListNode first = A;
        int i=0;
        while(A.next!=null){
            i++;
            A=A.next;
        }
        int k=(i%2==0)?i/2: (i+1)/2;
        iterator= first;
        while(k>0){
            iterator = iterator.next;
            k--;
        }
        ListNode reversedSecondHalf= iterator.next;
        iterator.next=null;
        ListNode reversedNodeHead = reverseNodes(reversedSecondHalf);
        A=first;
        while(A!=null){
            if(reversedNodeHead!=null){
                ListNode next=A.next;
                ListNode temp= reversedNodeHead;
                A.next = temp;
                reversedNodeHead=reversedNodeHead.next;
                temp.next=next;
                A=next;
            }
            else
                A=A.next;
        }
        return first;
    }


    public ListNode reverseNodes(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next=new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);
        System.out.println(new ReorderList().reorderList(A));
    }
}
