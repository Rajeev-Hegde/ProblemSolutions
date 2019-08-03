package problems.interviewbit.linkedlists;

public class ListCycle {

    public ListNode detectCycle(ListNode a) {
        ListNode firstPointer = a;
        ListNode secondPointer = a;

        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;

            if (firstPointer == secondPointer) {
                break;
            }
        }

        if (secondPointer == null || secondPointer.next == null) return null;

        firstPointer = a;
        while (firstPointer != secondPointer) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(3);
        A.next.next.next.next=new ListNode(4);
        A.next.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next.next = A.next.next;
        System.out.println(new ListCycle().detectCycle(A));
    }
}
