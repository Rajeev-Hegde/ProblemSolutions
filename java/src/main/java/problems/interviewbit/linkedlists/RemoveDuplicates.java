package problems.interviewbit.linkedlists;


public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode B = A;
        while( B!=null && B.next!=null){
            if (B.next.val== B.val)
                B.next= B.next.next;
            else
                B= B.next;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(1);
        A.next.next.next = new ListNode(2);
        A.next.next.next.next=new ListNode(2);
        A.next.next.next.next.next = new ListNode(3);
        System.out.println(new RemoveDuplicates().deleteDuplicates(A));
    }
}
