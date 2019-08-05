package problems.interviewbit.linkedlists;

public class RemoveNthNodeFromListEnd {


    public ListNode removeNthFromEnd(ListNode A, int B) {

        int l = getLength(A);
        int stop = l - B;
        if (stop <= 0) {
            ListNode newHead = A.next;
            A = null;
            return newHead;
        }

        int count = 1;
        ListNode curr = A;
        while (count != stop) {
            curr = curr.next;
            count++;
        }

        curr.next = curr.next.next;

        return A;
    }

    public int getLength(ListNode A) {
        int l = 0;
        while (A != null) {
            A = A.next;
            l++;
        }

        return l;
    }

    public static void main(String[] args) {
    }
}
