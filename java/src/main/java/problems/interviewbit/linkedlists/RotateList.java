package problems.interviewbit.linkedlists;

public class RotateList {

    public ListNode rotateRight(ListNode A, int B) {

       int length = lengthOfList(A);

       int posToShift = B%length;

       ListNode currentPointer=A;

       int i=0;
       while(posToShift!=(length-i-1)){
           currentPointer= currentPointer.next;
           i++;
       }
       ListNode newHead= currentPointer.next;
       currentPointer.next=null;
       currentPointer= newHead;
       while (currentPointer.next!=null){
           currentPointer= currentPointer.next;
       }
       currentPointer.next=A;
       return newHead;
    }


    public int lengthOfList(ListNode A){
        ListNode pointer = A;
        int length=0;

        while(pointer!=null){
            pointer= pointer.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {

    }
}

